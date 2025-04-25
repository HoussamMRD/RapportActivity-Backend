package ma.srmanager.srrapportactivity.Activity.services.queries;


import ma.srmanager.srrapportactivity.Activity.models.AffaireDTO;

import java.util.List;








public interface AffaireQueryService {
    AffaireDTO getAffaireById(Long id);
    List<AffaireDTO> getAllAffaires();
}
