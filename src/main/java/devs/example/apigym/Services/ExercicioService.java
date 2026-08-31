package devs.example.apigym.Services;

import devs.example.apigym.DTOS.ExercicioDTO;
import devs.example.apigym.Entities.Exercicio;
import devs.example.apigym.Exception.ExercicioAlreadyExists;
import devs.example.apigym.Exception.ExercicioNotFound;
import devs.example.apigym.Repositories.ExercicioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ExercicioService {

  private final ExercicioRepository exercicioRepository;

  public ExercicioService(ExercicioRepository exercicioRepository) {
    this.exercicioRepository = exercicioRepository;
  }

  @Transactional
  public Exercicio create(ExercicioDTO exercicioDTO) {
    Optional<Exercicio> findUser = exercicioRepository.findUserbyname(exercicioDTO.nome());
    if(!findUser.isEmpty()) throw new ExercicioAlreadyExists("Exercicio já existe");

    Exercicio exercicio = new Exercicio(exercicioDTO.nome(),
        exercicioDTO.cargaAquecimento(), exercicioDTO.repsAquecimento(), exercicioDTO.cargaFeeder(),
        exercicioDTO.repsFeeder(), exercicioDTO.cargaTrabalho(), exercicioDTO.repsTrabalho(),
        exercicioDTO.grupoMuscular());

    return exercicio;
  }

  @Transactional
  public void delet(String nome) {
    Optional<Exercicio> findUser = exercicioRepository.findUserbyname(nome);

    if (findUser.isEmpty()) throw new ExercicioNotFound("Exercicio não encontrado");
    Exercicio exercicio = findUser.get();
    exercicioRepository.delete(exercicio);
  }

}
