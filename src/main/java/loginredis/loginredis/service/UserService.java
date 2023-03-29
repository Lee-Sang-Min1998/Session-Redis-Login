package loginredis.loginredis.service;

import loginredis.loginredis.domain.LoginRequestDto;
import loginredis.loginredis.domain.User;
import loginredis.loginredis.exception.UserNotFoundException;
import loginredis.loginredis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void register(LoginRequestDto dto) {

        userRepository.save(User.builder()
            .email(dto.getEmail())
            .pw(dto.getPw()).
            build());
    }

    public Long login(LoginRequestDto dto) {

        User findUser = userRepository.findUserByEmailAndPw(dto.getEmail(), dto.getPw())
            .orElseThrow(() -> new UserNotFoundException());

        return findUser.getId();
    }
}
