package ma.srmanager.srrapportactivity.Activity.services.queries.Planifier;

import ma.srmanager.srrapportactivity.Activity.models.Planifier.LotDTO;
import java.util.List;





public interface LotQueryService {
    LotDTO getLotById(Long id);
    List<LotDTO> getAllLots();


}