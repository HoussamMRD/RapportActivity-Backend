package ma.srmanager.srrapportactivity.Activity.entities.Planifier;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import ma.srmanager.srrapportactivity.Activity.entities.Ressources.EquipePilote;


@Entity
@Table(name = "engin")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Engin {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEngin;

    // Type de l'engin
    private String typeEngin;

    // Nombre d'engins nécessaires pour cette tâche
    private Integer nbrEngin;

    //  Un engin appartient à une tâche

    @ManyToOne
    @JoinColumn(name = "tache_id" )
    @JsonBackReference
    private Tache tache;


    // Un engin appartient à une équipe pilote
    @ManyToOne
    @JoinColumn(name = "equipePilote_id")
    @JsonBackReference
    private EquipePilote equipePilote;


}
