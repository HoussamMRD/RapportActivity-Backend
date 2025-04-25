package ma.srmanager.srrapportactivity.Activity.services.queries.Ressources;


import ma.srmanager.srrapportactivity.Activity.models.Ressources.CoutEnginDTO;

import java.util.List;

public interface CoutEnginQueryService {

    CoutEnginDTO getCoutEnginById(Long id);
    List<CoutEnginDTO> getAllCoutEngins();
}
