package ma.srmanager.srrapportactivity.Activity.services.queries.Ressources;


import lombok.RequiredArgsConstructor;
import ma.srmanager.srrapportactivity.Activity.models.Ressources.CoutMainOeuvreDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Ressources.CoutMainOeuvreRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;




@Service
@RequiredArgsConstructor
public class CoutMainOeuvreQueryServiceImpl implements CoutMainOeuvreQueryService {
    private final CoutMainOeuvreRepository repository;

    public CoutMainOeuvreDTO getCoutMainOeuvreById(Long id) {
        return repository.findById(id)
                .map(entity -> new CoutMainOeuvreDTO(entity.getIdCoutMainOeuvre(), entity.getFonctionMainOeuvre(), entity.getCoutJrMainOeuvre()))
                .orElseThrow(() -> new RuntimeException("CoutMainOeuvre not found"));
    }

    public List<CoutMainOeuvreDTO> getAllCoutMainOeuvres() {
        return repository.findAll().stream()
                .map(entity -> new CoutMainOeuvreDTO(entity.getIdCoutMainOeuvre(), entity.getFonctionMainOeuvre(), entity.getCoutJrMainOeuvre()))
                .collect(Collectors.toList());
    }
}