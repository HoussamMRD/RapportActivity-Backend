package ma.srmanager.srrapportactivity.Activity.models.Suivi;








import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;





@Data
public class ArticleSuiviDTO {

    private Long idArticleSuivi;

    private String nomArticleSuivi;


    private Integer quantiteConsommeArticleSuivi;


    private Integer dureeArticleSuivi;

    private Long idLotSuivi;

    private Long idArticle;
}
