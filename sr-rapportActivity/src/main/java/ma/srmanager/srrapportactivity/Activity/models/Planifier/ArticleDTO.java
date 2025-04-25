package ma.srmanager.srrapportactivity.Activity.models.Planifier;






import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;




@Data
public class ArticleDTO {

    private Long idArticle;

    @NotNull(message = "Le nom de l'article est obligatoire")
    private String nomArticle;

    @NotNull(message = "La quantité de l'article est obligatoire")
    private Integer quantiteArticle;

    private String uniteArticle;

    private Integer quantiteArticleconsomme;

    private Integer quantiteArticleRestant;


    private Long idLot;




}

