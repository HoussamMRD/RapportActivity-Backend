package ma.srmanager.srrapportactivity.Activity.controllers.commandes.Ressources;
import lombok.RequiredArgsConstructor;
import ma.srmanager.srrapportactivity.Activity.models.Ressources.CoutEnginDTO;
import ma.srmanager.srrapportactivity.Activity.services.commandes.Ressources.CoutEnginCommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("/api/command/coutEngin")
@CrossOrigin(origins = "http://localhost:4200")


public class CoutEnginCommandController {

    @Autowired
    private CoutEnginCommandService coutEnginCommandService;



    // Create a new CoutEngin
    @PostMapping("/createCoutEngin")
    public CoutEnginDTO createCoutEngin(@RequestBody CoutEnginDTO coutEnginDTO) {
        return coutEnginCommandService.createCoutEngin(coutEnginDTO);
    }

    // Update an existing CoutEngin
    @PutMapping("/updateCoutEngin/{id}")
    public CoutEnginDTO updateCoutEngin(@PathVariable Long id, @RequestBody CoutEnginDTO coutEnginDTO) {
        return coutEnginCommandService.updateCoutEngin(id, coutEnginDTO);
    }

    // Delete a CoutEngin
    @DeleteMapping("/deleteCoutEngin/{id}")
    public void deleteCoutEngin(@PathVariable Long id) {
        coutEnginCommandService.deleteCoutEngin(id);
    }










}
