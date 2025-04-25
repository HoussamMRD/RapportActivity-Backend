package ma.srmanager.srrapportactivity.Activity.entities.Suivi;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import ma.srmanager.srrapportactivity.Activity.Enums.Statut;
import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Tache;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tacheSuivi")
public class TacheSuivi  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTacheSuivi;

    // Durée de la tâche suivie (en jours)
    private Integer dureeTacheSuivi = 0;

    // Statut de la tâche suivie
    @Enumerated(EnumType.STRING)
    private Statut statut;

    //  Une tâche suivie appartient à une tâche
    @ManyToOne
    @JoinColumn(name = "tache_id")
    @JsonBackReference
    private Tache tache;

    //  Une tâche suivie peut avoir plusieurs engins suivis
    @OneToMany(mappedBy = "tacheSuivi" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<EnginSuivi> enginSuivis = new ArrayList<>();

    //  Une tâche suivie peut avoir plusieurs lots suivis
    @OneToMany(mappedBy = "tacheSuivi" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<LotSuivi> lotSuivis = new ArrayList<>();

    //  Une tâche suivie peut avoir plusieurs main d'œuvre suivis
    @OneToMany(mappedBy = "tacheSuivi" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<MainOeuvreSuivi> mainOeuvreSuivis = new ArrayList<>();



    // Methods to add entities
    public void addEnginSuivi(EnginSuivi enginSuivi) {
        this.enginSuivis.add(enginSuivi);
        enginSuivi.setTacheSuivi(this);
    }

    public void addLotSuivi(LotSuivi lotSuivi) {
        this.lotSuivis.add(lotSuivi);
        lotSuivi.setTacheSuivi(this);
    }

    public void addMainOeuvreSuivi(MainOeuvreSuivi mainOeuvreSuivi) {
        this.mainOeuvreSuivis.add(mainOeuvreSuivi);
        mainOeuvreSuivi.setTacheSuivi(this);
    }





    // Méthode pour calculer la durée totale de la tâche suivie
    public void calculerDureeTacheSuivi() {
        int totalDuree = 0;

        if (lotSuivis != null) {
            for (LotSuivi lotSuivi : lotSuivis) {
                if (lotSuivi.getDureeLotSuivi() != null) {
                    totalDuree += lotSuivi.getDureeLotSuivi();
                }
            }
        }

        System.out.println("Total dureeTacheSuivi: " + totalDuree);
        this.dureeTacheSuivi = totalDuree;
    }



}
