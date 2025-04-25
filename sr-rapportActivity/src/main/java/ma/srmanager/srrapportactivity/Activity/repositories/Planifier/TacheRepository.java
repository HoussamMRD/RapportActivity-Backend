package ma.srmanager.srrapportactivity.Activity.repositories.Planifier;

import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {


    //  find Tache by nomAffaire
    List<Tache> findByAffaire_NomAffaire(String nomAffaire);





}