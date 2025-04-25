package ma.srmanager.srrapportactivity.Activity.services.commandes.Ressources;


import ma.srmanager.srrapportactivity.Activity.models.Ressources.CoutEnginDTO;

public interface CoutEnginCommandService {

   CoutEnginDTO  createCoutEngin(CoutEnginDTO coutEnginDTO);
    CoutEnginDTO updateCoutEngin(Long id, CoutEnginDTO coutEnginDTO);
    void deleteCoutEngin(Long id);
}
