package devs.example.apigym.Model.Entities;

import devs.example.apigym.Enums.DiasSemana;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_treino")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Treino {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private DiasSemana diasSemana;
  private String nome;
  @OneToMany
  private List<Exercicio> exercicios;


	public Treino(DiasSemana diasSemana, String nome){
		this.diasSemana =diasSemana;
		this.nome = nome;
	}

}
