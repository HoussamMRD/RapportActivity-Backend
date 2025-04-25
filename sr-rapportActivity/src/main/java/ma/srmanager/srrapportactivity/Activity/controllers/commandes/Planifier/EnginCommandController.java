package ma.srmanager.srrapportactivity.Activity.controllers.commandes.Planifier;

import ma.srmanager.srrapportactivity.Activity.models.Planifier.EnginDTO;
import ma.srmanager.srrapportactivity.Activity.services.commandes.Planifier.EnginCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;






@RestController
@RequestMapping("/api/command/engins")
@CrossOrigin("*")
public class EnginCommandController {

    @Autowired
    private EnginCommandService enginCommandService;


    // Create a new Engin
    @PostMapping("/createEngin")
    public EnginDTO createEngin(@RequestBody EnginDTO enginDTO) {
        return enginCommandService.createEngin(enginDTO);
    }

    // Update an existing Engin
    @PutMapping("/updateEngin/{id}")
    public EnginDTO updateEngin(@PathVariable Long id, @RequestBody EnginDTO enginDTO) {
        return enginCommandService.updateEngin(id, enginDTO);
    }

    // Delete an Engin
    @DeleteMapping("/deleteEngin/{id}")
    public void deleteEngin(@PathVariable Long id) {
        enginCommandService.deleteEngin(id);
    }


}