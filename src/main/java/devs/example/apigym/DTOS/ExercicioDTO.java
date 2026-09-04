package devs.example.apigym.DTOS;

import devs.example.apigym.Model.Entities.Exercicio;

public record ExercicioDTO(String nome,
                           String grupoMuscular,
                           int cargaAquecimento,
                           int repsAquecimento,
                           int cargaFeeder,
                           int repsFeeder,
                           int cargaTrabalho,
                           int repsTrabalho) {

  public ExercicioDTO(Exercicio exercicio){
    this(exercicio.getNome(),
    exercicio.getGrupoMuscular(),
    exercicio.getCargaAquecimento(),
    exercicio.getRepsAquecimento(),
    exercicio.getCargaFeeder(),
    exercicio.getRepsFeeder(),
    exercicio.getCargaTrabalho(),
    exercicio.getRepsTrabalho());
  }
}
