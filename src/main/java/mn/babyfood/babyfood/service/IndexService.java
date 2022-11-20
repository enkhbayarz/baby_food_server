package mn.babyfood.babyfood.service;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.Index;
import mn.babyfood.babyfood.repository.IndexRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class IndexService {
    private final IndexRepository indexRepository;

    public List<Index> get() {
        return indexRepository.get();
    }

    public Integer post(Index index) {
        return indexRepository.post(index);
    }
}
