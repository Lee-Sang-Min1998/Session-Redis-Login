package loginredis.loginredis.repository;

import java.util.Optional;
import loginredis.loginredis.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByEmailAndPw(String email, String pw);
}
