package devs.example.apigym.Exception;

public class UserAlreadyExists extends RuntimeException {

	public UserAlreadyExists(String message) {
		super(message);
	}
}
