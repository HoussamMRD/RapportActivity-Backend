package ma.srmanager.srrapportactivity.Activity.models.Ressources;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoutMainOeuvreDTO {
    private Long idCoutMainOeuvre;
    private String fonctionMainOeuvre;
    private Double coutJrMainOeuvre;
}