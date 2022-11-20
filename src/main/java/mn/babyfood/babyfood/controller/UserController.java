package mn.babyfood.babyfood.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.User;
import mn.babyfood.babyfood.payload.UserPrincipal;
import mn.babyfood.babyfood.security.CurrentUser;
import mn.babyfood.babyfood.service.UserService;
import mn.babyfood.babyfood.util.ApiUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final ApiUtil apiUtil;

    @GetMapping()
    public ResponseEntity<?> get() {

        log.info("START /GET getUser CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(userService.get());
        } catch (final Exception ex) {
            log.error("ERROR /GET getUser CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET getUser CONTROLLER");
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("id")
    public ResponseEntity<?> getById(@CurrentUser final UserPrincipal currentUser) {

        log.info("START /GET getUser CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(userService.getById(currentUser));
        } catch (final Exception ex) {
            log.error("ERROR /GET getUser CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET getUser CONTROLLER");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody User user) {
        log.info("START /POST postUser CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody( userService.post(user));
        } catch (final Exception ex) {
            log.error("ERROR /POST postUser CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /POST postUser CONTROLLER");
        }
        return ResponseEntity.ok(response);

    }
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody User user, @CurrentUser final UserPrincipal currenUser) {
        log.info("START /POST postUser CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody( userService.update(user, currenUser));
        } catch (final Exception ex) {
            log.error("ERROR /POST postUser CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /POST postUser CONTROLLER");
        }
        return ResponseEntity.ok(response);

    }
}
