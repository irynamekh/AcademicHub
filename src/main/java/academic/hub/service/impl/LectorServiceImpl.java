package academic.hub.service.impl;

import academic.hub.repository.LectorRepository;
import academic.hub.service.LectorService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    @Override
    public List<String> getLectorByTemplate(String template) {
        List<String> lectors = lectorRepository.findAllByTemplate(template).stream()
                .map(lector -> lector.getFirstName() + " " + lector.getLastName())
                .toList();
        return lectors.isEmpty() ? List.of("Sorry, no name matches found") : lectors;
    }
}
