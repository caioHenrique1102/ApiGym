package devs.example.apigym.Services;

import devs.example.apigym.Config.TokenProvider;
import devs.example.apigym.DTOS.LoginRequestDto;
import devs.example.apigym.DTOS.RegisterRequestDto;
import devs.example.apigym.DTOS.TokenReponseDTO;
import devs.example.apigym.Enums.RolesEnum;
import devs.example.apigym.Exception.UserAlreadyExists;
import devs.example.apigym.Model.Entities.Roles;
import devs.example.apigym.Model.Entities.User;
import devs.example.apigym.Model.Repositorys.RolesRepository;
import devs.example.apigym.Model.Repositorys.UserRepository;
import java.util.Optional;
import java.util.Set;
import javax.naming.NamingException;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.models.annotations.internal.FilterAnnotation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UserRepository userRepository;
	private final RolesRepository rolesRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final TokenProvider tokenProvider;

	@Value("${jwt.expiration}")
  long expiration;

	public RegisterRequestDto register(RegisterRequestDto user) throws BadRequest {
		Optional<User> userOptional = userRepository.findByEmail(user.email());

		if (userOptional.isPresent()) throw new UserAlreadyExists("Usuário já existe!!!");

		Roles roles = rolesRepository.findByNome(RolesEnum.ROLE_USER.name())
				.orElseGet(() -> rolesRepository.save(Roles.builder().nome(RolesEnum.ROLE_USER.name()).build()));
		User userRegister = new User();
		userRegister.setEmail(user.email());
		userRegister.setSenha(passwordEncoder.encode(user.senha()));
		userRegister.setRoles(Set.of(roles));
		userRepository.save(userRegister);

		RegisterRequestDto registerRequestDto = new RegisterRequestDto(userRegister);

		return registerRequestDto;
	}

	public TokenReponseDTO login(LoginRequestDto loginRequestDto) throws Exception{

		try {
			 Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.email(), loginRequestDto.senha()));
     String token = tokenProvider.gerarToken(authentication);

		 return new TokenReponseDTO(token, expiration);
		}catch (BadCredentialsException e){
			throw new BadCredentialsException("Credenciais inválidas");
		}catch (Exception e){
			throw e;
		}

	}
}
