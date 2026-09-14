package devs.example.apigym.Controllers;


import devs.example.apigym.DTOS.LoginRequestDto;
import devs.example.apigym.DTOS.RegisterRequestDto;
import devs.example.apigym.DTOS.TokenReponseDTO;
import devs.example.apigym.Model.Entities.User;
import devs.example.apigym.Services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthenticationService authenticationService;

	@PostMapping("/register")
	public void register(@RequestBody @Valid RegisterRequestDto registerRequestDto) throws Exception {
		authenticationService.register(registerRequestDto);

	}

	@PostMapping("/login")
	public TokenReponseDTO login(@RequestBody @Valid LoginRequestDto loginRequestDto) throws Exception {
		return authenticationService.login(loginRequestDto);
	}

}
