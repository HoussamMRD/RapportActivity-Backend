package ma.srmanager.srrapportactivity.Activity.controllers.commandes.Ressources;



import lombok.RequiredArgsConstructor;

import ma.srmanager.srrapportactivity.Activity.models.Ressources.CoutMainOeuvreDTO;
import ma.srmanager.srrapportactivity.Activity.services.commandes.Ressources.CoutMainOeuvreCommandService;
import org.springframework.web.bind.annotation.*;













@RestController
@RequestMapping("/api/command/coutMainOeuvre")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class CoutMainOeuvreCommandController {
    private final CoutMainOeuvreCommandService service;

    @PostMapping("/createcoutMainOeuvre")
    public CoutMainOeuvreDTO createcoutMainOeuvre(@RequestBody CoutMainOeuvreDTO dto) {
        return service.createCoutMainOeuvre(dto);
    }

    @PutMapping("/updatecoutMainOeuvre/{id}")
    public CoutMainOeuvreDTO updatecoutMainOeuvre(@PathVariable Long id, @RequestBody CoutMainOeuvreDTO dto) {
        return service.updateCoutMainOeuvre(id, dto);
    }

    @DeleteMapping("/deletecoutMainOeuvre/{id}")
    public void deletecoutMainOeuvre(@PathVariable Long id) {
        service.deleteCoutMainOeuvre(id);
    }

}