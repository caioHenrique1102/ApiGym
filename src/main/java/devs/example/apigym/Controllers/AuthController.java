package devs.example.apigym.Controllers;


import devs.example.apigym.DTOS.LoginRequestDto;
import devs.example.apigym.DTOS.RegisterRequestDto;
import devs.example.apigym.DTOS.TokenReponseDTO;
import devs.example.apigym.Services.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Auth", description = "Tudo relacionado a cadastro e login")
public class AuthController {

	private final AuthenticationService authenticationService;

	@Operation(summary = "Register", description = "Realiza o registro do usuário")
	@PostMapping("/register")
	public void register(@RequestBody @Valid RegisterRequestDto registerRequestDto) throws Exception {
		authenticationService.register(registerRequestDto);

	}

	@Operation(summary = "Login", description = "Realiza o login do usuário")
	@PostMapping("/login")
	public TokenReponseDTO login(@RequestBody @Valid LoginRequestDto loginRequestDto)
			throws Exception {
		return authenticationService.login(loginRequestDto);
	}

}
