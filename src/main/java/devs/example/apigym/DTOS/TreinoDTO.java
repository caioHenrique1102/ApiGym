package devs.example.apigym.DTOS;

import devs.example.apigym.Model.Entities.Exercicio;
import devs.example.apigym.Model.Entities.Treino;
import devs.example.apigym.Enums.DiasSemana;
import java.util.List;

public record TreinoDTO(DiasSemana diasSemana, String nome, List<Exercicio> exercicios) {

  public TreinoDTO(Treino treino) {
    this(treino.getDiasSemana(), treino.getNome(), treino.getExercicios());
  }

}
