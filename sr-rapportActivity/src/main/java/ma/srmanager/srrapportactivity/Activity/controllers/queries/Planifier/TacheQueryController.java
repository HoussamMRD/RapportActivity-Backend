package ma.srmanager.srrapportactivity.Activity.controllers.queries.Planifier;

import ma.srmanager.srrapportactivity.Activity.mappers.TacheMapper;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.TacheDTO;
import ma.srmanager.srrapportactivity.Activity.services.queries.Planifier.TacheQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;






@RestController
@RequestMapping("/api/query/taches")
@CrossOrigin("*")


public class TacheQueryController {

    private final TacheQueryService TacheQueryService;


    @Autowired
    private TacheQueryService tacheQueryService;

    private final TacheMapper tacheMapper;


    public TacheQueryController(TacheQueryService tacheQueryService, TacheMapper tacheMapper) {
        this.TacheQueryService = tacheQueryService;
        this.tacheMapper = tacheMapper;
    }

    // Get a Tache by ID
    @GetMapping("/getTacheById/{id}")
    public TacheDTO getTacheById(@PathVariable Long id) {
        return tacheMapper.toTacheDTO(tacheQueryService.getTacheById(id));
    }

    // Get a TacheDTO by ID
    @GetMapping("/getTacheDTOById/{id}")
    public TacheDTO getTacheDTOById(@PathVariable Long id) {
        return tacheQueryService.getTacheDTOById(id);
    }


    // Get all Taches
    @GetMapping("/getAllTaches")
    public List<TacheDTO> getAllTaches() {
        return tacheQueryService.getAllTaches();
    }

    // Get all Taches by nom affaire
    @GetMapping("/getAllTachesByNomAffaire/{nomAffaire}")
    public List<TacheDTO> getAllTachesByNomAffaire(@PathVariable String nomAffaire) {
        return tacheQueryService.getAllTachesByNomAffaire(nomAffaire);
    }









}