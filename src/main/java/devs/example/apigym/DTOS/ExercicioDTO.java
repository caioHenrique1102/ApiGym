package devs.example.apigym.DTOS;

public record ExercicioDTO(String nome,
                           String grupoMuscular,
                           int cargaAquecimento,
                           int repsAquecimento,
                           int cargaFeeder,
                           int repsFeeder,
                           int cargaTrabalho,
                           int repsTrabalho) {

}
