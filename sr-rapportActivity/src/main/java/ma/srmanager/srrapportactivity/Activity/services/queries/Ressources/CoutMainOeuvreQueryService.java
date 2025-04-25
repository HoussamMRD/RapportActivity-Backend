package ma.srmanager.srrapportactivity.Activity.services.queries.Ressources;

import ma.srmanager.srrapportactivity.Activity.models.Ressources.CoutMainOeuvreDTO;

import java.util.List;

public interface CoutMainOeuvreQueryService {


    CoutMainOeuvreDTO getCoutMainOeuvreById(Long id);
    List<CoutMainOeuvreDTO> getAllCoutMainOeuvres();
}
