package ma.srmanager.srrapportactivity.Activity.services.commandes.Ressources;

import ma.srmanager.srrapportactivity.Activity.models.Ressources.EquipePiloteDTO;

public interface EquipePiloteCommandService {


    EquipePiloteDTO createEquipePilote(EquipePiloteDTO equipePiloteDTO);
    EquipePiloteDTO updateEquipePilote(Long id, EquipePiloteDTO equipePiloteDTO);
    void deleteEquipePilote(Long id);


}
