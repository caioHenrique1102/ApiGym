package devs.example.apigym.GlobalExceptionHandler.Exceptions;

public class UserAlreadyExists extends RuntimeException {

	public UserAlreadyExists(String message) {
		super(message);
	}
}
