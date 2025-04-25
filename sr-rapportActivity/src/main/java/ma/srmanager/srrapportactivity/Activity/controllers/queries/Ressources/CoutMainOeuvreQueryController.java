package ma.srmanager.srrapportactivity.Activity.controllers.queries.Ressources;


import ma.srmanager.srrapportactivity.Activity.models.Ressources.CoutMainOeuvreDTO;
import ma.srmanager.srrapportactivity.Activity.services.queries.Ressources.CoutMainOeuvreQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;







@RestController
@RequestMapping("/api/query/coutMainOeuvre")
@CrossOrigin(origins = "http://localhost:4200")
public class CoutMainOeuvreQueryController {

    @Autowired
    private CoutMainOeuvreQueryService coutMainOeuvreQueryService;

    // Get CoutMainOeuvre by ID
    @GetMapping("/getCoutMainOeuvreById/{id}")
    public CoutMainOeuvreDTO getCoutMainOeuvreById(@PathVariable Long id) {
        return coutMainOeuvreQueryService.getCoutMainOeuvreById(id);
    }

    // Get all CoutMainOeuvre
    @GetMapping("/getAllCoutMainOeuvres")
    public List<CoutMainOeuvreDTO> getAllCoutMainOeuvres() {
        return coutMainOeuvreQueryService.getAllCoutMainOeuvres();
    }
}