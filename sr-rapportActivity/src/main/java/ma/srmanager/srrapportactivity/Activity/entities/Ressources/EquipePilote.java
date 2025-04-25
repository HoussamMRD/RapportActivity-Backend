package ma.srmanager.srrapportactivity.Activity.entities.Ressources;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Engin;
import ma.srmanager.srrapportactivity.Activity.entities.Planifier.MainOeuvre;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "EquipePilote")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EquipePilote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipePilote;


    private String nomEquipePilote;


    // une equipe pilote peut contenir plusieurs main d'oeuvre
    @OneToMany(mappedBy = "equipePilote")
    @JsonManagedReference
    private List<MainOeuvre> mainOeuvres;


    // une equipe pilote peut contenir plusieurs engins
    @OneToMany(mappedBy = "equipePilote")
    @JsonManagedReference
    private List<Engin> engins;


}
