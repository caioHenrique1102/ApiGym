package devs.example.apigym.Model.Entities;

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
@Table(name = "tb_exercicio")
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


}
