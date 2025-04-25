package ma.srmanager.srrapportactivity.Activity.repositories.Planifier;



import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Engin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnginRepository extends JpaRepository<Engin, Long> {
}