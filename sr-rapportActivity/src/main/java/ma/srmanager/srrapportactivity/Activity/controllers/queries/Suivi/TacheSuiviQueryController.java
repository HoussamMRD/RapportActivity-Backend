package ma.srmanager.srrapportactivity.Activity.controllers.queries.Suivi;

import ma.srmanager.srrapportactivity.Activity.services.queries.Suivi.TacheSuiviQueryService;
import ma.srmanager.srrapportactivity.Activity.models.Suivi.TacheSuiviDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/query/tachesuivis")
@CrossOrigin(origins = "http://localhost:4200")
public class TacheSuiviQueryController {

    @Autowired
    private TacheSuiviQueryService tacheSuiviQueryService;

    @GetMapping("/getTacheSuiviById/{id}")
    public TacheSuiviDTO getTacheSuiviById(@PathVariable Long id) {
        return tacheSuiviQueryService.getTacheSuiviById(id);
    }

    @GetMapping("/getAllTacheSuivis")
    public List<TacheSuiviDTO> getAllTacheSuivis() {
        return tacheSuiviQueryService.getAllTacheSuivis();
    }
}