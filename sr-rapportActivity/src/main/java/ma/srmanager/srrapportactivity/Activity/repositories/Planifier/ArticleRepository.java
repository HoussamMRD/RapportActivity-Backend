package ma.srmanager.srrapportactivity.Activity.repositories.Planifier;




import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
