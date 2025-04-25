package ma.srmanager.srrapportactivity.Activity.models.Planifier;



import lombok.Data;
import java.util.List;



@Data
public class LotDTO {
    private Long idLot;
    private String nomLot;
    private Long idTache;
    private List<ArticleDTO> articles; // Include full ArticleDTO objects

}