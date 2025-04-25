package ma.srmanager.srrapportactivity.Activity.services.queries.Planifier;

import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Article;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.ArticleDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Planifier.ArticleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;







@Service
public class ArticleQueryServiceImpl implements ArticleQueryService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ArticleDTO getArticleById(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        return modelMapper.map(article, ArticleDTO.class);
    }

    @Override
    public List<ArticleDTO> getAllArticles() {
        return articleRepository.findAll().stream()
                .map(article -> modelMapper.map(article, ArticleDTO.class))
                .collect(Collectors.toList());
    }
}
