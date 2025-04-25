package ma.srmanager.srrapportactivity.Activity.services.commandes.Planifier;

import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Article;
import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Lot;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.ArticleDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Planifier.ArticleRepository;
import ma.srmanager.srrapportactivity.Activity.repositories.Planifier.LotRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ArticleCommandServiceImpl implements ArticleCommandService {

    private final ArticleRepository articleRepository;
    private final LotRepository lotRepository;
    private final ModelMapper modelMapper;

    public ArticleCommandServiceImpl(ArticleRepository articleRepository, LotRepository lotRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.lotRepository = lotRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ArticleDTO createArticle(ArticleDTO articleDTO) {
        Article article = modelMapper.map(articleDTO, Article.class);

        // Vérification du Lot
        if (articleDTO.getIdLot() != null) {
            Lot lot = lotRepository.findById(articleDTO.getIdLot())
                    .orElseThrow(() -> new RuntimeException("Lot introuvable avec l'ID : " + articleDTO.getIdLot()));
            article.setLot(lot);
        }

        // Initialize fields if null
        if (article.getQuantiteArticle() == null) {
            article.setQuantiteArticle(0);
        }


        article.calculerQuantiteArticleconsomme();
        article.calculerQuantiteArticleRestant();


        System.out.println("After calculation in createArticle:");
        System.out.println("quantiteArticleRestant = " + article.getQuantiteArticleRestant());



        // Perform calculations in the correct order
        article.calculerQuantiteArticleconsomme();
        article.calculerQuantiteArticleRestant();


        return modelMapper.map(articleRepository.save(article), ArticleDTO.class);
    }

    @Override
    public ArticleDTO updateArticle(Long id, ArticleDTO articleDTO) {
        Article existingArticle = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article introuvable"));

        existingArticle.setNomArticle(articleDTO.getNomArticle());
        existingArticle.setQuantiteArticle(articleDTO.getQuantiteArticle());
        existingArticle.setUniteArticle(articleDTO.getUniteArticle());

        existingArticle.calculerQuantiteArticleconsomme();
        existingArticle.calculerQuantiteArticleRestant();


        // Initialize fields if null
        if (existingArticle.getQuantiteArticle() == null) {
            existingArticle.setQuantiteArticle(0);
        }


        // Perform calculations in the correct order
        existingArticle.calculerQuantiteArticleconsomme();
        existingArticle.calculerQuantiteArticleRestant();

        System.out.println("After calculation in updateArticle:");
        System.out.println("quantiteArticleRestant = " + existingArticle.getQuantiteArticleRestant());



        return modelMapper.map(articleRepository.save(existingArticle), ArticleDTO.class);
    }



    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
