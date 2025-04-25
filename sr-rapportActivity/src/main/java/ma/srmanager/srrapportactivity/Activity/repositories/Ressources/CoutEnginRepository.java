package ma.srmanager.srrapportactivity.Activity.repositories.Ressources;


import ma.srmanager.srrapportactivity.Activity.entities.Ressources.CoutEngin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;



@Repository
public interface CoutEnginRepository extends JpaRepository<CoutEngin, Long> {
    List<CoutEngin> findByTypeEngin(String typeEngin);
}