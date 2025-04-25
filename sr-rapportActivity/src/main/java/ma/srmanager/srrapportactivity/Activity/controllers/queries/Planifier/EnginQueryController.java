package ma.srmanager.srrapportactivity.Activity.controllers.queries.Planifier;

import ma.srmanager.srrapportactivity.Activity.models.Planifier.EnginDTO;
import ma.srmanager.srrapportactivity.Activity.services.queries.Planifier.EnginQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@RequestMapping("/api/query/engins")
@CrossOrigin("*")
public class EnginQueryController {

    @Autowired
    private EnginQueryService enginQueryService;




    // Get Engin by ID
    @GetMapping("/getEnginById/{id}")
    public EnginDTO getEnginById(@PathVariable Long id) {
        return enginQueryService.getEnginById(id);
    }

    // Get all Engins
    @GetMapping("/getAllEngins")
    public List<EnginDTO> getAllEngins() {
        return enginQueryService.getAllEngins();
    }


}
