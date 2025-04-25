package ma.srmanager.srrapportactivity.Activity.services.commandes;


import ma.srmanager.srrapportactivity.Activity.models.AffaireDTO;







public interface AffaireCommandService {
    AffaireDTO createAffaire(AffaireDTO affaireDTO);
    AffaireDTO updateAffaire(Long id, AffaireDTO affaireDTO);
    void deleteAffaire(Long id);
}