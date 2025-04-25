package ma.srmanager.srrapportactivity.Activity.entities.Suivi;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;




@Entity
@Table(name = "mainoeuvreSuivi")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class MainOeuvreSuivi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMOSuivi;

    // Fonction de la main d'œuvre suivi
    private String fonctionMOSuivi;

    // Nombre de personnes nécessaires pour cette tâche suivie
    private Integer nbrMOSuivi;

    // Une main d'œuvre suivi appartient à une tâche suivi
    @ManyToOne
    @JoinColumn(name = "id_tache_suivi")
    @JsonBackReference
    private TacheSuivi tacheSuivi;




}
