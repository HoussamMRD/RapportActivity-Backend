package ma.srmanager.srrapportactivity.Activity.services.queries.Planifier;

import ma.srmanager.srrapportactivity.Activity.models.Planifier.MainOeuvreDTO;

import java.util.List;



public interface MainOeuvreQueryService {
    MainOeuvreDTO getMainOeuvreById(Long id);
    List<MainOeuvreDTO> getAllMainOeuvres();
}