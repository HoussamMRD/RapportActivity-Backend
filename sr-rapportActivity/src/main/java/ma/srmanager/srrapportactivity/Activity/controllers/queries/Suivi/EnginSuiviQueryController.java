package ma.srmanager.srrapportactivity.Activity.controllers.queries.Suivi;

import ma.srmanager.srrapportactivity.Activity.models.Suivi.EnginSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.services.queries.Suivi.EnginSuiviQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/query/enginsuivis")
@CrossOrigin(origins = "http://localhost:4200")
public class EnginSuiviQueryController {

    @Autowired
    private EnginSuiviQueryService enginSuiviQueryService;

    // Récupérer un EnginSuivi par son ID
    @GetMapping("/getEnginSuiviById/{id}")
    public EnginSuiviDTO getEnginSuiviById(@PathVariable Long id) {
        return enginSuiviQueryService.getEnginSuiviById(id);
    }

    // Récupérer tous les EnginSuivis
    @GetMapping("/getAllEnginSuivis")
    public List<EnginSuiviDTO> getAllEnginSuivis() {
        return enginSuiviQueryService.getAllEnginSuivis();
    }


}