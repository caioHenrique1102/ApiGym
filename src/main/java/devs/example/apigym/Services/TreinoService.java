package devs.example.apigym.Services;

import devs.example.apigym.DTOS.TreinoDTO;
import devs.example.apigym.Exception.TreinoAlreadyExists;
import devs.example.apigym.Exception.TreinoNotFound;
import devs.example.apigym.Model.Entities.Exercicio;
import devs.example.apigym.Model.Entities.Treino;
import devs.example.apigym.Model.Repositorys.TreinoRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TreinoService {

	private final TreinoRepository treinoRepository;
	private final ExercicioService exercicioService;

	@Transactional
	public TreinoDTO cadastrarExercicio(String nomeTreino, String nomeExercicio) {
		Treino treino = search(nomeTreino);
		Exercicio exercicio = exercicioService.search(nomeExercicio);
		treino.getExercicios().add(exercicio);
		TreinoDTO treinoDTO = new TreinoDTO(treino);
		treinoRepository.save(treino);
		return treinoDTO;
	}

	@Transactional
	public TreinoDTO criar(Treino treino) {
		Optional<Treino> treinoFound = treinoRepository.findByNome(treino.getNome());
		if (treinoFound.isPresent()) {
			throw new TreinoAlreadyExists("O treino com o nome " + treino.getNome() + " já existe");
		}

		Treino treinoCreate = Treino.builder().diasSemana(treino.getDiasSemana()).nome(treino.getNome())
				.build();
		TreinoDTO treinoCriado = new TreinoDTO(treinoCreate);

		treinoRepository.save(treinoCreate);
		return treinoCriado;
	}

	@Transactional
	public TreinoDTO alter(String nome, Treino treino) {
		Treino treinoGet = search(nome);
		Treino treinoAtualizado = treinoGet;
		treinoAtualizado.setId(treinoGet.getId());
		treinoAtualizado.setNome(treino.getNome());
		treinoAtualizado.setDiasSemana(treino.getDiasSemana());
		treinoAtualizado.setExercicios(treino.getExercicios());
		TreinoDTO treinoDTO = new TreinoDTO(treinoAtualizado);
		treinoRepository.save(treinoAtualizado);
		return treinoDTO;

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
	public TreinoDTO listar(String nome) {
		Treino treino = search(nome);
		TreinoDTO treinoDTO = new TreinoDTO(treino);

		return treinoDTO;
	}


}


