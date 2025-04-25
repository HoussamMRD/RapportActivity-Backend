package ma.srmanager.srrapportactivity.Activity.controllers.commandes.Planifier;

import ma.srmanager.srrapportactivity.Activity.models.Planifier.TacheDTO;
import ma.srmanager.srrapportactivity.Activity.services.commandes.Planifier.TacheCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;







@RestController
@RequestMapping("/api/command/taches")
@CrossOrigin("*")
public class TacheCommandController {

    @Autowired
    private TacheCommandService tacheCommandService;



    // Create a new Tache
    @PostMapping("/createTache")
    public ResponseEntity<TacheDTO> createTache(@RequestBody TacheDTO tacheDTO) {
        try {
            TacheDTO createdTache = tacheCommandService.createTache(tacheDTO);
            return new ResponseEntity<>(createdTache, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    // Update an existing Tache
    @PutMapping("/updateTache/{id}")
    public TacheDTO updateTache(@PathVariable Long id, @RequestBody TacheDTO tacheDTO) {
        return tacheCommandService.updateTache(id, tacheDTO);
    }

    // Delete a Tache
    @DeleteMapping("/deleteTache/{id}")
    public void deleteTache(@PathVariable Long id) {
        tacheCommandService.deleteTache(id);
    }
}