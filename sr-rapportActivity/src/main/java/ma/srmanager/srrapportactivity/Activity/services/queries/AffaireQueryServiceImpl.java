package ma.srmanager.srrapportactivity.Activity.services.queries;

import ma.srmanager.srrapportactivity.Activity.entities.Affaire;
import ma.srmanager.srrapportactivity.Activity.models.AffaireDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.AffaireRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;





@Service
public class AffaireQueryServiceImpl implements AffaireQueryService {
    @Autowired
    private AffaireRepository affaireRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AffaireDTO getAffaireById(Long id) {
        Affaire affaire = affaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Affaire not found"));
        return modelMapper.map(affaire, AffaireDTO.class);
    }

    @Override
    public List<AffaireDTO> getAllAffaires() {
        return affaireRepository.findAll().stream()
                .map(affaire -> modelMapper.map(affaire, AffaireDTO.class))
                .collect(Collectors.toList());
    }
}
