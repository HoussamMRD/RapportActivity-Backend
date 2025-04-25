package ma.srmanager.srrapportactivity.Activity.controllers.queries;

import ma.srmanager.srrapportactivity.Activity.models.AffaireDTO;
import ma.srmanager.srrapportactivity.Activity.services.queries.AffaireQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/query/affaires")
@CrossOrigin("*")
public class AffaireQueryController {

    @Autowired
    private AffaireQueryService affaireQueryService;

    // Get an Affaire by ID
    @GetMapping("/getAffaireById/{id}")
    public AffaireDTO getAffaireById(@PathVariable Long id) {
        return affaireQueryService.getAffaireById(id);
    }

    // Get all Affaires
    @GetMapping("/getAllAffaires")
    public List<AffaireDTO> getAllAffaires() {
        return affaireQueryService.getAllAffaires();
    }



    // Get all Affaires by name
    @GetMapping("/getNomsAffaires")
    public List<String> getNomsAffaires() {
        List<AffaireDTO> affaires = affaireQueryService.getAllAffaires();
        return affaires.stream()
                .map(AffaireDTO::getNomAffaire)
                .collect(Collectors.toList());
    }

















}