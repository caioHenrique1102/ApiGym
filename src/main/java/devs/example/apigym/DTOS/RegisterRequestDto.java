package devs.example.apigym.DTOS;
import devs.example.apigym.Model.Entities.User;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequestDto(
		@NotBlank String email,
		@NotBlank String senha) {

	public RegisterRequestDto(User user){
		this(
				user.getEmail(), user.getSenha()
		);
	}

}
