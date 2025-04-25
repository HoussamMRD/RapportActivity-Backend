package ma.srmanager.srrapportactivity.Activity.entities.Planifier;



import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;



@Entity
@Table(name = "lot")
@Data
@NoArgsConstructor
@AllArgsConstructor




public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLot;

    // Nom du lot
    private String nomLot;

    //  Un lot appartient à une tâche

    @ManyToOne
    @JoinColumn(name = "tache_id")
    @JsonBackReference
    private Tache tache;

    //  Un lot peut contenir plusieurs articles
    @OneToMany(mappedBy = "lot", cascade = CascadeType.ALL, fetch = FetchType.EAGER , orphanRemoval = true)
    @JsonManagedReference
    private List<Article> articles;
}
