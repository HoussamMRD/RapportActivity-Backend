package ma.srmanager.srrapportactivity.Activity.controllers.commandes.Suivi;

import ma.srmanager.srrapportactivity.Activity.models.Suivi.MainOeuvreSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.services.commandes.Suivi.MainOeuvreSuiviCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/command/mainoeuvresuivis")
@CrossOrigin("*")
public class MainOeuvreSuiviCommandController {

    @Autowired
    private MainOeuvreSuiviCommandService mainOeuvreSuiviCommandService;

    @PostMapping("/createMainOeuvreSuivi")
    public MainOeuvreSuiviDTO createMainOeuvreSuivi(@RequestBody MainOeuvreSuiviDTO mainOeuvreSuiviDTO) {
        return mainOeuvreSuiviCommandService.createMainOeuvreSuivi(mainOeuvreSuiviDTO);
    }

    @PutMapping("/updateMainOeuvreSuivi/{id}")
    public MainOeuvreSuiviDTO updateMainOeuvreSuivi(@PathVariable Long id, @RequestBody MainOeuvreSuiviDTO mainOeuvreSuiviDTO) {
        return mainOeuvreSuiviCommandService.updateMainOeuvreSuivi(id, mainOeuvreSuiviDTO);
    }

    @DeleteMapping("/deleteMainOeuvreSuivi/{id}")
    public void deleteMainOeuvreSuivi(@PathVariable Long id) {
        mainOeuvreSuiviCommandService.deleteMainOeuvreSuivi(id);
    }
}