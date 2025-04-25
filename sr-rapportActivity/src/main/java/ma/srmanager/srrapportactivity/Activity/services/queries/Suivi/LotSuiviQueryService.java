package ma.srmanager.srrapportactivity.Activity.services.queries.Suivi;

import ma.srmanager.srrapportactivity.Activity.models.Suivi.LotSuiviDTO;

import java.util.List;




public interface LotSuiviQueryService {
    LotSuiviDTO getLotSuiviById(Long id);
    List<LotSuiviDTO> getAllLotSuivis();
}