package loginredis.loginredis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import loginredis.loginredis.config.LoginInterceptor;
import loginredis.loginredis.domain.LoginRequestDto;
import loginredis.loginredis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SessionController {


    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody LoginRequestDto dto) {

        userService.register(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공");
    }

    @PostMapping("/login")
    public String test(@RequestBody LoginRequestDto dto, HttpServletRequest request) {

        Long userId = userService.login(dto);

        HttpSession session = request.getSession();
        session.setAttribute(LoginInterceptor.LOGIN_USER_INFO,userId);
        session.setMaxInactiveInterval(60);

        return "로그인 성공";
    }

    @GetMapping("/test")
    public String test2(){

        return "인터셉터 거친 controller 실행";
    }
}
