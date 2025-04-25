package ma.srmanager.srrapportactivity.Activity.entities.Ressources;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CoutMainOeuvre")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class CoutMainOeuvre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCoutMainOeuvre;


    private String FonctionMainOeuvre;


    //cout par jour pour un main d'oeuvre
    private Double coutJrMainOeuvre;



}
