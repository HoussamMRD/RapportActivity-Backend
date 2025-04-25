package ma.srmanager.srrapportactivity.Activity.services.commandes.Planifier;

import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Tache;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.MainOeuvreDTO;

import ma.srmanager.srrapportactivity.Activity.entities.Planifier.MainOeuvre;
import ma.srmanager.srrapportactivity.Activity.repositories.Planifier.MainOeuvreRepository;
import ma.srmanager.srrapportactivity.Activity.repositories.Planifier.TacheRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;









@Service
public class MainOeuvreCommandServiceImpl implements MainOeuvreCommandService {
    @Autowired
    private MainOeuvreRepository mainOeuvreRepository;

    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MainOeuvreDTO createMainOeuvre(MainOeuvreDTO mainOeuvreDTO) {
        MainOeuvre mainOeuvre = modelMapper.map(mainOeuvreDTO, MainOeuvre.class);

        // Fetch the Tache by idTache
        Tache tache = tacheRepository.findById(mainOeuvreDTO.getIdTache())
                .orElseThrow(() -> new RuntimeException("Tache not found"));

        // Link the MainOeuvre to the Tache
        mainOeuvre.setTache(tache);

        // Add the MainOeuvre to the Tache's list of MainOeuvres
        tache.getMainOeuvres().add(mainOeuvre);

        // Save the MainOeuvre
        MainOeuvre savedMainOeuvre = mainOeuvreRepository.save(mainOeuvre);

        // Save the Tache (to update the relationship)
        tacheRepository.save(tache);

        return modelMapper.map(savedMainOeuvre, MainOeuvreDTO.class);
    }

    @Override
    public MainOeuvreDTO updateMainOeuvre(Long id, MainOeuvreDTO mainOeuvreDTO) {
        // Fetch the existing MainOeuvre by ID
        MainOeuvre existingMainOeuvre = mainOeuvreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MainOeuvre not found"));

        // Update the fields from the DTO
        existingMainOeuvre.setFonctionMO(mainOeuvreDTO.getFonctionMO());
        existingMainOeuvre.setNbrMO(mainOeuvreDTO.getNbrMO());

        // Fetch the Tache by idTache from the DTO
        if (mainOeuvreDTO.getIdTache() != null) {
            Tache tache = tacheRepository.findById(mainOeuvreDTO.getIdTache())
                    .orElseThrow(() -> new RuntimeException("Tache not found"));

            // Link the MainOeuvre to the Tache
            existingMainOeuvre.setTache(tache);

            // Add the MainOeuvre to the Tache's list of MainOeuvres (if not already present)
            if (!tache.getMainOeuvres().contains(existingMainOeuvre)) {
                tache.getMainOeuvres().add(existingMainOeuvre);
            }
        } else {
            // If idTache is null, remove the MainOeuvre from its current Tache
            if (existingMainOeuvre.getTache() != null) {
                existingMainOeuvre.getTache().getMainOeuvres().remove(existingMainOeuvre);
            }
            existingMainOeuvre.setTache(null);
        }

        // Save the updated MainOeuvre
        MainOeuvre updatedMainOeuvre = mainOeuvreRepository.save(existingMainOeuvre);

        // Save the Tache (to update the relationship)
        if (existingMainOeuvre.getTache() != null) {
            tacheRepository.save(existingMainOeuvre.getTache());
        }

        return modelMapper.map(updatedMainOeuvre, MainOeuvreDTO.class);
    }


    @Override
    public void deleteMainOeuvre(Long id) {
        mainOeuvreRepository.deleteById(id);
    }
}