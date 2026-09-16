package devs.example.apigym.Config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component

public class TokenProvider {

	@Value("${jwt.expiration}")
	private Long expirationTime;

	@Value("${jwt.key}")
	private String key;

	public String gerarToken(Authentication authentication) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		return buildToken(userDetails.getUsername());
	}

	private String buildToken(String username) {
		Date now = new Date();
		Date expiration = new Date(now.getTime() + expirationTime);
		return Jwts.builder()
				.subject(username)
				.issuedAt(now)
				.expiration(expiration)
				.signWith(getSigningKey())
				.compact();
	}

	private SecretKey getSigningKey() {
		return Keys.hmacShaKeyFor(key.getBytes());
	}

	public boolean isTokenValid(String token) {
		try {
			getClaims(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private Claims getClaims(String token) {
		return Jwts.parser()
				.verifyWith(getSigningKey())
				.build()
				.parseSignedClaims(token)
				.getPayload();

	}


	public String catchUsername(String token){
		return getClaims(token).getSubject();
	}


}
