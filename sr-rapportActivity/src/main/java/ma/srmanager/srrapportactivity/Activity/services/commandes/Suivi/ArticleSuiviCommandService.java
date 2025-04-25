package ma.srmanager.srrapportactivity.Activity.services.commandes.Suivi;

import ma.srmanager.srrapportactivity.Activity.models.Suivi.ArticleSuiviDTO;




public interface ArticleSuiviCommandService {
    ArticleSuiviDTO createArticleSuivi(ArticleSuiviDTO articleSuiviDTO);
    ArticleSuiviDTO updateArticleSuivi(Long id, ArticleSuiviDTO articleSuiviDTO);
    void deleteArticleSuivi(Long id);
}