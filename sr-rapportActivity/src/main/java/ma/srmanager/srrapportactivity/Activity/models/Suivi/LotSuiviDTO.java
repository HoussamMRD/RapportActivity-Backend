package ma.srmanager.srrapportactivity.Activity.models.Suivi;







import lombok.Data;
import java.util.List;


@Data
public class LotSuiviDTO {
    private Long idLotSuivi;
    private String nomLotSuivi;
    private Integer dureeLotSuivi;
    private Long idTacheSuivi;
    private List<ArticleSuiviDTO> articlesSuivi;
}