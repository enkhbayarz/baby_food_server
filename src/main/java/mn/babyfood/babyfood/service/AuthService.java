package mn.babyfood.babyfood.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.User;
import mn.babyfood.babyfood.model.UserRole;
import mn.babyfood.babyfood.payload.SignInReq;
import mn.babyfood.babyfood.security.JwtTokenProvider;
import mn.babyfood.babyfood.util.ApiUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

@AllArgsConstructor
@Service
@Slf4j
public class AuthService {

    private final AuthenticationManager authManager;
    private final UserService userService;
    private final ApiUtil apiUtil;
    private final UserRoleService userRoleService;
    private final JwtTokenProvider tokenProvider;


    public Map<String, String> signin(SignInReq req, String issuer) {
        log.info("START /GET USER SERVICE");
        final var authentication =
                this.authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        System.out.println(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final var user = userService.getByUsername(req.getUsername());

        return tokenProvider.getTokens(issuer, authentication, user.get(0).getId());
    }

    public Map<String, String> signup(SignInReq req, String issuer) throws Exception {

        log.info("START /GET SIGNUP SERVICE");

        final var res = userService.post(User.builder()
                .username(req.getUsername())
                .password(req.getPassword())
                .type("user")
                .status("1")
                .build());

        if(!StringUtils.hasText(res.toString())){
            throw new Exception(this.apiUtil.buildMessage("auth.badcredentials", null));
        }

        final var user = userService.getByUsername(req.getUsername());

        userRoleService.post(UserRole.builder()
                .role_id(1)
                .user_id(user.get(0).getId())
                .type("user")
                .status("1")
                .build());

        final var authentication =
                this.authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return tokenProvider.getTokens(issuer, authentication, user.get(0).getId());
    }
}
