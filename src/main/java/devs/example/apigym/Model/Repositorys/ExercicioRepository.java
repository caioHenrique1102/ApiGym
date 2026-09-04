package devs.example.apigym.Model.Repositorys;

import devs.example.apigym.Model.Entities.Exercicio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {

  Optional <Exercicio> findByNome(String nome);

}
