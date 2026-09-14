package devs.example.apigym.Services;

import devs.example.apigym.DTOS.ExercicioDTO;
import devs.example.apigym.Model.Entities.Exercicio;
import devs.example.apigym.Exception.ExercicioAlreadyExists;
import devs.example.apigym.Exception.ExercicioNotFound;
import devs.example.apigym.Model.Repositorys.ExercicioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExercicioService {

  private final ExercicioRepository exercicioRepository;


  @Transactional
  public ExercicioDTO save(Exercicio exercicio) {
    Optional<Exercicio> findUser = exercicioRepository.findByNome(exercicio.getNome());
    if (findUser.isPresent()) {
      throw new ExercicioAlreadyExists("Exercicio já existe");
    }

    Exercicio exercicioCreated = Exercicio.builder()
        .nome(exercicio.getNome())
        .grupoMuscular(exercicio.getGrupoMuscular())
        .cargaAquecimento(exercicio.getCargaAquecimento())
        .repsAquecimento(exercicio.getRepsAquecimento())
        .cargaFeeder(exercicio.getCargaFeeder())
        .repsFeeder(exercicio.getRepsFeeder())
        .cargaTrabalho(exercicio.getCargaTrabalho())
        .repsTrabalho(exercicio.getRepsTrabalho())
        .build();
    ExercicioDTO exercicioDTO = new ExercicioDTO(exercicioCreated);
    exercicioRepository.save(exercicioCreated);
    return exercicioDTO;
  }

  @Transactional
  public void delet(String nome) {
    exercicioRepository.delete(search(nome));
  }

  @Transactional
  public Exercicio search(String nome) {
    Optional<Exercicio> findUser = exercicioRepository.findByNome(nome);
    if (findUser.isEmpty()) {
      throw new ExercicioNotFound("Exercicio não encontrado");
    }

    Exercicio exercicioEncontrado = findUser.get();

    return exercicioEncontrado;
  }

  @Transactional
  public ExercicioDTO alter(String nome, Exercicio exercicio) {
    Exercicio exercicioAlter = search(nome);

    Exercicio exercicioAtualizado = Exercicio.builder()
        .id(exercicioAlter.getId())
        .nome(exercicio.getNome())
        .grupoMuscular(exercicio.getGrupoMuscular())
        .cargaAquecimento(exercicio.getCargaAquecimento())
        .repsAquecimento(exercicio.getRepsAquecimento())
        .cargaFeeder(exercicio.getCargaFeeder())
        .repsFeeder(exercicio.getRepsFeeder())
        .cargaTrabalho(exercicio.getCargaTrabalho())
        .repsTrabalho(exercicio.getRepsTrabalho())
        .build();
    ExercicioDTO exercicioDTO = new ExercicioDTO(exercicioAtualizado);
    exercicioRepository.save(exercicioAtualizado);
    return exercicioDTO;

  }

}
