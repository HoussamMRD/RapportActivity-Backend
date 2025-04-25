package ma.srmanager.srrapportactivity.Activity.services.queries.Suivi;

import ma.srmanager.srrapportactivity.Activity.entities.Suivi.MainOeuvreSuivi;
import ma.srmanager.srrapportactivity.Activity.models.Suivi.MainOeuvreSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.MainOeuvreSuiviRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainOeuvreSuiviQueryServiceImpl implements MainOeuvreSuiviQueryService {

    private final MainOeuvreSuiviRepository mainOeuvreSuiviRepository;
    private final ModelMapper modelMapper;

    @Override
    public MainOeuvreSuiviDTO getMainOeuvreSuiviById(Long id) {
        MainOeuvreSuivi mainOeuvreSuivi = mainOeuvreSuiviRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Main d'œuvre Suivi non trouvée"));
        return modelMapper.map(mainOeuvreSuivi, MainOeuvreSuiviDTO.class);
    }

    @Override
    public List<MainOeuvreSuiviDTO> getAllMainOeuvreSuivis() {
        return mainOeuvreSuiviRepository.findAll().stream()
                .map(mainOeuvreSuivi -> modelMapper.map(mainOeuvreSuivi, MainOeuvreSuiviDTO.class))
                .collect(Collectors.toList());
    }
}