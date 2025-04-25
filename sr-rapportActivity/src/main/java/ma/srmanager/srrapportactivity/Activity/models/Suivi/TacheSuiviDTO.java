package ma.srmanager.srrapportactivity.Activity.models.Suivi;






import lombok.Data;
import ma.srmanager.srrapportactivity.Activity.Enums.Statut;

import java.util.List;





@Data
public class TacheSuiviDTO {
    private Long idTacheSuivi;
    private Integer dureeTacheSuivi;
    private Statut statut;
    private Long idTache;
    private List<LotSuiviDTO> lotsSuivi;
    private List<MainOeuvreSuiviDTO> mainOeuvresSuivi;
    private List<EnginSuiviDTO> enginsSuivi;


}