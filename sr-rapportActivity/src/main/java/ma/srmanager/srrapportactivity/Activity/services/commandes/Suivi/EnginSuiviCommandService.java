package ma.srmanager.srrapportactivity.Activity.services.commandes.Suivi;



import ma.srmanager.srrapportactivity.Activity.models.Suivi.EnginSuiviDTO;





public interface EnginSuiviCommandService {
    EnginSuiviDTO createEnginSuivi(EnginSuiviDTO enginSuiviDTO);
    EnginSuiviDTO updateEnginSuivi(Long id, EnginSuiviDTO enginSuiviDTO);
    void deleteEnginSuivi(Long id);
}