package ma.srmanager.srrapportactivity.Activity.controllers.queries.Ressources;


import ma.srmanager.srrapportactivity.Activity.models.Ressources.CoutEnginDTO;
import ma.srmanager.srrapportactivity.Activity.services.queries.Ressources.CoutEnginQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/query/coutEngin")
@CrossOrigin(origins = "http://localhost:4200")
public class CoutEnginQueryController {


    @Autowired
    private CoutEnginQueryService coutEnginQueryService;


    // Get CoutEngin by ID
    @GetMapping("/getCoutEnginById/{id}")
    public CoutEnginDTO getCoutEnginById(@PathVariable Long id) {
        return coutEnginQueryService.getCoutEnginById(id);
    }



    // Get all CoutEngins
    @GetMapping("/getAllCoutEngins")
    public List<CoutEnginDTO> getAllCoutEngins() {
        return coutEnginQueryService.getAllCoutEngins();
    }



}

