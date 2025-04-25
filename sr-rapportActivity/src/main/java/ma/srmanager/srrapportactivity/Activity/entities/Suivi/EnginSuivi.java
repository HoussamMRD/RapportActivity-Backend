package ma.srmanager.srrapportactivity.Activity.entities.Suivi;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enginSuivi")


public class EnginSuivi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnginSuivi;


    // type de l'engin
    private String typeEnginSuivi;

    // Nombre d'engins nécessaires pour cette tâche suivie
    private Integer nbrEnginSuivi;

    //  Un engin suivi appartient à une tâche suivie
    @ManyToOne
    @JoinColumn(name = "id_tache_suivi")
    @JsonBackReference
    private TacheSuivi tacheSuivi;










}
