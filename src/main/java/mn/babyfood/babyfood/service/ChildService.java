package mn.babyfood.babyfood.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.Child;
import mn.babyfood.babyfood.payload.UserPrincipal;
import mn.babyfood.babyfood.repository.ChildRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class ChildService {

    private final ChildRepository childRepository;

    public List<Child> get() {
        log.info("START /GET getChild SERVICE");
        return childRepository.get();
    }

    public List<Child> getByUserId(UserPrincipal currentUser) {
        log.info("START /GET getChildByUserId SERVICE");
        return childRepository.getByUserId(currentUser.getId());
    }

    public Integer post(Child child, UserPrincipal currentUser) {
        log.info("START /POST insertChild SERVICE");
        child.setUser_id(currentUser.getId());
        child.setType("child");
        child.setStatus("1");
        Double i = (child.getWeight() / (child.getHeight() * child.getHeight())) * 10000;
        child.setIndex(i);
        return childRepository.post(child);
    }
}
