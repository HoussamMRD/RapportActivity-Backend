package ma.srmanager.srrapportactivity.Activity.services.commandes.Planifier;


import ma.srmanager.srrapportactivity.Activity.models.Planifier.EnginDTO;





public interface EnginCommandService {
    EnginDTO createEngin(EnginDTO enginDTO);
    EnginDTO updateEngin(Long id, EnginDTO enginDTO);
    void deleteEngin(Long id);
}