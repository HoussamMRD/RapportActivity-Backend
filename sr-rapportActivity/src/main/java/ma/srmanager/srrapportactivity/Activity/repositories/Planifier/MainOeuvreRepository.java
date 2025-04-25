package ma.srmanager.srrapportactivity.Activity.repositories.Planifier;


import ma.srmanager.srrapportactivity.Activity.entities.Planifier.MainOeuvre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainOeuvreRepository extends JpaRepository<MainOeuvre, Long> {
}