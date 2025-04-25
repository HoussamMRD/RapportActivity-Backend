package ma.srmanager.srrapportactivity.Activity.services.queries.Suivi;

import ma.srmanager.srrapportactivity.Activity.models.Suivi.TacheSuiviDTO;

import java.util.List;



public interface TacheSuiviQueryService {
    TacheSuiviDTO getTacheSuiviById(Long id);
    List<TacheSuiviDTO> getAllTacheSuivis();
}