package ma.srmanager.srrapportactivity.Activity.models.Planifier;

import ma.srmanager.srrapportactivity.Activity.entities.Affaire;
import ma.srmanager.srrapportactivity.Activity.Enums.Statut;
import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Tache;
import ma.srmanager.srrapportactivity.Activity.models.AffaireDTO;



import ma.srmanager.srrapportactivity.Activity.models.Suivi.TacheSuiviDTO;

import java.util.List;
import lombok.Data;
import java.util.Date;




@Data
public class TacheDTO {

    private Long idTache;
    private String nomTache;
    private Date dateDebut;
    private Date dateFin;
    private Integer dureeTacheReelle;
    private Statut statut;

   // private String nomAffaire;



    private AffaireDTO affaire;
    private List<LotDTO> lots;
    private List<MainOeuvreDTO> mainOeuvres;
    private List<EnginDTO> engins;
    private List<TacheSuiviDTO> tacheSuivis;







}