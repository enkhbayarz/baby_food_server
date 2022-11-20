//package mn.babyfood.babyfood.security;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import mn.babyfood.babyfood.payload.UserPrincipal;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//
//@Slf4j
//public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    private final AuthenticationManager authenticationManager;
//
//    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        log.info("START attemptAuthentication SERVICE");
//        try {
//            String username = request.getParameter("username");
//            String password = request.getParameter("password");
//            log.debug("username: {}, password: {}", username, password);
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
//
//            return authenticationManager.authenticate(authenticationToken);
//        } catch (Exception e) {
//            log.error("error: {}", e.getMessage());
//            throw e;
//        }
//
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
//        log.info("START successfulAuthentication SERVICE");
//        try {
//            UserPrincipal user = (UserPrincipal) authentication.getPrincipal();
//            Algorithm algorithm = Algorithm.HMAC256("babyfood".getBytes());
//            String access_token = JWT.create()
//                    .withSubject(user.getUsername())
//                    .withExpiresAt(new Date(System.currentTimeMillis() + 100 * 60 * 1000))
//                    .withIssuer(request.getRequestURL().toString())
//                    .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
//                    .sign(algorithm);
//
//            String refresh_token = JWT.create()
//                    .withSubject(user.getUsername())
//                    .withExpiresAt(new Date(System.currentTimeMillis() + 300 * 60 * 1000))
//                    .withIssuer(request.getRequestURL().toString())
//                    .sign(algorithm);
//
//            Map<String, String> tokens = new HashMap<>();
//            tokens.put("access_token", access_token);
//            tokens.put("refresh_token", refresh_token);
//            response.setContentType(APPLICATION_JSON_VALUE);
//            new ObjectMapper().writeValue(response.getOutputStream(), tokens);
//
//        } catch (Exception e) {
//            log.error("error: {}", e.getMessage());
//            throw e;
//        }
//    }
//}