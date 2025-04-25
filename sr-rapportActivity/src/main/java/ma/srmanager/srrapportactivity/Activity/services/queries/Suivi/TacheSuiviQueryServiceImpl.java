package ma.srmanager.srrapportactivity.Activity.services.queries.Suivi;


import ma.srmanager.srrapportactivity.Activity.entities.Suivi.TacheSuivi;
import ma.srmanager.srrapportactivity.Activity.mappers.TacheSuiviMapper;
import ma.srmanager.srrapportactivity.Activity.models.Suivi.TacheSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.TacheSuiviRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;






@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TacheSuiviQueryServiceImpl implements TacheSuiviQueryService {

    private final TacheSuiviRepository tacheSuiviRepository;
    private final TacheSuiviMapper tacheSuiviMapper; // Inject the mapper

    @Override
    public TacheSuiviDTO getTacheSuiviById(Long id) {
        TacheSuivi tacheSuivi = tacheSuiviRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tâche Suivi non trouvée"));
        return tacheSuiviMapper.toTacheSuiviDTO(tacheSuivi);
    }

    @Override
    public List<TacheSuiviDTO> getAllTacheSuivis() {
        return tacheSuiviRepository.findAll().stream()
                .map(tacheSuiviMapper::toTacheSuiviDTO)
                .collect(Collectors.toList());
    }
}