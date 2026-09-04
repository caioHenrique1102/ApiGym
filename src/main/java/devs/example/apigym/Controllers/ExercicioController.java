package devs.example.apigym.Controllers;

import devs.example.apigym.DTOS.ExercicioDTO;
import devs.example.apigym.Model.Entities.Exercicio;
import devs.example.apigym.Services.ExercicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercicio")
@CrossOrigin
public class ExercicioController {

  private final ExercicioService exercicioService;

  public ExercicioController(ExercicioService exercicioService) {
    this.exercicioService = exercicioService;
  }

  @PostMapping("/create")
  public ResponseEntity<ExercicioDTO> create(@RequestBody Exercicio exercicio) {
    ExercicioDTO exercicioCreated = exercicioService.save(exercicio);
    return ResponseEntity.status(HttpStatus.CREATED).body(exercicioCreated);
  }

  @DeleteMapping("/delet/{nome}")
  public ResponseEntity<Void> delet(@PathVariable String nome) {
    exercicioService.delet(nome);
    return ResponseEntity.status(HttpStatus.GONE).build();
  }

  @PutMapping("/alter/{nome}")
  public ResponseEntity<ExercicioDTO> alter(@PathVariable String nome,
      @RequestBody Exercicio exercicio) {
    ExercicioDTO exercicioModified = exercicioService.alter(nome, exercicio);
    return ResponseEntity.status(HttpStatus.OK).body(exercicioModified);

  }

  @GetMapping("/search/{nome}")
  public ResponseEntity<Exercicio> search(@PathVariable String nome) {
    Exercicio exercicioSearch = exercicioService.search(nome);
    return ResponseEntity.status(HttpStatus.FOUND).body(exercicioSearch);

  }

}
