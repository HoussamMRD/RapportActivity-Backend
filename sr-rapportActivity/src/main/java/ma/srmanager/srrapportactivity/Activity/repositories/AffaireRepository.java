package ma.srmanager.srrapportactivity.Activity.repositories;



import ma.srmanager.srrapportactivity.Activity.entities.Affaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffaireRepository extends JpaRepository<Affaire, Long> {
}
