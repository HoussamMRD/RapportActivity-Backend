package ma.srmanager.srrapportactivity.Activity.services.commandes.Suivi;

import ma.srmanager.srrapportactivity.Activity.models.Suivi.MainOeuvreSuiviDTO;




public interface MainOeuvreSuiviCommandService {
    MainOeuvreSuiviDTO createMainOeuvreSuivi(MainOeuvreSuiviDTO mainOeuvreSuiviDTO);
    MainOeuvreSuiviDTO updateMainOeuvreSuivi(Long id, MainOeuvreSuiviDTO mainOeuvreSuiviDTO);
    void deleteMainOeuvreSuivi(Long id);
}