package mn.babyfood.babyfood.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.payload.SignInReq;
import mn.babyfood.babyfood.service.AuthService;
import mn.babyfood.babyfood.util.ApiUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;
    private final ApiUtil apiUtil;

    @PostMapping("login")
    public ResponseEntity<?> signin(@RequestBody SignInReq req, HttpServletRequest request) {
        log.info("START /GET LOGIN CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(authService.signin(req, request.getRequestURL().toString()));
        } catch (final Exception ex) {
            log.info("ERROR /GET LOGIN CONTROLLER");
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET LOGIN CONTROLLER");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("signup")
    public ResponseEntity<?> signup(@RequestBody SignInReq req, HttpServletRequest request) {
        log.info("START /GET SIGNUP CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(authService.signup(req, request.getRequestURL().toString()));
        } catch (final Exception ex) {
            log.info("ERROR /GET SIGNUP CONTROLLER");
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET SIGNUP CONTROLLER");
        }
        return ResponseEntity.ok(response);
    }
}
