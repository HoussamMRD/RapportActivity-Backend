package ma.srmanager.srrapportactivity.Activity.services.commandes.Suivi;

import ma.srmanager.srrapportactivity.Activity.entities.Suivi.LotSuivi;
import ma.srmanager.srrapportactivity.Activity.entities.Suivi.TacheSuivi;
import ma.srmanager.srrapportactivity.Activity.models.Suivi.LotSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.LotSuiviRepository;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.TacheSuiviRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class LotSuiviCommandServiceImpl implements LotSuiviCommandService {

    private final LotSuiviRepository lotSuiviRepository;
    private final TacheSuiviRepository tacheSuiviRepository;
    private final ModelMapper modelMapper;

    @Override
    public LotSuiviDTO createLotSuivi(LotSuiviDTO lotSuiviDTO) {
        LotSuivi lotSuivi = modelMapper.map(lotSuiviDTO, LotSuivi.class);

        // Fetch the associated TacheSuivi
        TacheSuivi tacheSuivi = tacheSuiviRepository.findById(lotSuiviDTO.getIdTacheSuivi())
                .orElseThrow(() -> new RuntimeException("TacheSuivi not found"));

        // Set the TacheSuivi for the LotSuivi
        lotSuivi.setTacheSuivi(tacheSuivi);

        // Calculate dureeLotSuivi
        lotSuivi.calculerDureeLotSuivi();

        // Save the LotSuivi
        LotSuivi savedLotSuivi = lotSuiviRepository.save(lotSuivi);

        // Recalculate the dureeTacheSuivi for the associated TacheSuivi
        tacheSuivi.calculerDureeTacheSuivi();
        tacheSuiviRepository.save(tacheSuivi);

        return modelMapper.map(savedLotSuivi, LotSuiviDTO.class);
    }







    @Override
    public LotSuiviDTO updateLotSuivi(Long id, LotSuiviDTO lotSuiviDTO) {
        LotSuivi existingLotSuivi = lotSuiviRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LotSuivi not found"));

        // Update fields
        existingLotSuivi.setNomLotSuivi(lotSuiviDTO.getNomLotSuivi());

        // Fetch the associated TacheSuivi
        TacheSuivi tacheSuivi = tacheSuiviRepository.findById(lotSuiviDTO.getIdTacheSuivi())
                .orElseThrow(() -> new RuntimeException("TacheSuivi not found"));

        // Set the TacheSuivi for the LotSuivi
        existingLotSuivi.setTacheSuivi(tacheSuivi);


        // Calculate dureeLotSuivi
        existingLotSuivi.calculerDureeLotSuivi();

        // Save the updated LotSuivi
        LotSuivi updatedLotSuivi = lotSuiviRepository.save(existingLotSuivi);

        // Recalculate the dureeTacheSuivi for the associated TacheSuivi
        tacheSuivi.calculerDureeTacheSuivi();
        tacheSuiviRepository.save(tacheSuivi);

        return modelMapper.map(updatedLotSuivi, LotSuiviDTO.class);
    }












    @Override
    public void deleteLotSuivi(Long id) {
        lotSuiviRepository.deleteById(id);
    }
}