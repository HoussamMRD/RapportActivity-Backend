package ma.srmanager.srrapportactivity.Activity.mappers;

import ma.srmanager.srrapportactivity.Activity.entities.Affaire;
import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Tache;
import ma.srmanager.srrapportactivity.Activity.models.AffaireDTO;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.EnginDTO;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.LotDTO;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.MainOeuvreDTO;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.TacheDTO;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.ArticleDTO;

import ma.srmanager.srrapportactivity.Activity.models.Suivi.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;








@Service
public class TacheMapper {



    public static TacheDTO toTacheDTO(Tache tache) {
        TacheDTO dto = new TacheDTO();
        dto.setIdTache(tache.getIdTache());
        dto.setNomTache(tache.getNomTache());
        dto.setDateDebut(tache.getDateDebut());
        dto.setDateFin(tache.getDateFin());
        dto.setDureeTacheReelle(tache.getDureeTacheReelle());
        dto.setStatut(tache.getStatut());






        // Map Lots
        if (tache.getLots() != null) {
            dto.setLots(tache.getLots().stream()
                    .map(lot -> {
                        LotDTO lotDTO = new LotDTO();
                        lotDTO.setIdLot(lot.getIdLot());
                        lotDTO.setNomLot(lot.getNomLot());
                        // Map Articles if necessary
                        if (lot.getArticles() != null) {
                            lotDTO.setArticles(lot.getArticles().stream()
                                    .map(article -> {
                                        ArticleDTO articleDTO = new ArticleDTO();
                                        articleDTO.setIdArticle(article.getIdArticle());
                                        articleDTO.setNomArticle(article.getNomArticle());
                                        articleDTO.setQuantiteArticle(article.getQuantiteArticle());
                                        articleDTO.setUniteArticle(article.getUniteArticle());

                                        articleDTO.setQuantiteArticleconsomme(article.getQuantiteArticleconsomme());
                                        articleDTO.setQuantiteArticleRestant(article.getQuantiteArticleRestant());

                                        articleDTO.setIdLot(lot.getIdLot());
                                        return articleDTO;
                                    }).collect(Collectors.toList()));
                        }
                        return lotDTO;
                    }).collect(Collectors.toList()));
        }

        // Map MainOeuvres
        if (tache.getMainOeuvres() != null) {
            dto.setMainOeuvres(tache.getMainOeuvres().stream()
                    .map(mainOeuvre -> {
                        MainOeuvreDTO mainOeuvreDTO = new MainOeuvreDTO();
                        mainOeuvreDTO.setIdMO(mainOeuvre.getIdMO());
                        mainOeuvreDTO.setFonctionMO(mainOeuvre.getFonctionMO());
                        mainOeuvreDTO.setNbrMO(mainOeuvre.getNbrMO());
                        return mainOeuvreDTO;
                    }).collect(Collectors.toList()));
        }

        // Map Engins
        if (tache.getEngins() != null) {
            dto.setEngins(tache.getEngins().stream()
                    .map(engin -> {
                        EnginDTO enginDTO = new EnginDTO();
                        enginDTO.setIdEngin(engin.getIdEngin());
                        enginDTO.setTypeEngin(engin.getTypeEngin());
                        enginDTO.setNbrEngin(engin.getNbrEngin());
                        return enginDTO;
                    }).collect(Collectors.toList()));
        }


        // Set TacheSuivis List
        if (tache.getTacheSuivis() != null) {
            dto.setTacheSuivis(tache.getTacheSuivis().stream()
                    .map(suivi -> {
                        TacheSuiviDTO suiviDTO = new TacheSuiviDTO();
                        suiviDTO.setIdTacheSuivi(suivi.getIdTacheSuivi());
                        suiviDTO.setDureeTacheSuivi(suivi.getDureeTacheSuivi());
                        suiviDTO.setStatut(suivi.getStatut());
                        suiviDTO.setIdTache(suivi.getTache().getIdTache());

                        suiviDTO.setLotsSuivi(suivi.getLotSuivis() != null ? suivi.getLotSuivis().stream()
                                .map(lotSuivi -> {
                                    LotSuiviDTO LotSuiviDTO = new LotSuiviDTO();
                                    LotSuiviDTO.setIdLotSuivi(lotSuivi.getIdLotSuivi() != null ? lotSuivi.getIdLotSuivi() : null);
                                    LotSuiviDTO.setNomLotSuivi(lotSuivi.getNomLotSuivi());


                                    // Map ArticlesSuivi
                                    if (lotSuivi.getArticlesSuivi() != null) {
                                        LotSuiviDTO.setArticlesSuivi(lotSuivi.getArticlesSuivi().stream()
                                                .map(articleSuivi -> {
                                                    ArticleSuiviDTO articleSuiviDTO = new ArticleSuiviDTO();
                                                    articleSuiviDTO.setIdArticleSuivi(articleSuivi.getIdArticleSuivi());
                                                    articleSuiviDTO.setNomArticleSuivi(articleSuivi.getNomArticleSuivi());
                                                    articleSuiviDTO.setQuantiteConsommeArticleSuivi(articleSuivi.getQuantiteConsommeArticleSuivi());
                                                    articleSuiviDTO.setDureeArticleSuivi(articleSuivi.getDureeArticleSuivi());
                                                    articleSuiviDTO.setIdLotSuivi(articleSuivi.getLotSuivi().getIdLotSuivi());
                                                    return articleSuiviDTO;
                                                }).collect(Collectors.toList()));
                                    }
                                    return LotSuiviDTO ;
                                }).collect(Collectors.toList()) : List.of());











                        suiviDTO.setMainOeuvresSuivi(suivi.getMainOeuvreSuivis() != null ? suivi.getMainOeuvreSuivis().stream()
                                .map(mainOeuvreSuivi -> {
                                    MainOeuvreSuiviDTO MainOeuvreSuiviDTO = new MainOeuvreSuiviDTO();
                                    MainOeuvreSuiviDTO.setIdMOSuivi(mainOeuvreSuivi.getIdMOSuivi());
                                    MainOeuvreSuiviDTO.setFonctionMOSuivi(mainOeuvreSuivi.getFonctionMOSuivi());
                                    MainOeuvreSuiviDTO.setNbrMOSuivi(mainOeuvreSuivi.getNbrMOSuivi());
                                    return MainOeuvreSuiviDTO ;
                                }).collect(Collectors.toList()) : List.of());

                        suiviDTO.setEnginsSuivi(suivi.getEnginSuivis() != null ? suivi.getEnginSuivis().stream()
                                .map(enginSuivi -> {
                                    EnginSuiviDTO EnginSuiviDTO = new EnginSuiviDTO();
                                    EnginSuiviDTO.setIdEnginSuivi(enginSuivi.getIdEnginSuivi());
                                    EnginSuiviDTO.setTypeEnginSuivi(enginSuivi.getTypeEnginSuivi());
                                    EnginSuiviDTO.setNbrEnginSuivi(enginSuivi.getNbrEnginSuivi());
                                    return EnginSuiviDTO ;
                                }).collect(Collectors.toList()) : List.of());

                        return suiviDTO;
                    })
                    .collect(Collectors.toList()));
        }

        // Map nomAffaire (simple champ à afficher)
        if (tache.getAffaire() != null) {
          //  dto.setNomAffaire(tache.getAffaire().getNomAffaire());

            // Si tu veux aussi mapper l'objet Affaire entier
            Affaire affaire = tache.getAffaire();
            AffaireDTO affaireDTO = new AffaireDTO();
            affaireDTO.setIdAffaire(affaire.getIdAffaire());
            affaireDTO.setNomAffaire(affaire.getNomAffaire());
            dto.setAffaire(affaireDTO);
        }


        return dto;
    }
}