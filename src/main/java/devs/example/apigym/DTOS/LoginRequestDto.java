package devs.example.apigym.DTOS;
import devs.example.apigym.Model.Entities.User;
import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto(
		@NotBlank String email,
		@NotBlank String senha) {

	public LoginRequestDto(User user){
		this(
				user.getEmail(), user.getSenha()
		);
	}


}
