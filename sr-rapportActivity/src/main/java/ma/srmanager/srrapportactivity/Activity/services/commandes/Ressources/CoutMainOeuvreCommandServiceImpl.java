package ma.srmanager.srrapportactivity.Activity.services.commandes.Ressources;


import lombok.RequiredArgsConstructor;
import ma.srmanager.srrapportactivity.Activity.entities.Ressources.CoutMainOeuvre;
import ma.srmanager.srrapportactivity.Activity.models.Ressources.CoutMainOeuvreDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Ressources.CoutMainOeuvreRepository;
import org.springframework.stereotype.Service;









@Service
@RequiredArgsConstructor
public class CoutMainOeuvreCommandServiceImpl implements CoutMainOeuvreCommandService {

    private final CoutMainOeuvreRepository repository;

    @Override
    public CoutMainOeuvreDTO createCoutMainOeuvre(CoutMainOeuvreDTO dto) {
        CoutMainOeuvre entity = new CoutMainOeuvre(null, dto.getFonctionMainOeuvre(), dto.getCoutJrMainOeuvre());
        CoutMainOeuvre saved = repository.save(entity);
        return new CoutMainOeuvreDTO(saved.getIdCoutMainOeuvre(), saved.getFonctionMainOeuvre(), saved.getCoutJrMainOeuvre());
    }

    @Override
    public CoutMainOeuvreDTO updateCoutMainOeuvre(Long id, CoutMainOeuvreDTO dto) {
        return repository.findById(id).map(entity -> {
            entity.setFonctionMainOeuvre(dto.getFonctionMainOeuvre());
            entity.setCoutJrMainOeuvre(dto.getCoutJrMainOeuvre());
            repository.save(entity);
            return new CoutMainOeuvreDTO(entity.getIdCoutMainOeuvre(), entity.getFonctionMainOeuvre(), entity.getCoutJrMainOeuvre());
        }).orElseThrow(() -> new RuntimeException("CoutMainOeuvre not found"));
    }

    @Override
    public void deleteCoutMainOeuvre(Long id) {
        repository.deleteById(id);
    }
}