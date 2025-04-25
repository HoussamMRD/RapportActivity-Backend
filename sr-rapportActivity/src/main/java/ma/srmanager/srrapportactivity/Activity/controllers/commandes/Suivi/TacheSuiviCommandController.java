package ma.srmanager.srrapportactivity.Activity.controllers.commandes.Suivi;


import ma.srmanager.srrapportactivity.Activity.models.Suivi.TacheSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.services.commandes.Suivi.TacheSuiviCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;







import lombok.RequiredArgsConstructor;




@RestController
@RequestMapping("/api/command/tachesuivis")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TacheSuiviCommandController {

    @Autowired
    private TacheSuiviCommandService tacheSuiviCommandService;

    @PostMapping("/createTacheSuivi")
    public TacheSuiviDTO createTacheSuivi(@RequestBody TacheSuiviDTO tacheSuiviDTO) {
        return tacheSuiviCommandService.createTacheSuivi(tacheSuiviDTO);
    }

    @PutMapping("/updateTacheSuivi/{id}")
    public TacheSuiviDTO updateTacheSuivi(@PathVariable Long id, @RequestBody TacheSuiviDTO tacheSuiviDTO) {
        return tacheSuiviCommandService.updateTacheSuivi(id, tacheSuiviDTO);
    }

    @DeleteMapping("/deleteTacheSuivi/{id}")
    public void deleteTacheSuivi(@PathVariable Long id) {
        tacheSuiviCommandService.deleteTacheSuivi(id);
    }
}