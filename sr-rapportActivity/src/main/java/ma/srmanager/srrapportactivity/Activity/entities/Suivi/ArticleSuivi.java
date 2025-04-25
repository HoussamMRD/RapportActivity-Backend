package ma.srmanager.srrapportactivity.Activity.entities.Suivi;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Article;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "article_suivi")


public class ArticleSuivi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticleSuivi;

    // Nom de l'article suivi
    private String nomArticleSuivi;

    // Quantité consommée de l'article suivi
    private Integer quantiteConsommeArticleSuivi;

    // Durée de l'article suivi (en jours)
    private Integer dureeArticleSuivi;

    //  Un article suivi appartient à un lot suivi
    @ManyToOne
    @JoinColumn(name = "lotsuivi_id")
    @JsonBackReference
    private LotSuivi lotSuivi;


    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;







}