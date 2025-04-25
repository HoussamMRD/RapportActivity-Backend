package ma.srmanager.srrapportactivity.Activity.controllers.commandes.Suivi;

import ma.srmanager.srrapportactivity.Activity.models.Suivi.EnginSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.services.commandes.Suivi.EnginSuiviCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/command/enginsuivis")
@CrossOrigin("*")
public class EnginSuiviCommandController {

    @Autowired
    private EnginSuiviCommandService enginSuiviCommandService;

    @PostMapping("/createEnginSuivi")
    public EnginSuiviDTO createEnginSuivi(@RequestBody EnginSuiviDTO enginSuiviDTO) {
        return enginSuiviCommandService.createEnginSuivi(enginSuiviDTO);
    }

    @PutMapping("/updateEnginSuivi/{id}")
    public EnginSuiviDTO updateEnginSuivi(@PathVariable Long id, @RequestBody EnginSuiviDTO enginSuiviDTO) {
        return enginSuiviCommandService.updateEnginSuivi(id, enginSuiviDTO);
    }

    @DeleteMapping("/deleteEnginSuivi/{id}")
    public void deleteEnginSuivi(@PathVariable Long id) {
        enginSuiviCommandService.deleteEnginSuivi(id);
    }
}