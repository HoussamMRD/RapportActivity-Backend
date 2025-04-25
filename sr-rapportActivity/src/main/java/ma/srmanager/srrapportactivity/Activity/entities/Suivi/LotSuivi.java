package ma.srmanager.srrapportactivity.Activity.entities.Suivi;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lotSuivi")

public class LotSuivi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLotSuivi;


    // Nom du lot suivi
    private String nomLotSuivi;

    // Durée totale du lot suivie (en jours)
    private Integer dureeLotSuivi= 0;

    // Un lot suivi peut avoir plusieurs articles suivis
    @OneToMany(mappedBy = "lotSuivi" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ArticleSuivi> articlesSuivi;

    //  Un lot suivi appartient à une tâche suivie
    @ManyToOne
    @JoinColumn(name = "id_tache_suivi")
    @JsonBackReference
    private TacheSuivi tacheSuivi;


    // Getter for articleSuivis
    public List<ArticleSuivi> getArticleSuivis() {
        return articlesSuivi;
    }

    // Setter for articleSuivis
    public void setArticleSuivis(List<ArticleSuivi> articleSuivis) {
        this.articlesSuivi = articleSuivis;
    }



    // Méthode pour calculer la durée du lot suivi
    public void calculerDureeLotSuivi() {
        this.dureeLotSuivi = (articlesSuivi != null) ?
                articlesSuivi.stream().mapToInt(ArticleSuivi::getDureeArticleSuivi).sum() : 0;
    }


}
