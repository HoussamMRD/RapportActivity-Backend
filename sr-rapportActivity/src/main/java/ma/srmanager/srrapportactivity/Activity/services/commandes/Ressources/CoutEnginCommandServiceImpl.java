package ma.srmanager.srrapportactivity.Activity.services.commandes.Ressources;



import ma.srmanager.srrapportactivity.Activity.models.Ressources.CoutEnginDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Ressources.CoutEnginRepository;
import lombok.RequiredArgsConstructor;
import ma.srmanager.srrapportactivity.Activity.models.Ressources.CoutEnginDTO;
import ma.srmanager.srrapportactivity.Activity.entities.Ressources.CoutEngin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;









@Service
@RequiredArgsConstructor
public class CoutEnginCommandServiceImpl implements CoutEnginCommandService {

    private final CoutEnginRepository coutEnginRepository;

    @Override
    public CoutEnginDTO createCoutEngin(CoutEnginDTO coutEnginDTO) {
        CoutEngin coutEngin = new CoutEngin(null, coutEnginDTO.getTypeEngin(), coutEnginDTO.getCoutJrEngin());
        CoutEngin savedCoutEngin = coutEnginRepository.save(coutEngin);
        return new CoutEnginDTO(savedCoutEngin.getIdCoutEngin(), savedCoutEngin.getTypeEngin(), savedCoutEngin.getCoutJrEngin());
    }

    @Override
    public CoutEnginDTO updateCoutEngin(Long id, CoutEnginDTO coutEnginDTO) {
        return coutEnginRepository.findById(id).map(coutEngin -> {
            coutEngin.setTypeEngin(coutEnginDTO.getTypeEngin());
            coutEngin.setCoutJrEngin(coutEnginDTO.getCoutJrEngin());
            CoutEngin updated = coutEnginRepository.save(coutEngin);
            return new CoutEnginDTO(updated.getIdCoutEngin(), updated.getTypeEngin(), updated.getCoutJrEngin());
        }).orElseThrow(() -> new RuntimeException("CoutEngin not found"));
    }

    @Override
    public void deleteCoutEngin(Long id) {
        coutEnginRepository.deleteById(id);
    }
}

