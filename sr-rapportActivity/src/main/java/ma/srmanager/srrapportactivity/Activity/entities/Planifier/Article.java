package ma.srmanager.srrapportactivity.Activity.entities.Planifier;

import ma.srmanager.srrapportactivity.Activity.entities.Suivi.ArticleSuivi;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;


@Entity
@Table(name = "article")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Article {





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticle;

    // Nom de l'article
    private String nomArticle;

    // Quantité d'articles dans le lot
    private Integer quantiteArticle;

    // Unité de mesure de l'article
    private String uniteArticle;


    private Integer quantiteArticleconsomme;

    // Quantité d'articles restant dans le lot
    private Integer quantiteArticleRestant;







    // Un article appartient à un lot
    @ManyToOne
    @JoinColumn(name = "lot_id")
    @JsonBackReference
    private Lot lot;





    // Liste des articles suivis associés à cet article
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<ArticleSuivi> articlesSuivis;





    public void setQuantiteArticle(Integer quantiteArticle) {
        this.quantiteArticle = (quantiteArticle != null) ? quantiteArticle : 0;
        calculerQuantiteArticleRestant();
    }

    public void setQuantiteArticleconsomme(Integer quantiteArticleconsomme) {
        this.quantiteArticleconsomme = (quantiteArticleconsomme != null) ? quantiteArticleconsomme : 0;
        calculerQuantiteArticleRestant();

    }








    // / la quantité d'articles consommé calculée par la somme des quantités des articles suivis
    public void calculerQuantiteArticleconsomme() {
        if (articlesSuivis != null) {
            this.quantiteArticleconsomme = articlesSuivis.stream()
                    .filter(articleSuivi ->
                            articleSuivi.getArticle() != null &&
                                    articleSuivi.getArticle().getIdArticle().equals(this.idArticle)
                    )
                    .mapToInt(ArticleSuivi::getQuantiteConsommeArticleSuivi)
                    .sum();
        } else {
            this.quantiteArticleconsomme = 0;
        }
    }


    // Méthode pour calculer la quantité d'articles restant dans le lot
    public void calculerQuantiteArticleRestant() {
        this.quantiteArticleRestant = (quantiteArticle != null ? quantiteArticle : 0) - (quantiteArticleconsomme != null ? quantiteArticleconsomme : 0);
    }









    @PrePersist
    @PreUpdate
    public void beforeSave() {
        System.out.println("Before Save Triggered for Article ID: " + this.idArticle);
        System.out.println("Before Calculation: quantiteArticleRestant = " + this.quantiteArticleRestant);

        calculerQuantiteArticleconsomme();
        calculerQuantiteArticleRestant();


        System.out.println("After Calculation: quantiteArticleRestant = " + this.quantiteArticleRestant);

    }





}