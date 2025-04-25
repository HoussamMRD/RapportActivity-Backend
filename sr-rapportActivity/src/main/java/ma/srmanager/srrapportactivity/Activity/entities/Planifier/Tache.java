package ma.srmanager.srrapportactivity.Activity.entities.Planifier;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import ma.srmanager.srrapportactivity.Activity.Enums.Statut;
import ma.srmanager.srrapportactivity.Activity.entities.Affaire;
import ma.srmanager.srrapportactivity.Activity.entities.Suivi.TacheSuivi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tache")




public class Tache {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTache;

    // Nom de la tâche
    private String nomTache;

    // Date de début de la tâche
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    // Date de fin de la tâche
    @Temporal(TemporalType.DATE)
    private Date dateFin;


    // Durée réelle de la tâche calculée par la somme des durées des taches suivis
    private Integer dureeTacheReelle;


    // Statut de la tâche (Enum : En attente, En cours, Terminé)
    @Enumerated(EnumType.STRING)
    private Statut statut;






    //  Une tâche appartient à une affaire , Une affaire peut avoir plusieurs tâches
    @ManyToOne
    @JoinColumn(name = "idAffaire" , nullable = false )
    private Affaire affaire;

    //  Une tâche peut avoir plusieurs lots associés
    @OneToMany(mappedBy = "tache", cascade = CascadeType.ALL, fetch = FetchType.LAZY , orphanRemoval = true)
    @JsonManagedReference
    private List<Lot> lots = new ArrayList<>();

    //  Une tâche peut avoir plusieurs main d'oeuvre associées
    @OneToMany(mappedBy = "tache", cascade = CascadeType.ALL , fetch = FetchType.LAZY , orphanRemoval = true)
    @JsonManagedReference
    private List<MainOeuvre> mainOeuvres = new ArrayList<>();

    //  Une tâche peut avoir plusieurs engins associés
    @OneToMany(mappedBy = "tache" , cascade = CascadeType.ALL, fetch = FetchType.LAZY , orphanRemoval = true)
    @JsonManagedReference
    private List<Engin> engins = new ArrayList<>();


    //  Une tâche peut avoir plusieurs tâche suivis associés
    @OneToMany(mappedBy = "tache" , cascade = CascadeType.ALL , fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private List<TacheSuivi> tacheSuivis = new ArrayList<>();







    // Method to add TacheSuivi
    public void addTacheSuivi(TacheSuivi tacheSuivi) {
        this.tacheSuivis.add(tacheSuivi);
        tacheSuivi.setTache(this);
        this.calculerDureeTacheReelle();
    }



    // Méthode pour calculer la durée réelle de la tâche en sommant les durées des taches suivis
    public void calculerDureeTacheReelle() {
        if (tacheSuivis != null) {
            System.out.println("Calculating dureeTacheReelle for Tache ID: " + idTache);
            int totalDuree = tacheSuivis.stream()
                    .mapToInt(tacheSuivi -> {
                        System.out.println("TacheSuivi ID: " + tacheSuivi.getIdTacheSuivi() + ", dureeTacheSuivi: " + tacheSuivi.getDureeTacheSuivi());
                        return tacheSuivi.getDureeTacheSuivi() != null ? tacheSuivi.getDureeTacheSuivi() : 0;
                    })
                    .sum();
            System.out.println("Total dureeTacheReelle: " + totalDuree);
            this.dureeTacheReelle = totalDuree;
        } else {
            this.dureeTacheReelle = 0;
        }
    }



}
