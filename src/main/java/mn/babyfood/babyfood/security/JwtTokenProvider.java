package mn.babyfood.babyfood.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.payload.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtTokenProvider {

    public String getUsername(String request){
        String token = request.substring("Bearer ".length());
        Algorithm algorithm = Algorithm.HMAC256("babyfood".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT.getSubject();
    }
    public Map<String, String> getTokens(String issuer, Authentication authentication, Integer id) {
        UserPrincipal user = (UserPrincipal) authentication.getPrincipal();
        Algorithm algorithm = Algorithm.HMAC256("babyfood".getBytes());
        String access_token = JWT.create()
                .withSubject(user.getUsername())
                .withIssuer(issuer)
                .withClaim("id", id)
                .withExpiresAt(new Date(System.currentTimeMillis() + 100 * 60 * 1000))
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);

        String refresh_token = JWT.create()
                .withSubject(user.getUsername())
                .withIssuer(issuer)
                .withClaim("id", id)
                .withExpiresAt(new Date(System.currentTimeMillis() + 300 * 60 * 1000))
                .sign(algorithm);

        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token", access_token);
        tokens.put("refresh_token", refresh_token);
        return tokens;
    }
}
