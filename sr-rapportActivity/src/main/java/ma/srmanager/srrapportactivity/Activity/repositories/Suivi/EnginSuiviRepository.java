package ma.srmanager.srrapportactivity.Activity.repositories.Suivi;



import ma.srmanager.srrapportactivity.Activity.entities.Suivi.EnginSuivi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnginSuiviRepository extends JpaRepository<EnginSuivi, Long> {
}