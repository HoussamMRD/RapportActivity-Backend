package ma.srmanager.srrapportactivity.Activity.services.commandes.Planifier;

import ma.srmanager.srrapportactivity.Activity.models.Planifier.ArticleDTO;




public interface ArticleCommandService {
    ArticleDTO createArticle(ArticleDTO articleDTO);
    ArticleDTO updateArticle(Long id, ArticleDTO articleDTO);
    void deleteArticle(Long id);
}
