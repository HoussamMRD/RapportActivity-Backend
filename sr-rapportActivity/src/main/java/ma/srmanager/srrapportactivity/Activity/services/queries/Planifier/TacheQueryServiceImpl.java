package ma.srmanager.srrapportactivity.Activity.services.queries.Planifier;

import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Tache;
import ma.srmanager.srrapportactivity.Activity.mappers.TacheMapper;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.TacheDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Planifier.TacheRepository;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;








@Service
public class TacheQueryServiceImpl implements TacheQueryService {
    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TacheMapper tacheMapper; // Use an instance instead of static calls


    @Override
    public Tache getTacheById(Long id) {
        System.out.println("Fetching Tache with ID: " + id);
        return tacheRepository.findById(id)
                .orElseThrow(() -> {
                    System.out.println("Tache not found with ID: " + id);
                    return new RuntimeException("Tache not found with ID: " + id);
                });



    }



    @Override
    @Transactional
    public TacheDTO getTacheDTOById(Long id) {
        System.out.println("Fetching TacheDTO with ID: " + id);
        Tache tache = tacheRepository.findById(id)
                .orElseThrow(() -> {
                    System.out.println("Tache not found with ID: " + id);
                    return new RuntimeException("Tache not found with ID: " + id);
                });

        // Initialize lazy-loaded collections
        if (tache.getLots() != null) {
            Hibernate.initialize(tache.getLots());
            System.out.println("Initialized Lots: " + tache.getLots().size());
        }
        if (tache.getMainOeuvres() != null) {
            Hibernate.initialize(tache.getMainOeuvres());
            System.out.println("Initialized MainOeuvres: " + tache.getMainOeuvres().size());
        }
        if (tache.getEngins() != null) {
            Hibernate.initialize(tache.getEngins());
            System.out.println("Initialized Engins: " + tache.getEngins().size());
        }
        if (tache.getTacheSuivis() != null) {
            Hibernate.initialize(tache.getTacheSuivis());
            System.out.println("Initialized TacheSuivis: " + tache.getTacheSuivis().size());
        }

        // Map the Tache entity to TacheDTO
        TacheDTO tacheDTO = modelMapper.map(tache, TacheDTO.class);
        System.out.println("Mapped TacheDTO: " + tacheDTO);

        // Recalculate dureeTacheReelle
        tache.calculerDureeTacheReelle();
        tacheRepository.save(tache);

        return tacheDTO;
    }








    @Override
    public List<TacheDTO> getAllTaches() {
        return tacheRepository.findAll().stream()
                .map(tache -> tacheMapper.toTacheDTO(tache))
                .collect(Collectors.toList());
    }



    @Override
    public List<TacheDTO> getAllTachesByNomAffaire(String nomAffaire) {
        List<Tache> taches = tacheRepository. findByAffaire_NomAffaire(nomAffaire);
        System.out.println("Fetched Taches by nomAffaire: " + nomAffaire + ", Count: " + taches.size());
        return taches.stream()
                .map(tache -> tacheMapper.toTacheDTO(tache))
                .collect(Collectors.toList());
    }
}



