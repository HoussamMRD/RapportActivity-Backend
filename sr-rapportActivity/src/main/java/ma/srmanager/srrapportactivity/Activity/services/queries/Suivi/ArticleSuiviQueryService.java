package ma.srmanager.srrapportactivity.Activity.services.queries.Suivi;

import ma.srmanager.srrapportactivity.Activity.models.Suivi.ArticleSuiviDTO;

import java.util.List;




public interface ArticleSuiviQueryService {
    ArticleSuiviDTO getArticleSuiviById(Long id);
    List<ArticleSuiviDTO> getAllArticleSuivis();
}
