package devs.example.apigym.Services;

import devs.example.apigym.GlobalExceptionHandler.Exceptions.UserNotFound;
import devs.example.apigym.Model.Entities.User;
import devs.example.apigym.Model.Repositorys.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;


	public User findUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
	}

}
