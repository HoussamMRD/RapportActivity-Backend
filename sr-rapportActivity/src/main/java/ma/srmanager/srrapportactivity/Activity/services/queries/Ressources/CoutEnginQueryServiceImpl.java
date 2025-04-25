package ma.srmanager.srrapportactivity.Activity.services.queries.Ressources;
import lombok.RequiredArgsConstructor;
import ma.srmanager.srrapportactivity.Activity.models.Ressources.CoutEnginDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Ressources.CoutEnginRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoutEnginQueryServiceImpl implements CoutEnginQueryService {


    private final CoutEnginRepository coutEnginRepository;



    public CoutEnginDTO getCoutEnginById(Long id) {
        return coutEnginRepository.findById(id)
                .map(coutEngin -> new CoutEnginDTO(coutEngin.getIdCoutEngin(), coutEngin.getTypeEngin(), coutEngin.getCoutJrEngin()))
                .orElseThrow(() -> new RuntimeException("CoutEngin not found"));
    }


    public List<CoutEnginDTO> getAllCoutEngins() {
        return coutEnginRepository.findAll().stream()
                .map(coutEngin -> new CoutEnginDTO(coutEngin.getIdCoutEngin(), coutEngin.getTypeEngin(), coutEngin.getCoutJrEngin()))
                .collect(Collectors.toList());
    }



}
