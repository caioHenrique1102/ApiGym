package devs.example.apigym.Controllers;

import devs.example.apigym.DTOS.TreinoResponseDTO;
import devs.example.apigym.Model.Entities.Treino;
import devs.example.apigym.Model.Entities.User;
import devs.example.apigym.Services.TreinoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Treino", description = "Tudo relacionado ao crud de treino")
public class TreinoController {

	private final TreinoService treinoService;


	public TreinoController(TreinoService treinoService) {
		this.treinoService = treinoService;
	}

	@Operation(summary = "create", description = "Cria o treino e salva no banco de dados")
	@PostMapping("/create")
	public ResponseEntity<TreinoResponseDTO> criarTreino(@RequestBody Treino treino) {
		TreinoResponseDTO treinoResponseDTO = treinoService.criar(treino);
		return ResponseEntity.status(HttpStatus.CREATED).body(treinoResponseDTO);
	}

	@Operation(summary = "alterar", description = "Busca o treino pelo nome e caso exista altera esse treino")
	@PutMapping("/alterar/{nome}")
	public ResponseEntity<TreinoResponseDTO> alterar(@PathVariable String nome, @RequestBody Treino treino) {
		TreinoResponseDTO treinoResponseDTO = treinoService.alter(nome, treino);
		return ResponseEntity.status(HttpStatus.OK).body(treinoResponseDTO);
	}

	@Operation(summary = "delet", description = "Busca o treino pelo nome e caso exista deleta esse treino")
	@DeleteMapping("/delet/{nome}")
	public ResponseEntity<Void> delet(@PathVariable String nome) {
		treinoService.delete(nome);
		return ResponseEntity.status(HttpStatus.GONE).build();
	}

	@Operation(summary = "Lista de treinos", description = "Lista todos os treinos associados ao usuário logado")
	@GetMapping("/meustreinos")
	public ResponseEntity<List<TreinoResponseDTO>> listar(@AuthenticationPrincipal User user) {
		List<TreinoResponseDTO> treinos = treinoService.listaTreinos(user.getId());
	return ResponseEntity.status(HttpStatus.OK).body(treinos);
	}

	@Operation(summary = "cadastrarExercicio", description = "Busca o treino e o exercício pelo nome e caso exista cadastra o exercício ao treino")
	@PostMapping("/cadastrarExercicio/{nomeTreino}/{nomeExercicio}")
	public ResponseEntity<TreinoResponseDTO> cadastrarExercicio(@PathVariable String nomeTreino,
			@PathVariable String nomeExercicio) {
		TreinoResponseDTO treinoResponseDTO = treinoService.cadastrarExercicio(nomeTreino, nomeExercicio);
		return ResponseEntity.status(HttpStatus.OK).body(treinoResponseDTO);
	}

}
