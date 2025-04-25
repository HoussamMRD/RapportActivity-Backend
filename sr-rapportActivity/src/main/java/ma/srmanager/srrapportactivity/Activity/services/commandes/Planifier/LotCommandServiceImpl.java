package ma.srmanager.srrapportactivity.Activity.services.commandes.Planifier;

import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Lot;
import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Tache;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.LotDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Planifier.LotRepository;
import ma.srmanager.srrapportactivity.Activity.repositories.Planifier.TacheRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;








@Service
public class LotCommandServiceImpl implements LotCommandService {
    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public LotDTO createLot(LotDTO lotDTO) {
        Lot lot = modelMapper.map(lotDTO, Lot.class);

        // Fetch the Tache by idTache
        Tache tache = tacheRepository.findById(lotDTO.getIdTache())
                .orElseThrow(() -> new RuntimeException("Tache not found"));

        // Link the Lot to the Tache
        lot.setTache(tache);

        // Add the Lot to the Tache's list of Lots
        tache.getLots().add(lot);

        // Save the Lot
        Lot savedLot = lotRepository.save(lot);

        // Save the Tache (to update the relationship)
        tacheRepository.save(tache);

        return modelMapper.map(savedLot, LotDTO.class);
    }

    @Override
    public LotDTO updateLot(Long id, LotDTO lotDTO) {
        // Fetch the existing Lot by ID
        Lot existingLot = lotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lot not found"));

        // Update the fields from the DTO
        existingLot.setNomLot(lotDTO.getNomLot());

        // Fetch the Tache by idTache from the DTO
        if (lotDTO.getIdTache() != null) {
            Tache tache = tacheRepository.findById(lotDTO.getIdTache())
                    .orElseThrow(() -> new RuntimeException("Tache not found"));

            // Link the Lot to the Tache
            existingLot.setTache(tache);

            // Add the Lot to the Tache's list of Lots (if not already present)
            if (!tache.getLots().contains(existingLot)) {
                tache.getLots().add(existingLot);
            }
        } else {
            // If idTache is null, remove the Lot from its current Tache
            if (existingLot.getTache() != null) {
                existingLot.getTache().getLots().remove(existingLot);
            }
            existingLot.setTache(null);
        }

        // Save the updated Lot
        Lot updatedLot = lotRepository.save(existingLot);

        // Save the Tache (to update the relationship)
        if (existingLot.getTache() != null) {
            tacheRepository.save(existingLot.getTache());
        }

        return modelMapper.map(updatedLot, LotDTO.class);
    }

    @Override
    public void deleteLot(Long id) {
        lotRepository.deleteById(id);
    }
}
