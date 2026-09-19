package devs.example.apigym.GlobalExceptionHandler.Exceptions;

public class UserNotFound extends RuntimeException {

	public UserNotFound(String message) {
		super(message);
	}
}
