package mn.babyfood.babyfood.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.User;
import mn.babyfood.babyfood.model.UserRoleById;
import mn.babyfood.babyfood.payload.UserPrincipal;
import mn.babyfood.babyfood.repository.UserRepository;
import mn.babyfood.babyfood.repository.UserRoleRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


//try {
//
//        } catch (Exception ex){
//
//        } finally {
//
//        }
@AllArgsConstructor
@Service
@Slf4j
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> get() {
        log.info("START /GET getUser SERVICE");
        return userRepository.get();

    }

    public List<User> getById(UserPrincipal currentUser) {
        log.info("START /GET getUserById SERVICE");
        return userRepository.getById(currentUser.getId());
    }

    public List<User> getByUsername(String username) {
        log.info("START /GET getByUsername SERVICE");
        return userRepository.getByUsername(username);
    }

    public Integer post(User user) {
        log.info("START /POSt insertUser SERVICE");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.post(user);
    }

    public Integer update(User user, UserPrincipal currenUser) {
        log.info("START /PUT updateUser SERVICE");

        user.setId(currenUser.getId());
        return userRepository.update(user);
    }

    @Override
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            List<User> users = getByUsername(username);
            if (users.isEmpty()) {
                log.error("User not found");
                throw new UsernameNotFoundException("User not found");
            }
            log.debug("User found {}", username);
            User user = users.get(0);

            List<UserRoleById> userrole = userRoleRepository.getByUserId(user.getId());

            return UserPrincipal.create(user, userrole);
        } catch (Exception e) {
            log.error("error: {}", e.getMessage());
            throw e;
        }

    }
}
