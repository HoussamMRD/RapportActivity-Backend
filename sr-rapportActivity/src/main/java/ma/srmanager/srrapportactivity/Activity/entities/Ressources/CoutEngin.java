package ma.srmanager.srrapportactivity.Activity.entities.Ressources;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "coutEngin")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class CoutEngin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCoutEngin;

    private String typeEngin;

    //cout par jour pour un engin
    private Double coutJrEngin;





}
