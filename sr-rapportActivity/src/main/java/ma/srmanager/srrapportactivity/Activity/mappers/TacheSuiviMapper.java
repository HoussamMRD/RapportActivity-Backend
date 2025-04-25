package ma.srmanager.srrapportactivity.Activity.mappers;

import ma.srmanager.srrapportactivity.Activity.models.Suivi.*;
import ma.srmanager.srrapportactivity.Activity.entities.Suivi.*;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TacheSuiviMapper {

    public TacheSuiviDTO toTacheSuiviDTO(TacheSuivi tacheSuivi) {
        if (tacheSuivi == null) {
            return null;
        }

        TacheSuiviDTO dto = new TacheSuiviDTO();
        dto.setIdTacheSuivi(tacheSuivi.getIdTacheSuivi());
        dto.setDureeTacheSuivi(tacheSuivi.getDureeTacheSuivi());
        dto.setStatut(tacheSuivi.getStatut());
        dto.setIdTache(tacheSuivi.getTache() != null ? tacheSuivi.getTache().getIdTache() : null);

        // Map LotsSuivi
        if (tacheSuivi.getLotSuivis() != null) {
            dto.setLotsSuivi(tacheSuivi.getLotSuivis().stream()
                    .map(lotSuivi -> {
                        LotSuiviDTO lotSuiviDTO = new LotSuiviDTO();
                        lotSuiviDTO.setIdLotSuivi(lotSuivi.getIdLotSuivi());
                        lotSuiviDTO.setNomLotSuivi(lotSuivi.getNomLotSuivi());
                        lotSuiviDTO.setDureeLotSuivi(lotSuivi.getDureeLotSuivi());
                        lotSuiviDTO.setIdTacheSuivi(lotSuivi.getTacheSuivi().getIdTacheSuivi());

                        // Map ArticlesSuivi
                        if (lotSuivi.getArticlesSuivi() != null) {
                            lotSuiviDTO.setArticlesSuivi(lotSuivi.getArticlesSuivi().stream()
                                    .map(articleSuivi -> {
                                        ArticleSuiviDTO articleSuiviDTO = new ArticleSuiviDTO();
                                        articleSuiviDTO.setIdArticleSuivi(articleSuivi.getIdArticleSuivi());
                                        articleSuiviDTO.setNomArticleSuivi(articleSuivi.getNomArticleSuivi());
                                        articleSuiviDTO.setQuantiteConsommeArticleSuivi(articleSuivi.getQuantiteConsommeArticleSuivi());
                                        articleSuiviDTO.setDureeArticleSuivi(articleSuivi.getDureeArticleSuivi());
                                        articleSuiviDTO.setIdLotSuivi(articleSuivi.getLotSuivi().getIdLotSuivi());
                                        return articleSuiviDTO;
                                    })
                                    .collect(Collectors.toList()));
                        }

                        return lotSuiviDTO;
                    })
                    .collect(Collectors.toList()));
        }

        // Map MainOeuvresSuivi
        if (tacheSuivi.getMainOeuvreSuivis() != null) {
            dto.setMainOeuvresSuivi(tacheSuivi.getMainOeuvreSuivis().stream()
                    .map(mainOeuvreSuivi -> {
                        MainOeuvreSuiviDTO mainOeuvreSuiviDTO = new MainOeuvreSuiviDTO();
                        mainOeuvreSuiviDTO.setIdMOSuivi(mainOeuvreSuivi.getIdMOSuivi());
                        mainOeuvreSuiviDTO.setFonctionMOSuivi(mainOeuvreSuivi.getFonctionMOSuivi());
                        mainOeuvreSuiviDTO.setNbrMOSuivi(mainOeuvreSuivi.getNbrMOSuivi());
                        mainOeuvreSuiviDTO.setIdTacheSuivi(mainOeuvreSuivi.getTacheSuivi().getIdTacheSuivi());
                        return mainOeuvreSuiviDTO;
                    })
                    .collect(Collectors.toList()));
        }

        // Map EnginsSuivi
        if (tacheSuivi.getEnginSuivis() != null) {
            dto.setEnginsSuivi(tacheSuivi.getEnginSuivis().stream()
                    .map(enginSuivi -> {
                        EnginSuiviDTO enginSuiviDTO = new EnginSuiviDTO();
                        enginSuiviDTO.setIdEnginSuivi(enginSuivi.getIdEnginSuivi());
                        enginSuiviDTO.setTypeEnginSuivi(enginSuivi.getTypeEnginSuivi());
                        enginSuiviDTO.setNbrEnginSuivi(enginSuivi.getNbrEnginSuivi());
                        enginSuiviDTO.setIdTacheSuivi(enginSuivi.getTacheSuivi().getIdTacheSuivi());
                        return enginSuiviDTO;
                    })
                    .collect(Collectors.toList()));
        }

        return dto;
    }
}