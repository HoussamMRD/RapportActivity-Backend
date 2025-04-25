package ma.srmanager.srrapportactivity.Activity.repositories.Ressources;
import ma.srmanager.srrapportactivity.Activity.entities.Ressources.CoutMainOeuvre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CoutMainOeuvreRepository extends JpaRepository<CoutMainOeuvre, Long> {


}