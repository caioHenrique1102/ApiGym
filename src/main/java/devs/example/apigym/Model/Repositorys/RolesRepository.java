package devs.example.apigym.Model.Repositorys;

import devs.example.apigym.Model.Entities.Roles;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Long> {

	Optional<Roles> findByNome(String role);
}
