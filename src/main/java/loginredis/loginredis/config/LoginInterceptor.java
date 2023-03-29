package loginredis.loginredis.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    public static final String LOGIN_USER_INFO="USER_INFO";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {

        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute(LOGIN_USER_INFO)==null){

            log.info("인증되지 않은 사용자:{}");
            return false;
        }

        return true;
    }
}
