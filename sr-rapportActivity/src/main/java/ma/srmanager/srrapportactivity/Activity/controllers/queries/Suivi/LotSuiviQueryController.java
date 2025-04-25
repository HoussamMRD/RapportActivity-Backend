package ma.srmanager.srrapportactivity.Activity.controllers.queries.Suivi;

import ma.srmanager.srrapportactivity.Activity.models.Suivi.LotSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.services.queries.Suivi.LotSuiviQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/query/lotsuivis")
@CrossOrigin(origins = "http://localhost:4200")
public class LotSuiviQueryController {

    @Autowired
    private LotSuiviQueryService lotSuiviQueryService;

    @GetMapping("/getLotSuiviById/{id}")
    public LotSuiviDTO getLotSuiviById(@PathVariable Long id) {
        return lotSuiviQueryService.getLotSuiviById(id);
    }

    @GetMapping("/getAllLotSuivis")
    public List<LotSuiviDTO> getAllLotSuivis() {
        return lotSuiviQueryService.getAllLotSuivis();
    }
}