package ma.srmanager.srrapportactivity.Activity.services.commandes.Suivi;

import ma.srmanager.srrapportactivity.Activity.entities.Suivi.MainOeuvreSuivi;
import ma.srmanager.srrapportactivity.Activity.entities.Suivi.TacheSuivi;
import ma.srmanager.srrapportactivity.Activity.models.Suivi.MainOeuvreSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.MainOeuvreSuiviRepository;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.TacheSuiviRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MainOeuvreSuiviCommandServiceImpl implements MainOeuvreSuiviCommandService {

    private final MainOeuvreSuiviRepository mainOeuvreSuiviRepository;
    private final TacheSuiviRepository tacheSuiviRepository;  // Added repository for TacheSuivi
    private final ModelMapper modelMapper;



    @Override
    public MainOeuvreSuiviDTO createMainOeuvreSuivi(MainOeuvreSuiviDTO mainOeuvreSuiviDTO) {
        // Map DTO to entity
        MainOeuvreSuivi mainOeuvreSuivi = modelMapper.map(mainOeuvreSuiviDTO, MainOeuvreSuivi.class);

        // Fetch the TacheSuivi entity by idTacheSuivi
        TacheSuivi tacheSuivi = tacheSuiviRepository.findById(mainOeuvreSuiviDTO.getIdTacheSuivi())
                .orElseThrow(() -> new RuntimeException("TacheSuivi not found"));

        // Link the MainOeuvreSuivi to the TacheSuivi
        mainOeuvreSuivi.setTacheSuivi(tacheSuivi);

        // Save the MainOeuvreSuivi
        MainOeuvreSuivi savedMainOeuvreSuivi = mainOeuvreSuiviRepository.save(mainOeuvreSuivi);

        // Map the saved entity back to DTO
        return modelMapper.map(savedMainOeuvreSuivi, MainOeuvreSuiviDTO.class);
    }




    @Override
    public MainOeuvreSuiviDTO updateMainOeuvreSuivi(Long id, MainOeuvreSuiviDTO mainOeuvreSuiviDTO) {
        // Fetch the existing MainOeuvreSuivi by ID
        MainOeuvreSuivi existingMainOeuvreSuivi = mainOeuvreSuiviRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MainOeuvreSuivi not found"));

        // Update the fields from the DTO
        existingMainOeuvreSuivi.setFonctionMOSuivi(mainOeuvreSuiviDTO.getFonctionMOSuivi());
        existingMainOeuvreSuivi.setNbrMOSuivi(mainOeuvreSuiviDTO.getNbrMOSuivi());

        // Fetch the TacheSuivi entity by idTacheSuivi
        TacheSuivi tacheSuivi = tacheSuiviRepository.findById(mainOeuvreSuiviDTO.getIdTacheSuivi())
                .orElseThrow(() -> new RuntimeException("TacheSuivi not found"));

        // Link the MainOeuvreSuivi to the TacheSuivi
        existingMainOeuvreSuivi.setTacheSuivi(tacheSuivi);

        // Save the updated MainOeuvreSuivi
        MainOeuvreSuivi updatedMainOeuvreSuivi = mainOeuvreSuiviRepository.save(existingMainOeuvreSuivi);

        // Map the updated entity back to DTO
        return modelMapper.map(updatedMainOeuvreSuivi, MainOeuvreSuiviDTO.class);
    }




    @Override
    public void deleteMainOeuvreSuivi(Long id) {
        mainOeuvreSuiviRepository.deleteById(id);
    }
}
