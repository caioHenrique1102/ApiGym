package devs.example.apigym.Services;

import devs.example.apigym.DTOS.TreinoResponseDTO;
import devs.example.apigym.GlobalExceptionHandler.Exceptions.TreinoAlreadyExists;
import devs.example.apigym.GlobalExceptionHandler.Exceptions.TreinoNotFound;
import devs.example.apigym.Model.Entities.Exercicio;
import devs.example.apigym.Model.Entities.Treino;
import devs.example.apigym.Model.Entities.User;
import devs.example.apigym.Model.Repositorys.TreinoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TreinoService {

	private final TreinoRepository treinoRepository;
	private final ExercicioService exercicioService;
	private final UserService user;

	@Transactional
	public TreinoResponseDTO cadastrarExercicio(String nomeTreino, String nomeExercicio) {
		Treino treino = search(nomeTreino);
		Exercicio exercicio = exercicioService.search(nomeExercicio);
		treino.getExercicios().add(exercicio);
		TreinoResponseDTO treinoResponseDTO = new TreinoResponseDTO(treino);
		treinoRepository.save(treino);
		return treinoResponseDTO;
	}

	@Transactional
	public TreinoResponseDTO criar(Treino treino) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		User u = user.findUserByUsername(email);
		Optional<Treino> treinoFound = treinoRepository.findByNome(treino.getNome());
		if (treinoFound.isPresent()) {
			throw new TreinoAlreadyExists("O treino com o nome " + treino.getNome() + " já existe");
		}

		Treino treinoCreate = new Treino();
		treinoCreate.setDiasSemana(treino.getDiasSemana());
		treinoCreate.setExercicios(treino.getExercicios());
		treinoCreate.setNome(treino.getNome());
		treinoCreate.setUser(u);
		TreinoResponseDTO treinoCriado = new TreinoResponseDTO(treinoCreate);

		treinoRepository.save(treinoCreate);
		return treinoCriado;
	}

	@Transactional
	public TreinoResponseDTO alter(String nome, Treino treino) {
		Treino treinoGet = search(nome);
		Treino treinoAtualizado = treinoGet;
		treinoAtualizado.setId(treinoGet.getId());
		treinoAtualizado.setNome(treino.getNome());
		treinoAtualizado.setDiasSemana(treino.getDiasSemana());
		treinoAtualizado.setExercicios(treino.getExercicios());
		TreinoResponseDTO treinoResponseDTO = new TreinoResponseDTO(treinoAtualizado);
		treinoRepository.save(treinoAtualizado);
		return treinoResponseDTO;

	}

	@Transactional
	public void delete(String nome) {
		Treino treino = search(nome);
		treinoRepository.delete(treino);
	}

	@Transactional
	public Treino search(String nome) {
		Optional<Treino> treino = treinoRepository.findByNome(nome);
		if (treino.isEmpty()) {
			throw new TreinoNotFound("Treino não encontrado");
		}
		Treino treinoEncotrado = treino.get();

		return treinoEncotrado;
	}

	@Transactional
	public List<TreinoResponseDTO> listaTreinos(Long id) {
		List<Treino> treinos = treinoRepository.findByUserId(id);

		List<TreinoResponseDTO> dtos = treinos.stream()
				.map(t -> new TreinoResponseDTO(t.getDiasSemana(), t.getNome(), t.getExercicios()))
				.toList();

		return dtos;
	}


}


