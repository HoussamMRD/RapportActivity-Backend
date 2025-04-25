package ma.srmanager.srrapportactivity.Activity.services.queries.Suivi;

import ma.srmanager.srrapportactivity.Activity.entities.Suivi.ArticleSuivi;
import ma.srmanager.srrapportactivity.Activity.models.Suivi.ArticleSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.ArticleSuiviRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleSuiviQueryServiceImpl implements ArticleSuiviQueryService {

    private final ArticleSuiviRepository articleSuiviRepository;
    private final ModelMapper modelMapper;

    @Override
    public ArticleSuiviDTO getArticleSuiviById(Long id) {
        ArticleSuivi articleSuivi = articleSuiviRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ArticleSuivi non trouvé"));
        return modelMapper.map(articleSuivi, ArticleSuiviDTO.class);
    }

    @Override
    public List<ArticleSuiviDTO> getAllArticleSuivis() {
        return articleSuiviRepository.findAll().stream()
                .map(articleSuivi -> modelMapper.map(articleSuivi, ArticleSuiviDTO.class))
                .collect(Collectors.toList());
    }
}