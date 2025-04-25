package ma.srmanager.srrapportactivity.Activity.controllers.queries.Suivi;

import ma.srmanager.srrapportactivity.Activity.models.Suivi.MainOeuvreSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.services.queries.Suivi.MainOeuvreSuiviQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/query/mainoeuvresuivis")
@CrossOrigin(origins = "http://localhost:4200")
public class MainOeuvreSuiviQueryController {

    @Autowired
    private MainOeuvreSuiviQueryService mainOeuvreSuiviQueryService;

    @GetMapping("/getMainOeuvreSuiviById/{id}")
    public MainOeuvreSuiviDTO getMainOeuvreSuiviById(@PathVariable Long id) {
        return mainOeuvreSuiviQueryService.getMainOeuvreSuiviById(id);
    }

    @GetMapping("/getAllMainOeuvreSuivis")
    public List<MainOeuvreSuiviDTO> getAllMainOeuvreSuivis() {
        return mainOeuvreSuiviQueryService.getAllMainOeuvreSuivis();
    }
}