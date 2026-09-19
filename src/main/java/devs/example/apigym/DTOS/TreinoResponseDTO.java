package devs.example.apigym.DTOS;

import devs.example.apigym.Model.Entities.Exercicio;
import devs.example.apigym.Model.Entities.Treino;
import devs.example.apigym.Enums.DiasSemana;
import devs.example.apigym.Model.Entities.User;
import java.util.List;

public record TreinoResponseDTO(DiasSemana diasSemana, String nome, List<Exercicio> exercicios) {

  public TreinoResponseDTO(Treino treino) {
    this(treino.getDiasSemana(), treino.getNome(), treino.getExercicios());
  }

}
