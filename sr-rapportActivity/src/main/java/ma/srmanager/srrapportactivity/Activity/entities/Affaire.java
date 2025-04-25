package ma.srmanager.srrapportactivity.Activity.entities;


import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Tache;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "affaire")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Affaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAffaire;
    private String nomAffaire;


    @OneToMany(mappedBy = "affaire", cascade = CascadeType.ALL)
    private List<Tache> taches = new ArrayList<>();



}
