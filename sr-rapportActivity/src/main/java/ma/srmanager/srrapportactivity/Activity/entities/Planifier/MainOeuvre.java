package ma.srmanager.srrapportactivity.Activity.entities.Planifier;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import ma.srmanager.srrapportactivity.Activity.entities.Ressources.EquipePilote;


@Entity
@Table(name = "mainoeuvre")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MainOeuvre {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMO;

    // Fonction de la main d'œuvre (par exemple : Ouvrier, Technicien)
    private String fonctionMO;

    // Nombre de personnes nécessaires pour cette tâche
    private Integer nbrMO;

    // Une main d'œuvre appartient à une tâche
    @ManyToOne
    @JoinColumn(name = "tache_id")
    @JsonBackReference
    private Tache tache;


    // Une main d'œuvre appartient à une équipe pilote
    @ManyToOne
    @JoinColumn(name = "equipePilote_id")
    @JsonBackReference
    private EquipePilote equipePilote;



}
