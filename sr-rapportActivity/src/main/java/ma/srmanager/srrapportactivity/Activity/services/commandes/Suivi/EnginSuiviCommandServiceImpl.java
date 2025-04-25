package ma.srmanager.srrapportactivity.Activity.services.commandes.Suivi;

import ma.srmanager.srrapportactivity.Activity.entities.Suivi.EnginSuivi;
import ma.srmanager.srrapportactivity.Activity.entities.Suivi.TacheSuivi;
import ma.srmanager.srrapportactivity.Activity.models.Suivi.EnginSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.EnginSuiviRepository;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.TacheSuiviRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EnginSuiviCommandServiceImpl implements EnginSuiviCommandService {

    private final EnginSuiviRepository enginSuiviRepository;
    private final TacheSuiviRepository tacheSuiviRepository;

    private final ModelMapper modelMapper;

    @Override
    public EnginSuiviDTO createEnginSuivi(EnginSuiviDTO enginSuiviDTO) {
        // Map DTO to entity
        EnginSuivi enginSuivi = modelMapper.map(enginSuiviDTO, EnginSuivi.class);

        // Fetch the TacheSuivi entity by idTacheSuivi
        TacheSuivi tacheSuivi = tacheSuiviRepository.findById(enginSuiviDTO.getIdTacheSuivi())
                .orElseThrow(() -> new RuntimeException("TacheSuivi non trouvée"));

        // Link the EnginSuivi to the TacheSuivi
        enginSuivi.setTacheSuivi(tacheSuivi);

        // Save the EnginSuivi
        EnginSuivi savedEnginSuivi = enginSuiviRepository.save(enginSuivi);

        // Map the saved entity back to DTO
        return modelMapper.map(savedEnginSuivi, EnginSuiviDTO.class);
    }

    @Override
    public EnginSuiviDTO updateEnginSuivi(Long id , EnginSuiviDTO enginSuiviDTO) {
        // Fetch the existing EnginSuivi by ID
        EnginSuivi existingEnginSuivi = enginSuiviRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EnginSuivi non trouvée"));

        // Update the fields from the DTO
        existingEnginSuivi.setTypeEnginSuivi(enginSuiviDTO.getTypeEnginSuivi());
        existingEnginSuivi.setNbrEnginSuivi(enginSuiviDTO.getNbrEnginSuivi());

        // Fetch the TacheSuivi entity by idTacheSuivi
        TacheSuivi tacheSuivi = tacheSuiviRepository.findById(enginSuiviDTO.getIdTacheSuivi())
                .orElseThrow(() -> new RuntimeException("TacheSuivi non trouvée"));

        // Link the EnginSuivi to the TacheSuivi
        existingEnginSuivi.setTacheSuivi(tacheSuivi);

        // Save the EnginSuivi
        EnginSuivi savedEnginSuivi = enginSuiviRepository.save(existingEnginSuivi);

        // Map the saved entity back to DTO
        return modelMapper.map(savedEnginSuivi, EnginSuiviDTO.class);
    }

    @Override
    public void deleteEnginSuivi(Long id) {
        enginSuiviRepository.deleteById(id);
    }
}
