package devs.example.apigym.GlobalExceptionHandler.Exceptions;

public class UserNotLinked extends RuntimeException {

	public UserNotLinked(String message) {
		super(message);
	}
}
