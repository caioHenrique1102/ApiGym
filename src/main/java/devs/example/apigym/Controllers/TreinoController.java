package devs.example.apigym.Controllers;

import devs.example.apigym.DTOS.TreinoDTO;
import devs.example.apigym.Model.Entities.Treino;
import devs.example.apigym.Services.TreinoService;
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
@RequestMapping("/treino")
@CrossOrigin
public class TreinoController {

	private final TreinoService treinoService;


	public TreinoController(TreinoService treinoService) {
		this.treinoService = treinoService;
	}

	@PostMapping("/create")
	public ResponseEntity<TreinoDTO> criarTreino(@RequestBody Treino treino) {
		TreinoDTO treinoDTO = treinoService.criar(treino);
		return ResponseEntity.status(HttpStatus.CREATED).body(treinoDTO);
	}

	@PutMapping("/alterar/{nome}")
	public ResponseEntity<TreinoDTO> alterar(@PathVariable String nome, @RequestBody Treino treino) {
		TreinoDTO treinoDTO = treinoService.alter(nome, treino);
		return ResponseEntity.status(HttpStatus.OK).body(treinoDTO);
	}

	@DeleteMapping("/delet/{nome}")
	public ResponseEntity<Void> delet(@PathVariable String nome) {
		treinoService.delete(nome);
		return ResponseEntity.status(HttpStatus.GONE).build();
	}

	@GetMapping("/search/{nome}")
	public ResponseEntity<TreinoDTO> listar(@PathVariable String nome){
		TreinoDTO treinoDTO = treinoService.listar(nome);
		return ResponseEntity.status(HttpStatus.OK).body(treinoDTO);
	}

	@PostMapping("/cadastrarExercicio/{nomeTreino}/{nomeExercicio}")
	public ResponseEntity<TreinoDTO> cadastrarExercicio(@PathVariable String nomeTreino, @PathVariable String nomeExercicio){
		TreinoDTO treinoDTO = treinoService.cadastrarExercicio(nomeTreino, nomeExercicio);
		return ResponseEntity.status(HttpStatus.OK).body(treinoDTO);
	}

}
