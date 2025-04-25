package ma.srmanager.srrapportactivity.Activity.services.commandes.Ressources;

import ma.srmanager.srrapportactivity.Activity.models.Ressources.CoutMainOeuvreDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Ressources.CoutMainOeuvreRepository;
import org.springframework.stereotype.Service;



public interface CoutMainOeuvreCommandService {
    CoutMainOeuvreDTO createCoutMainOeuvre(CoutMainOeuvreDTO coutMainOeuvreDTO);
    CoutMainOeuvreDTO updateCoutMainOeuvre(Long id, CoutMainOeuvreDTO coutMainOeuvreDTO);
    void deleteCoutMainOeuvre(Long id);
}