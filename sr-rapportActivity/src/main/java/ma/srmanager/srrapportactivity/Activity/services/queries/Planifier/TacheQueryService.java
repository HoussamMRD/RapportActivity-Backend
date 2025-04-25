package ma.srmanager.srrapportactivity.Activity.services.queries.Planifier;



import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Tache;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.TacheDTO;

import java.util.List;





public interface TacheQueryService {
    Tache getTacheById(Long id); // Keep this as returning Tache
    TacheDTO getTacheDTOById(Long id); // New method for DTO
    List<TacheDTO> getAllTaches();
    List<TacheDTO> getAllTachesByNomAffaire(String nomAffaire);
}