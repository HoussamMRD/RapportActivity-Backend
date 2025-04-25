package ma.srmanager.srrapportactivity.Activity.services.queries.Planifier;

import ma.srmanager.srrapportactivity.Activity.entities.Planifier.MainOeuvre;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.MainOeuvreDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Planifier.MainOeuvreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;






@Service
public class MainOeuvreQueryServiceImpl implements MainOeuvreQueryService {
    @Autowired
    private MainOeuvreRepository mainOeuvreRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MainOeuvreDTO getMainOeuvreById(Long id) {
        MainOeuvre mainOeuvre = mainOeuvreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MainOeuvre not found"));
        return modelMapper.map(mainOeuvre, MainOeuvreDTO.class);
    }

    @Override
    public List<MainOeuvreDTO> getAllMainOeuvres() {
        return mainOeuvreRepository.findAll().stream()
                .map(mainOeuvre -> modelMapper.map(mainOeuvre, MainOeuvreDTO.class))
                .collect(Collectors.toList());
    }
}