package mn.babyfood.babyfood.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.util.ApiUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ApiUtil apiUtil;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.info("START COMMENCE SERVICE");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, this.apiUtil.buildMessage("auth.badcredentials", null));
    }
}
