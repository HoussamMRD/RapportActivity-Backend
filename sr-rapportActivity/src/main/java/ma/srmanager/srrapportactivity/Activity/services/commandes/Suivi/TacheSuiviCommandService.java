package ma.srmanager.srrapportactivity.Activity.services.commandes.Suivi;


import ma.srmanager.srrapportactivity.Activity.models.Suivi.TacheSuiviDTO;




public interface TacheSuiviCommandService {
    TacheSuiviDTO createTacheSuivi(TacheSuiviDTO tacheSuiviDTO);
    TacheSuiviDTO updateTacheSuivi(Long id, TacheSuiviDTO tacheSuiviDTO);
    void deleteTacheSuivi(Long id);
}