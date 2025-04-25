package ma.srmanager.srrapportactivity.Activity.services.commandes.Suivi;

import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Article;
import ma.srmanager.srrapportactivity.Activity.entities.Suivi.ArticleSuivi;
import ma.srmanager.srrapportactivity.Activity.entities.Suivi.LotSuivi;
import ma.srmanager.srrapportactivity.Activity.entities.Suivi.TacheSuivi;
import ma.srmanager.srrapportactivity.Activity.models.Suivi.ArticleSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Planifier.ArticleRepository;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.ArticleSuiviRepository;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.LotSuiviRepository;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.TacheSuiviRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleSuiviCommandServiceImpl implements ArticleSuiviCommandService {

    private final ArticleSuiviRepository articleSuiviRepository;
    private final LotSuiviRepository lotSuiviRepository;
    private final TacheSuiviRepository tacheSuiviRepository;
    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;

    @Override
    public ArticleSuiviDTO createArticleSuivi(ArticleSuiviDTO articleSuiviDTO) {
        ArticleSuivi articleSuivi = modelMapper.map(articleSuiviDTO, ArticleSuivi.class);

        // Ensure dureeArticleSuivi is not null
        if (articleSuivi.getDureeArticleSuivi() == null) {
            articleSuivi.setDureeArticleSuivi(0);
        }

        // Fetch the associated LotSuivi
        LotSuivi lotSuivi = lotSuiviRepository.findById(articleSuiviDTO.getIdLotSuivi())
                .orElseThrow(() -> new RuntimeException("LotSuivi not found"));

        // Set the LotSuivi for the ArticleSuivi
        articleSuivi.setLotSuivi(lotSuivi);


        // Fetch the associated Article
        Article article = articleRepository.findById(articleSuiviDTO.getIdArticle())
                .orElseThrow(() -> new RuntimeException("Article not found"));
        articleSuivi.setArticle(article); // Set the article field



        // Save the ArticleSuivi
        ArticleSuivi savedArticleSuivi = articleSuiviRepository.save(articleSuivi);

        // Recalculate quantiteArticleconsomme for the associated Article
        article.calculerQuantiteArticleconsomme();
        articleRepository.save(article);

        // Recalculate the dureeLotSuivi for the associated LotSuivi
        lotSuivi.calculerDureeLotSuivi();
        lotSuiviRepository.save(lotSuivi);


        // Recalculate dureeTacheSuivi for the associated TacheSuivi
        TacheSuivi tacheSuivi = lotSuivi.getTacheSuivi();
        tacheSuivi.calculerDureeTacheSuivi();
        tacheSuiviRepository.save(tacheSuivi);

        return modelMapper.map(savedArticleSuivi, ArticleSuiviDTO.class);
    }

    @Override
    public ArticleSuiviDTO updateArticleSuivi(Long id, ArticleSuiviDTO articleSuiviDTO) {
        ArticleSuivi existingArticleSuivi = articleSuiviRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ArticleSuivi not found"));

        // Update fields
        existingArticleSuivi.setNomArticleSuivi(articleSuiviDTO.getNomArticleSuivi());
        existingArticleSuivi.setQuantiteConsommeArticleSuivi(articleSuiviDTO.getQuantiteConsommeArticleSuivi());
        existingArticleSuivi.setDureeArticleSuivi(articleSuiviDTO.getDureeArticleSuivi());

        // Fetch the associated LotSuivi
        LotSuivi lotSuivi = lotSuiviRepository.findById(articleSuiviDTO.getIdLotSuivi())
                .orElseThrow(() -> new RuntimeException("LotSuivi not found"));

        // Set the LotSuivi for the ArticleSuivi
        existingArticleSuivi.setLotSuivi(lotSuivi);



        // Fetch the associated Article
        Article article = articleRepository.findById(articleSuiviDTO.getIdArticle())
                .orElseThrow(() -> new RuntimeException("Article not found"));
        existingArticleSuivi.setArticle(article); // Set the article field



        // Save the updated ArticleSuivi
        ArticleSuivi updatedArticleSuivi = articleSuiviRepository.save(existingArticleSuivi);


        // Recalculate quantiteArticleconsomme for the associated Article
        article.calculerQuantiteArticleconsomme();
        articleRepository.save(article);

        // Recalculate the dureeLotSuivi for the associated LotSuivi
        lotSuivi.calculerDureeLotSuivi();
        lotSuiviRepository.save(lotSuivi);


        // Recalculate dureeTacheSuivi for the associated TacheSuivi
        TacheSuivi tacheSuivi = lotSuivi.getTacheSuivi();
        tacheSuivi.calculerDureeTacheSuivi();
        tacheSuiviRepository.save(tacheSuivi);

        return modelMapper.map(updatedArticleSuivi, ArticleSuiviDTO.class);
    }





    @Override
    public void deleteArticleSuivi(Long id) {
        // Fetch the ArticleSuivi to be deleted
        ArticleSuivi articleSuivi = articleSuiviRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ArticleSuivi not found"));

        // Fetch the associated LotSuivi
        LotSuivi lotSuivi = articleSuivi.getLotSuivi();
        Article article = articleSuivi.getArticle();


        // Remove the ArticleSuivi from the LotSuivi's articlesSuivi list
        if (lotSuivi != null && lotSuivi.getArticlesSuivi() != null) {
            lotSuivi.getArticlesSuivi().remove(articleSuivi);
        }

        // Delete the ArticleSuivi
        articleSuiviRepository.delete(articleSuivi);

        // Recalculate quantiteArticleconsomme for the associated Article
        if (article != null) {
            article.calculerQuantiteArticleconsomme();
            articleRepository.save(article);
        }

        // Recalculate dureeLotSuivi for the associated LotSuivi
        if (lotSuivi != null) {
            lotSuivi.calculerDureeLotSuivi();
            lotSuiviRepository.save(lotSuivi);

            // Recalculate dureeTacheSuivi for the associated TacheSuivi
            TacheSuivi tacheSuivi = lotSuivi.getTacheSuivi();
            if (tacheSuivi != null) {
                tacheSuivi.calculerDureeTacheSuivi();
                tacheSuiviRepository.save(tacheSuivi);
            }
        }




    }



















}