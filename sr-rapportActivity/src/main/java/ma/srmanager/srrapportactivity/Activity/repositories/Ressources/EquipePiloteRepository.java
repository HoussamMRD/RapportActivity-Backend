package ma.srmanager.srrapportactivity.Activity.repositories.Ressources;


import ma.srmanager.srrapportactivity.Activity.entities.Ressources.EquipePilote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;





public interface EquipePiloteRepository extends JpaRepository<EquipePilote, Long> {
    List<EquipePilote> findByNomEquipePilote(String nomEquipePilote);
}
