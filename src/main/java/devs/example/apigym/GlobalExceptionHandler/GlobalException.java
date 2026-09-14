package devs.example.apigym.GlobalExceptionHandler;

import devs.example.apigym.GlobalExceptionHandler.Exceptions.ExercicioAlreadyExists;
import devs.example.apigym.GlobalExceptionHandler.Exceptions.ExercicioNotFound;
import devs.example.apigym.GlobalExceptionHandler.Exceptions.TreinoAlreadyExists;
import devs.example.apigym.GlobalExceptionHandler.Exceptions.TreinoNotFound;
import devs.example.apigym.GlobalExceptionHandler.Exceptions.UserAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ExercicioNotFound.class)
	public ResponseEntity<String> ExercicioNotFoundHandler(ExercicioNotFound ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(ExercicioAlreadyExists.class)
	public ResponseEntity<String> ExercicioAlreadyExistsHandler(
			ExercicioAlreadyExists exercicioAlreadyExists) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exercicioAlreadyExists.getMessage());
	}

	@ExceptionHandler(TreinoAlreadyExists.class)
	public ResponseEntity<String> TreinoAlreadyExistsHandler(
			TreinoAlreadyExists treinoAlreadyExists) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(treinoAlreadyExists.getMessage());
	}

	@ExceptionHandler(TreinoNotFound.class)
	public ResponseEntity<String> TreinoNotFoundHandler(TreinoNotFound treinoNotFound) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(treinoNotFound.getMessage());
	}

	@ExceptionHandler(UserAlreadyExists.class)
	public ResponseEntity<String> UserAlreadyExistsHandler(UserAlreadyExists userAlreadyExists) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userAlreadyExists.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> ExceptionHandler(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
	}


}


