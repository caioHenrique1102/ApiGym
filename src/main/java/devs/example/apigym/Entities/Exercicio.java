package devs.example.apigym.Entities;

import devs.example.apigym.DTOS.ExercicioDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "exercicio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exercicio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String grupoMuscular;
  private int cargaAquecimento;
  private int repsAquecimento;
  private int cargaFeeder;
  private int repsFeeder;
  private int cargaTrabalho;
  private int repsTrabalho;


  public Exercicio(String nome,
      String grupoMuscular,
      int cargaAquecimento,
      int repsAquecimento,
      int cargaFeeder,
      int repsFeeder,
      int cargaTrabalho,
      int repsTrabalho, ExercicioDTO exercicioDTO) {

    this.nome = nome;
    this.grupoMuscular = grupoMuscular;
    this.cargaAquecimento = cargaAquecimento;
    this.repsAquecimento = repsAquecimento;
    this.cargaFeeder = cargaFeeder;
    this.repsFeeder = repsFeeder;
    this.cargaTrabalho = cargaTrabalho;
    this.repsTrabalho = repsTrabalho;
  }


}
