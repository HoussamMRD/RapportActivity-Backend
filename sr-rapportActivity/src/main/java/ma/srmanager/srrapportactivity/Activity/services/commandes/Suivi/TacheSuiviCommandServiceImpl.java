package ma.srmanager.srrapportactivity.Activity.services.commandes.Suivi;

import ma.srmanager.srrapportactivity.Activity.Enums.Statut;
import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Tache;
import ma.srmanager.srrapportactivity.Activity.entities.Suivi.EnginSuivi;
import ma.srmanager.srrapportactivity.Activity.entities.Suivi.LotSuivi;
import ma.srmanager.srrapportactivity.Activity.entities.Suivi.MainOeuvreSuivi;
import ma.srmanager.srrapportactivity.Activity.entities.Suivi.TacheSuivi;
import ma.srmanager.srrapportactivity.Activity.models.Suivi.EnginSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.models.Suivi.LotSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.models.Suivi.MainOeuvreSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.models.Suivi.TacheSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Planifier.TacheRepository;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.TacheSuiviRepository;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.EnginSuiviRepository;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.LotSuiviRepository;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.MainOeuvreSuiviRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import lombok.RequiredArgsConstructor;






@Service
@RequiredArgsConstructor
@Transactional
public class TacheSuiviCommandServiceImpl implements TacheSuiviCommandService {

    private final TacheSuiviRepository tacheSuiviRepository;
    private final EnginSuiviRepository enginSuiviRepository;
    private final LotSuiviRepository lotSuiviRepository;
    private final MainOeuvreSuiviRepository mainOeuvreSuiviRepository;
    private final TacheRepository tacheRepository;
    private final ModelMapper modelMapper;




    @Override
    public TacheSuiviDTO createTacheSuivi(TacheSuiviDTO tacheSuiviDTO) {
        TacheSuivi tacheSuivi = modelMapper.map(tacheSuiviDTO, TacheSuivi.class);

        // Find the Tache by idTache
        Tache tache = tacheRepository.findById(tacheSuiviDTO.getIdTache())
                .orElseThrow(() -> new RuntimeException("Tache not found"));

        // Add TacheSuivi to Tache
        tache.addTacheSuivi(tacheSuivi);

        // Calculate dureeTacheSuivi for the new TacheSuivi
        tacheSuivi.calculerDureeTacheSuivi();

        // Save TacheSuivi
        TacheSuivi savedTacheSuivi = tacheSuiviRepository.save(tacheSuivi);

        // Recalculate dureeTacheReelle for the Tache
        tache.calculerDureeTacheReelle();

        // Save Tache (to update the relationship)
        tacheRepository.save(tache);




        // Add EnginSuivis
        if (tacheSuiviDTO.getEnginsSuivi() != null) {
            for (EnginSuiviDTO enginSuiviDTO : tacheSuiviDTO.getEnginsSuivi()) {
                EnginSuivi enginSuivi = modelMapper.map(enginSuiviDTO, EnginSuivi.class);
                enginSuivi.setTacheSuivi(savedTacheSuivi);
                enginSuiviRepository.save(enginSuivi);
            }
        }

        // Add LotSuivis
        if (tacheSuiviDTO.getLotsSuivi() != null) {
            for (LotSuiviDTO lotSuiviDTO : tacheSuiviDTO.getLotsSuivi()) {
                LotSuivi lotSuivi = modelMapper.map(lotSuiviDTO, LotSuivi.class);
                lotSuivi.setTacheSuivi(savedTacheSuivi);
                lotSuiviRepository.save(lotSuivi);
            }
        }

        // Add MainOeuvreSuivis
        if (tacheSuiviDTO.getMainOeuvresSuivi() != null) {
            for (MainOeuvreSuiviDTO mainOeuvreSuiviDTO : tacheSuiviDTO.getMainOeuvresSuivi()) {
                MainOeuvreSuivi mainOeuvreSuivi = modelMapper.map(mainOeuvreSuiviDTO, MainOeuvreSuivi.class);
                mainOeuvreSuivi.setTacheSuivi(savedTacheSuivi);
                mainOeuvreSuiviRepository.save(mainOeuvreSuivi);
            }
        }

        return modelMapper.map(savedTacheSuivi, TacheSuiviDTO.class);
    }





    @Override
    public TacheSuiviDTO updateTacheSuivi(Long id, TacheSuiviDTO tacheSuiviDTO) {
        // Fetch the existing TacheSuivi by ID
        TacheSuivi existingTacheSuivi = tacheSuiviRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TacheSuivi not found"));

        // Update the fields from the DTO
        existingTacheSuivi.setDureeTacheSuivi(tacheSuiviDTO.getDureeTacheSuivi());
        existingTacheSuivi.setStatut(tacheSuiviDTO.getStatut());

        // Fetch the Tache by idTache from the DTO
        if (tacheSuiviDTO.getIdTache() != null) {
            Tache tache = tacheRepository.findById(tacheSuiviDTO.getIdTache())
                    .orElseThrow(() -> new RuntimeException("Tache not found"));

            // Link the TacheSuivi to the Tache
            existingTacheSuivi.setTache(tache);

            // Add the TacheSuivi to the Tache's list of TacheSuivis (if not already present)
            if (!tache.getTacheSuivis().contains(existingTacheSuivi)) {
                tache.getTacheSuivis().add(existingTacheSuivi);
            }

            // Recalculate dureeTacheReelle for the Tache
            tache.calculerDureeTacheReelle();
            tacheRepository.save(tache);



        } else {
            // If idTache is null, remove the TacheSuivi from its current Tache
            if (existingTacheSuivi.getTache() != null) {
                existingTacheSuivi.getTache().getTacheSuivis().remove(existingTacheSuivi);
            }
            existingTacheSuivi.setTache(null);
        }





        // Save the updated TacheSuivi
        TacheSuivi updatedTacheSuivi = tacheSuiviRepository.save(existingTacheSuivi);

        // Save the Tache (to update the relationship)
        if (existingTacheSuivi.getTache() != null) {
            tacheRepository.save(existingTacheSuivi.getTache());
        }

        return modelMapper.map(updatedTacheSuivi, TacheSuiviDTO.class);
    }


    @Override
    public void deleteTacheSuivi(Long id) {
        TacheSuivi tacheSuivi = tacheSuiviRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TacheSuivi not found"));

        // Fetch the associated Tache
        Tache tache = tacheSuivi.getTache();

        // Delete related EnginSuivis, LotSuivis, and MainOeuvreSuivis
        enginSuiviRepository.deleteAll(tacheSuivi.getEnginSuivis());
        lotSuiviRepository.deleteAll(tacheSuivi.getLotSuivis());
        mainOeuvreSuiviRepository.deleteAll(tacheSuivi.getMainOeuvreSuivis());

        // Delete the TacheSuivi
        tacheSuiviRepository.delete(tacheSuivi);

        // Recalculate dureeTacheReelle for the Tache
        if (tache != null) {
            tache.calculerDureeTacheReelle();
            tacheRepository.save(tache);
        }
    }

}