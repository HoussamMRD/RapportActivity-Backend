package ma.srmanager.srrapportactivity.Activity.services.queries.Planifier;

import ma.srmanager.srrapportactivity.Activity.models.Planifier.ArticleDTO;

import java.util.List;



public interface ArticleQueryService {
    ArticleDTO getArticleById(Long id);
    List<ArticleDTO> getAllArticles();
}