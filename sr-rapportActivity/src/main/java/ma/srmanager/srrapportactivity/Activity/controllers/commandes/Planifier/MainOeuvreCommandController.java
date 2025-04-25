package ma.srmanager.srrapportactivity.Activity.controllers.commandes.Planifier;

import ma.srmanager.srrapportactivity.Activity.models.Planifier.MainOeuvreDTO;
import ma.srmanager.srrapportactivity.Activity.services.commandes.Planifier.MainOeuvreCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;









@RestController
@RequestMapping("/api/command/mainOeuvres")
@CrossOrigin("*")
public class MainOeuvreCommandController {

    @Autowired
    private MainOeuvreCommandService mainOeuvreCommandService;


    // Command Endpoints (Create, Update, Delete)
    @PostMapping("/createMainOeuvre")
    public ResponseEntity<MainOeuvreDTO> createMainOeuvre(@RequestBody MainOeuvreDTO mainOeuvreDTO) {
        return ResponseEntity.ok(mainOeuvreCommandService.createMainOeuvre(mainOeuvreDTO));
    }

    @PutMapping("/updateMainOeuvre/{id}")
    public ResponseEntity<MainOeuvreDTO> updateMainOeuvre(@PathVariable Long id, @RequestBody MainOeuvreDTO mainOeuvreDTO) {
        return ResponseEntity.ok(mainOeuvreCommandService.updateMainOeuvre(id, mainOeuvreDTO));
    }

    @DeleteMapping("/deleteMainOeuvre/{id}")
    public ResponseEntity<Void> deleteMainOeuvre(@PathVariable Long id) {
        mainOeuvreCommandService.deleteMainOeuvre(id);
        return ResponseEntity.noContent().build();
    }


}
