package ma.srmanager.srrapportactivity.Activity.services.commandes;




import ma.srmanager.srrapportactivity.Activity.entities.Affaire;
import ma.srmanager.srrapportactivity.Activity.models.AffaireDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.AffaireRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;







@Service
public class AffaireCommandServiceImpl implements AffaireCommandService {
    @Autowired
    private AffaireRepository affaireRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AffaireDTO createAffaire(AffaireDTO affaireDTO) {
        Affaire affaire = modelMapper.map(affaireDTO, Affaire.class);
        return modelMapper.map(affaireRepository.save(affaire), AffaireDTO.class);
    }

    @Override
    public AffaireDTO updateAffaire(Long id, AffaireDTO affaireDTO) {
        Affaire affaire = affaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Affaire not found"));
        modelMapper.map(affaireDTO, affaire);
        return modelMapper.map(affaireRepository.save(affaire), AffaireDTO.class);
    }

    @Override
    public void deleteAffaire(Long id) {
        affaireRepository.deleteById(id);
    }
}
