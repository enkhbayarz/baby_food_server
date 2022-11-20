package mn.babyfood.babyfood.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.service.UserService;
import mn.babyfood.babyfood.util.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
public class CustomerAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;
    @Autowired
    private ApiUtil apiUtil;
    @Autowired
    private JwtTokenProvider tokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("START doFilterInternal SERVICE");

        if (request.getServletPath().startsWith("/api/v1/auth/")) {
            filterChain.doFilter(request, response);
        } else {
            try {
                String authHeader = request.getHeader(AUTHORIZATION);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    String username = tokenProvider.getUsername(authHeader);

                    final var userPrincipal = userService.loadUserByUsername(username);

                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(request, response);
                } else {
                    throw new Exception(this.apiUtil.buildMessage("auth.badcredentials", null));
                }

            } catch (Exception ex) {
                log.error("error loggin in: {}", ex.getMessage());
                response.setStatus(UNAUTHORIZED.value());

                Map<String, Object> error = new HashMap<>();
                error.put("message", ex.getMessage());
                error.put("success", false);
                error.put("body", null);

                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        }
    }
}
