package ma.srmanager.srrapportactivity.Activity.services.commandes.Planifier;

import ma.srmanager.srrapportactivity.Activity.entities.Affaire;
import ma.srmanager.srrapportactivity.Activity.entities.Planifier.*;
import ma.srmanager.srrapportactivity.Activity.entities.Suivi.TacheSuivi;
import ma.srmanager.srrapportactivity.Activity.mappers.TacheMapper;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.*;
import ma.srmanager.srrapportactivity.Activity.repositories.AffaireRepository;
import ma.srmanager.srrapportactivity.Activity.repositories.Planifier.TacheRepository;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.TacheSuiviRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class TacheCommandServiceImpl implements TacheCommandService {
    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TacheSuiviRepository tacheSuiviRepository;

    @Autowired
    private AffaireRepository affaireRepository;


    @Override
    public TacheDTO createTache(TacheDTO tacheDTO) {


        Tache tache = modelMapper.map(tacheDTO, Tache.class);



        // Fetch the Affaire entity using the provided idAffaire
        if (tacheDTO.getAffaire() != null && tacheDTO.getAffaire().getIdAffaire() != null) {
            Affaire affaire = affaireRepository.findById(tacheDTO.getAffaire().getIdAffaire())
                    .orElseThrow(() -> new RuntimeException("Affaire not found with id: " + tacheDTO.getAffaire().getIdAffaire()));
            tache.setAffaire(affaire);
        } else {
            throw new RuntimeException("Affaire ID is required");
        }




        // Handle Lots and Articles
        if (tacheDTO.getLots() != null) {
            List<Lot> lots = new ArrayList<>();
            for (LotDTO lotDTO : tacheDTO.getLots()) {
                Lot lot = modelMapper.map(lotDTO, Lot.class);
                lot.setTache(tache);

                // Handle Articles
                if (lotDTO.getArticles() != null) {
                    List<Article> articles = new ArrayList<>();
                    for (ArticleDTO articleDTO : lotDTO.getArticles()) {
                        Article article = modelMapper.map(articleDTO, Article.class);
                        article.setLot(lot);  // This is crucial
                        articles.add(article);
                    }
                    lot.setArticles(articles);
                }

                lots.add(lot);
            }
            tache.setLots(lots);
        }

        // Map MainOeuvres
        if (tacheDTO.getMainOeuvres() != null) {
            List<MainOeuvre> mainOeuvres = tacheDTO.getMainOeuvres().stream()
                    .map(mainOeuvreDTO -> {
                        MainOeuvre mainOeuvre = modelMapper.map(mainOeuvreDTO, MainOeuvre.class);
                        mainOeuvre.setTache(tache); // Ensure the Tache reference is set
                        return mainOeuvre;
                    })
                    .collect(Collectors.toList());
            tache.setMainOeuvres(mainOeuvres);
        }

        // Map Engins
        if (tacheDTO.getEngins() != null) {
            List<Engin> engins = tacheDTO.getEngins().stream()
                    .map(enginDTO -> {
                        Engin engin = modelMapper.map(enginDTO, Engin.class);
                        engin.setTache(tache); // Ensure the Tache reference is set
                        return engin;
                    })
                    .collect(Collectors.toList());
            tache.setEngins(engins);
        }

        // Map TacheSuivis
        if (tacheDTO.getTacheSuivis() != null) {
            List<TacheSuivi> tacheSuivis = tacheDTO.getTacheSuivis().stream()
                    .map(tacheSuiviDTO -> {
                        TacheSuivi tacheSuivi = modelMapper.map(tacheSuiviDTO, TacheSuivi.class);
                        tacheSuivi.setTache(tache); // Ensure the Tache reference is set
                        return tacheSuivi;
                    })
                    .collect(Collectors.toList());
            tache.setTacheSuivis(tacheSuivis);
        }

        // Save the Tache
        Tache savedTache = tacheRepository.save(tache);
        return TacheMapper.toTacheDTO(savedTache);

    }


    @Transactional
    @Override
    public TacheDTO updateTache(Long id, TacheDTO tacheDTO) {
        Tache existingTache = tacheRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tache not found with id: " + id));

        // === Update base fields ===
        existingTache.setNomTache(tacheDTO.getNomTache());
        existingTache.setDateDebut(tacheDTO.getDateDebut());
        existingTache.setDateFin(tacheDTO.getDateFin());
        existingTache.setDureeTacheReelle(tacheDTO.getDureeTacheReelle());
        existingTache.setStatut(tacheDTO.getStatut());

        // === Update Affaire ===
        if (tacheDTO.getAffaire() != null && tacheDTO.getAffaire().getIdAffaire() != null) {
            Affaire affaire = affaireRepository.findById(tacheDTO.getAffaire().getIdAffaire())
                    .orElseThrow(() -> new RuntimeException("Affaire not found with id: " + tacheDTO.getAffaire().getIdAffaire()));
            existingTache.setAffaire(affaire);
        } else {
            existingTache.setAffaire(null);
        }

        // === Update Lots & Articles ===
        existingTache.getLots().clear();

        if (tacheDTO.getLots() != null) {
            for (LotDTO lotDTO : tacheDTO.getLots()) {
                if (lotDTO.getNomLot() == null || lotDTO.getNomLot().trim().isEmpty()) continue;

                Lot lot = new Lot();
                lot.setNomLot(lotDTO.getNomLot());
                lot.setTache(existingTache);

                List<Article> articles = new ArrayList<>();
                if (lotDTO.getArticles() != null) {
                    for (ArticleDTO articleDTO : lotDTO.getArticles()) {
                        if (articleDTO.getNomArticle() == null || articleDTO.getNomArticle().trim().isEmpty()) continue;

                        Article article = new Article();
                        article.setNomArticle(articleDTO.getNomArticle());
                        article.setQuantiteArticle(articleDTO.getQuantiteArticle());
                        article.setUniteArticle(articleDTO.getUniteArticle());
                        article.setQuantiteArticleconsomme(articleDTO.getQuantiteArticleconsomme());
                        article.setQuantiteArticleRestant(articleDTO.getQuantiteArticleRestant());
                        article.setLot(lot);

                        articles.add(article);
                    }
                }
                lot.setArticles(articles);
                existingTache.getLots().add(lot);
            }
        }

        // === Update MainOeuvres ===
        existingTache.getMainOeuvres().clear();

        if (tacheDTO.getMainOeuvres() != null) {
            for (MainOeuvreDTO moDTO : tacheDTO.getMainOeuvres()) {
                if (moDTO.getFonctionMO() == null || moDTO.getFonctionMO().trim().isEmpty()) continue;

                MainOeuvre mo = new MainOeuvre();
                mo.setFonctionMO(moDTO.getFonctionMO());
                mo.setNbrMO(moDTO.getNbrMO());
                mo.setTache(existingTache);

                existingTache.getMainOeuvres().add(mo);
            }
        }

        // === Update Engins ===
        existingTache.getEngins().clear();

        if (tacheDTO.getEngins() != null) {
            for (EnginDTO enginDTO : tacheDTO.getEngins()) {
                if (enginDTO.getTypeEngin() == null || enginDTO.getTypeEngin().trim().isEmpty()) continue;

                Engin engin = new Engin();
                engin.setTypeEngin(enginDTO.getTypeEngin());
                engin.setNbrEngin(enginDTO.getNbrEngin());
                engin.setTache(existingTache);

                existingTache.getEngins().add(engin);
            }
        }

        Tache updatedTache = tacheRepository.save(existingTache);
        return TacheMapper.toTacheDTO(updatedTache);
    }



    @Override
    public void deleteTache(Long id) {
        tacheRepository.deleteById(id);
    }
}
