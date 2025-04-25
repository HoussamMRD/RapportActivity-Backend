package ma.srmanager.srrapportactivity.Activity.controllers.commandes;

import ma.srmanager.srrapportactivity.Activity.models.AffaireDTO;
import ma.srmanager.srrapportactivity.Activity.services.commandes.AffaireCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;






@RestController
@RequestMapping("/api/command/affaires")
@CrossOrigin("*")
public class AffaireCommandController {

    @Autowired
    private AffaireCommandService affaireCommandService;

    // Create a new Affaire
    @PostMapping("/createAffaire")
    public AffaireDTO createAffaire(@RequestBody AffaireDTO affaireDTO) {
        return affaireCommandService.createAffaire(affaireDTO);
    }

    // Update an existing Affaire
    @PutMapping("/updateAffaire/{id}")
    public AffaireDTO updateAffaire(@PathVariable Long id, @RequestBody AffaireDTO affaireDTO) {
        return affaireCommandService.updateAffaire(id, affaireDTO);
    }

    // Delete an Affaire
    @DeleteMapping("/deleteAffaire/{id}")
    public void deleteAffaire(@PathVariable Long id) {
        affaireCommandService.deleteAffaire(id);
    }
}