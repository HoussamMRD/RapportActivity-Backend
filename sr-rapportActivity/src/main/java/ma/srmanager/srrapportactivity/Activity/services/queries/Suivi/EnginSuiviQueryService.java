package ma.srmanager.srrapportactivity.Activity.services.queries.Suivi;

import ma.srmanager.srrapportactivity.Activity.models.Suivi.EnginSuiviDTO;

import java.util.List;





public interface EnginSuiviQueryService {
    EnginSuiviDTO getEnginSuiviById(Long id);
    List<EnginSuiviDTO> getAllEnginSuivis();
}
