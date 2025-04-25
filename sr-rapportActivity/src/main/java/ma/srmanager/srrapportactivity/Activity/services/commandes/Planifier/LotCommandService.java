package ma.srmanager.srrapportactivity.Activity.services.commandes.Planifier;



import ma.srmanager.srrapportactivity.Activity.models.Planifier.LotDTO;



public interface LotCommandService {
    LotDTO createLot(LotDTO lotDTO);
    LotDTO updateLot(Long id, LotDTO lotDTO);
    void deleteLot(Long id);
}
