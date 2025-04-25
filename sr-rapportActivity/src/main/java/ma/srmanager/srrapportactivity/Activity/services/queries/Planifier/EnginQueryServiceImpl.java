package ma.srmanager.srrapportactivity.Activity.services.queries.Planifier;


import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Engin;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.EnginDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Planifier.EnginRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service

public class EnginQueryServiceImpl implements EnginQueryService {


    @Autowired
    private EnginRepository enginRepository;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public EnginDTO getEnginById(Long id) {
        Engin engin = enginRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Engin non trouvé"));
        return modelMapper.map(engin, EnginDTO.class);
    }

    @Override
    public List<EnginDTO> getAllEngins() {
        return enginRepository.findAll().stream()
                .map(engin -> modelMapper.map(engin, EnginDTO.class))
                .collect(Collectors.toList());
    }





}
