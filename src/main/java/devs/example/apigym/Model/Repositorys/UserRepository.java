package devs.example.apigym.Model.Repositorys;

import devs.example.apigym.Model.Entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByEmail(String username);
}
