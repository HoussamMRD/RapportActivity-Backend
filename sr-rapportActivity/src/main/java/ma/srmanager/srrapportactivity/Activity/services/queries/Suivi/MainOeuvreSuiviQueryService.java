package ma.srmanager.srrapportactivity.Activity.services.queries.Suivi;


import ma.srmanager.srrapportactivity.Activity.models.Suivi.MainOeuvreSuiviDTO;

import java.util.List;




public interface MainOeuvreSuiviQueryService {
    MainOeuvreSuiviDTO getMainOeuvreSuiviById(Long id);
    List<MainOeuvreSuiviDTO> getAllMainOeuvreSuivis();
}