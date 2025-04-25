package ma.srmanager.srrapportactivity.Activity.services.queries.Planifier;

import ma.srmanager.srrapportactivity.Activity.models.Planifier.EnginDTO;


import java.util.List;



public interface EnginQueryService {
    EnginDTO getEnginById(Long id);
    List<EnginDTO> getAllEngins();
}