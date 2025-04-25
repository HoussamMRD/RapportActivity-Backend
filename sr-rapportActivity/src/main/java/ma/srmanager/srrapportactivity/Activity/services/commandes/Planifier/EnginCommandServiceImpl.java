package ma.srmanager.srrapportactivity.Activity.services.commandes.Planifier;

import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Engin;
import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Tache;
import ma.srmanager.srrapportactivity.Activity.repositories.Planifier.EnginRepository;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.EnginDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Planifier.TacheRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;




import java.util.Optional;





@Service
@Transactional
public class EnginCommandServiceImpl implements EnginCommandService {

    @Autowired
    private EnginRepository enginRepository;

    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EnginDTO createEngin(EnginDTO enginDTO) {
        // Map DTO to Entity
        Engin engin = modelMapper.map(enginDTO, Engin.class);

        // Fetch the Tache by ID
        Tache tache = tacheRepository.findById(enginDTO.getIdTache())
                .orElseThrow(() -> new RuntimeException("Tache not found"));

        // Link the Engin to the Tache
        engin.setTache(tache);

        // Add the Engin to the Tache's list of Engins
        tache.getEngins().add(engin);

        // Save the Engin
        Engin savedEngin = enginRepository.save(engin);

        // Save the Tache (to update the relationship)
        tacheRepository.save(tache);

        // Map the saved Engin to DTO and return
        return modelMapper.map(savedEngin, EnginDTO.class);
    }









    @Override
    public EnginDTO updateEngin(Long id, EnginDTO enginDTO) {
        // Fetch the existing Engin by ID
        Engin existingEngin = enginRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Engin not found"));

        // Update the fields from the DTO
        existingEngin.setTypeEngin(enginDTO.getTypeEngin());
        existingEngin.setNbrEngin(enginDTO.getNbrEngin());

        // Fetch the Tache by idTache from the DTO
        if (enginDTO.getIdTache() != null) {
            Tache tache = tacheRepository.findById(enginDTO.getIdTache())
                    .orElseThrow(() -> new RuntimeException("Tache not found"));

            // Link the Engin to the Tache
            existingEngin.setTache(tache);

            // Add the Engin to the Tache's list of Engins (if not already present)
            if (!tache.getEngins().contains(existingEngin)) {
                tache.getEngins().add(existingEngin);
            }
        } else {
            // If idTache is null, remove the Engin from its current Tache
            if (existingEngin.getTache() != null) {
                existingEngin.getTache().getEngins().remove(existingEngin);
            }
            existingEngin.setTache(null);
        }

        // Save the updated Engin
        Engin updatedEngin = enginRepository.save(existingEngin);

        // Save the Tache (to update the relationship)
        if (existingEngin.getTache() != null) {
            tacheRepository.save(existingEngin.getTache());
        }

        // Map the updated Engin to DTO and return
        return modelMapper.map(updatedEngin, EnginDTO.class);
    }













    @Override
    public void deleteEngin(Long id) {
        enginRepository.deleteById(id);
    }
}