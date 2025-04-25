package ma.srmanager.srrapportactivity.Activity.models.Ressources;


import lombok.Data;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.EnginDTO;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.MainOeuvreDTO;

import java.util.List;







@Data

public class EquipePiloteDTO {

    private Long idEquipePilote;

    private String nomEquipePilote;

    private List<MainOeuvreDTO> mainOeuvres;

    private List<EnginDTO> engins;




}
