package devs.example.apigym.GlobalExceptionHandler.Exceptions;

public class ExercicioAlreadyExists extends RuntimeException {

  public ExercicioAlreadyExists(String message) {
    super(message);
  }
}
