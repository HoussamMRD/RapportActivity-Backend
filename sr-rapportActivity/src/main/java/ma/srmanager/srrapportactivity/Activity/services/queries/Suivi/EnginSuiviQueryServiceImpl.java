package ma.srmanager.srrapportactivity.Activity.services.queries.Suivi;

import ma.srmanager.srrapportactivity.Activity.entities.Suivi.EnginSuivi;
import ma.srmanager.srrapportactivity.Activity.models.Suivi.EnginSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.EnginSuiviRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EnginSuiviQueryServiceImpl implements EnginSuiviQueryService {

    private final EnginSuiviRepository enginSuiviRepository;
    private final ModelMapper modelMapper;

    @Override
    public EnginSuiviDTO getEnginSuiviById(Long id) {
        EnginSuivi enginSuivi = enginSuiviRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Engin Suivi non trouvé"));
        return modelMapper.map(enginSuivi, EnginSuiviDTO.class);
    }

    @Override
    public List<EnginSuiviDTO> getAllEnginSuivis() {
        return enginSuiviRepository.findAll().stream()
                .map(enginSuivi -> modelMapper.map(enginSuivi, EnginSuiviDTO.class))
                .collect(Collectors.toList());
    }
}