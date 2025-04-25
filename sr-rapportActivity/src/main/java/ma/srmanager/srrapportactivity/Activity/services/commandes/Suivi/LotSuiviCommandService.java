package ma.srmanager.srrapportactivity.Activity.services.commandes.Suivi;

import ma.srmanager.srrapportactivity.Activity.models.Suivi.LotSuiviDTO;



public interface LotSuiviCommandService {
    LotSuiviDTO createLotSuivi(LotSuiviDTO lotSuiviDTO);
    LotSuiviDTO updateLotSuivi(Long id, LotSuiviDTO lotSuiviDTO);
    void deleteLotSuivi(Long id);
}