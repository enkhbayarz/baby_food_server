package mn.babyfood.babyfood.service;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.UserRole;
import mn.babyfood.babyfood.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public List<UserRole> get() {
        return userRoleRepository.get();
    }

    public Integer post(UserRole userRole) {
        return userRoleRepository.post(userRole);
    }
}
