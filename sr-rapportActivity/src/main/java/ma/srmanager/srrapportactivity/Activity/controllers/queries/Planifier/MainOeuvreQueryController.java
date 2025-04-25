package ma.srmanager.srrapportactivity.Activity.controllers.queries.Planifier;

import ma.srmanager.srrapportactivity.Activity.models.Planifier.MainOeuvreDTO;
import ma.srmanager.srrapportactivity.Activity.services.queries.Planifier.MainOeuvreQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;






@RestController
@RequestMapping("/api/query/mainOeuvres")
@CrossOrigin("*")

public class MainOeuvreQueryController {


        @Autowired
        private MainOeuvreQueryService mainOeuvreQueryService;


        @GetMapping("/getMainOeuvreById/{id}")
        public ResponseEntity<MainOeuvreDTO> getMainOeuvreById(@PathVariable Long id) {
            return ResponseEntity.ok(mainOeuvreQueryService.getMainOeuvreById(id));
        }

        @GetMapping("/getAllMainOeuvres")
        public ResponseEntity<List<MainOeuvreDTO>> getAllMainOeuvres() {
            return ResponseEntity.ok(mainOeuvreQueryService.getAllMainOeuvres());
        }










}
