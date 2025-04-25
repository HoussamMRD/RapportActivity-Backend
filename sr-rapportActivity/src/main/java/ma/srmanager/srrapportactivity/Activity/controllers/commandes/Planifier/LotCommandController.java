package ma.srmanager.srrapportactivity.Activity.controllers.commandes.Planifier;

import ma.srmanager.srrapportactivity.Activity.models.Planifier.LotDTO;
import ma.srmanager.srrapportactivity.Activity.services.commandes.Planifier.LotCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;







@RestController
@RequestMapping("/api/command/lots")
@CrossOrigin("*")
public class LotCommandController {

    @Autowired
    private LotCommandService lotCommandService;

    @PostMapping("/createLot")
    public LotDTO createLot(@RequestBody LotDTO lotDTO) {
        return lotCommandService.createLot(lotDTO);
    }

    @PutMapping("/updateLot/{id}")
    public LotDTO updateLot(@PathVariable Long id, @RequestBody LotDTO lotDTO) {
        return lotCommandService.updateLot(id, lotDTO);
    }

    @DeleteMapping("/deleteLot/{id}")
    public void deleteLot(@PathVariable Long id) {
        lotCommandService.deleteLot(id);
    }
}
