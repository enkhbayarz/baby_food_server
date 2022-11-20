package mn.babyfood.babyfood.service;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.ChildIndexHistory;
import mn.babyfood.babyfood.repository.ChildIndexHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ChildIndexHistoryService {
    private final ChildIndexHistoryRepository childIndexHistoryRepository;

    public List<ChildIndexHistory> get() {
        return childIndexHistoryRepository.get();
    }

    public Integer post(ChildIndexHistory childFood) {
        return childIndexHistoryRepository.post(childFood);
    }

}
