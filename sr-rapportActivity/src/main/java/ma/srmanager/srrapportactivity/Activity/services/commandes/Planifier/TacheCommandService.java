package ma.srmanager.srrapportactivity.Activity.services.commandes.Planifier;

import ma.srmanager.srrapportactivity.Activity.models.Planifier.TacheDTO;





public interface TacheCommandService {
    TacheDTO createTache(TacheDTO tacheDTO);
    TacheDTO updateTache(Long id, TacheDTO tacheDTO);
    void deleteTache(Long id);
}