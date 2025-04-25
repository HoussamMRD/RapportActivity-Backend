package ma.srmanager.srrapportactivity.Activity.controllers.commandes.Suivi;

import ma.srmanager.srrapportactivity.Activity.models.Suivi.LotSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.services.commandes.Suivi.LotSuiviCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/command/lotsuivis")
@CrossOrigin("*")
public class LotSuiviCommandController {

    @Autowired
    private LotSuiviCommandService lotSuiviCommandService;

    @PostMapping("/createLotSuivi")
    public LotSuiviDTO createLotSuivi(@RequestBody LotSuiviDTO lotSuiviDTO) {
        return lotSuiviCommandService.createLotSuivi(lotSuiviDTO);
    }

    @PutMapping("/updateLotSuivi/{id}")
    public LotSuiviDTO updateLotSuivi(@PathVariable Long id, @RequestBody LotSuiviDTO lotSuiviDTO) {
        return lotSuiviCommandService.updateLotSuivi(id, lotSuiviDTO);
    }

    @DeleteMapping("/deleteLotSuivi/{id}")
    public void deleteLotSuivi(@PathVariable Long id) {
        lotSuiviCommandService.deleteLotSuivi(id);
    }
}