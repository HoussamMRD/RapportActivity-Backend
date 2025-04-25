package ma.srmanager.srrapportactivity.Activity.services.queries.Suivi;

import ma.srmanager.srrapportactivity.Activity.entities.Suivi.LotSuivi;
import ma.srmanager.srrapportactivity.Activity.models.Suivi.LotSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Suivi.LotSuiviRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LotSuiviQueryServiceImpl implements LotSuiviQueryService {

    private final LotSuiviRepository lotSuiviRepository;
    private final ModelMapper modelMapper;

    @Override
    public LotSuiviDTO getLotSuiviById(Long id) {
        LotSuivi lotSuivi = lotSuiviRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LotSuivi non trouvé"));
        return modelMapper.map(lotSuivi, LotSuiviDTO.class);
    }

    @Override
    public List<LotSuiviDTO> getAllLotSuivis() {
        return lotSuiviRepository.findAll().stream()
                .map(lotSuivi -> modelMapper.map(lotSuivi, LotSuiviDTO.class))
                .collect(Collectors.toList());
    }
}