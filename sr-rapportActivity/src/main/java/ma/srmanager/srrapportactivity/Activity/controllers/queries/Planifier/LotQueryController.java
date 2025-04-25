package ma.srmanager.srrapportactivity.Activity.controllers.queries.Planifier;

import ma.srmanager.srrapportactivity.Activity.models.Planifier.LotDTO;
import ma.srmanager.srrapportactivity.Activity.services.queries.Planifier.LotQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;





@RestController
@RequestMapping("/api/query/lots")
@CrossOrigin("*")
public class LotQueryController {

    @Autowired
    private LotQueryService lotQueryService;

    @GetMapping("/getLotById/{id}")
    public LotDTO getLotById(@PathVariable Long id) {
        return lotQueryService.getLotById(id);
    }

    @GetMapping("/getAllLots")
    public List<LotDTO> getAllLots() {
        return lotQueryService.getAllLots();
    }
}
