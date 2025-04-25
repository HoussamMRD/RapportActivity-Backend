package ma.srmanager.srrapportactivity.Activity.controllers.queries.Suivi;

import ma.srmanager.srrapportactivity.Activity.models.Suivi.ArticleSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.services.queries.Suivi.ArticleSuiviQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/query/articlesuivis")
@CrossOrigin(origins = "http://localhost:4200")
public class ArticleSuiviQueryController {

    @Autowired
    private ArticleSuiviQueryService articleSuiviQueryService;

    @GetMapping("/getArticleSuiviById/{id}")
    public ArticleSuiviDTO getArticleSuiviById(@PathVariable Long id) {
        return articleSuiviQueryService.getArticleSuiviById(id);
    }

    @GetMapping("/getAllArticleSuivis")
    public List<ArticleSuiviDTO> getAllArticleSuivis() {
        return articleSuiviQueryService.getAllArticleSuivis();
    }
}