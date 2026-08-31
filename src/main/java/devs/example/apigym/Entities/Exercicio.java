package devs.example.apigym.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercicio")
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


  public Exercicio( String nome, int cargaAquecimento, int repsAquecimento, int cargaFeeder,
      int repsFeeder, int cargaTrabalho, int repsTrabalho, String grupoMuscular) {
    this.nome = nome;
    this.cargaAquecimento = cargaAquecimento;
    this.repsAquecimento = repsAquecimento;
    this.cargaFeeder = cargaFeeder;
    this.repsFeeder = repsFeeder;
    this.cargaTrabalho = cargaTrabalho;
    this.repsTrabalho = repsTrabalho;
    this.grupoMuscular = grupoMuscular;
  }

  public Exercicio() {
  }
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getCargaAquecimento() {
    return cargaAquecimento;
  }

  public void setCargaAquecimento(int cargaAquecimento) {
    this.cargaAquecimento = cargaAquecimento;
  }

  public int getRepsAquecimento() {
    return repsAquecimento;
  }

  public void setRepsAquecimento(int repsAquecimento) {
    this.repsAquecimento = repsAquecimento;
  }

  public int getCargaFeeder() {
    return cargaFeeder;
  }

  public void setCargaFeeder(int cargaFeeder) {
    this.cargaFeeder = cargaFeeder;
  }

  public int getRepsFeeder() {
    return repsFeeder;
  }

  public void setRepsFeeder(int repsFeeder) {
    this.repsFeeder = repsFeeder;
  }

  public int getCargaTrabalho() {
    return cargaTrabalho;
  }

  public void setCargaTrabalho(int cargaTrabalho) {
    this.cargaTrabalho = cargaTrabalho;
  }

  public int getRepsTrabalho() {
    return repsTrabalho;
  }

  public void setRepsTrabalho(int repsTrabalho) {
    this.repsTrabalho = repsTrabalho;
  }

  public String getGrupoMuscular() {
    return grupoMuscular;
  }

  public void setGrupoMuscular(String grupoMuscular) {
    this.grupoMuscular = grupoMuscular;
  }

}
