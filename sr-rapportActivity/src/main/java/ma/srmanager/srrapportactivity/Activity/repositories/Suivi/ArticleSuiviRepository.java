package ma.srmanager.srrapportactivity.Activity.repositories.Suivi;




import ma.srmanager.srrapportactivity.Activity.entities.Suivi.ArticleSuivi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleSuiviRepository extends JpaRepository<ArticleSuivi, Long> {
}
