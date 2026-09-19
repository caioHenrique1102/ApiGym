package devs.example.apigym.Model.Repositorys;

import devs.example.apigym.Model.Entities.Treino;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {

	Optional<Treino> findByNome(String nome);

 List<Treino>  findByUserId(Long id);
}
