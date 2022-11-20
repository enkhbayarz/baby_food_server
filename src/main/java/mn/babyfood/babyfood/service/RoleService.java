package mn.babyfood.babyfood.service;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.Role;
import mn.babyfood.babyfood.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public List<Role> get() {
        return roleRepository.get();
    }

    public Integer post(Role role) {
        return roleRepository.post(role);
    }
}
