package loginredis.loginredis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> unauthorizedException(){

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다");
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFoundException(){

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("해당하는 유저가 없습니다");
    }
}
