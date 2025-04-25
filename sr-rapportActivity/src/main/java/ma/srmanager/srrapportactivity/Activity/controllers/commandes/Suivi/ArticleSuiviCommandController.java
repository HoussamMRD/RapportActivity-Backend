package ma.srmanager.srrapportactivity.Activity.controllers.commandes.Suivi;

import ma.srmanager.srrapportactivity.Activity.models.Suivi.ArticleSuiviDTO;
import ma.srmanager.srrapportactivity.Activity.services.commandes.Suivi.ArticleSuiviCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/command/articlesuivis")
@CrossOrigin("*")
public class ArticleSuiviCommandController {

    @Autowired
    private ArticleSuiviCommandService articleSuiviCommandService;

    @PostMapping("/createArticleSuivi")
    public ArticleSuiviDTO createArticleSuivi(@RequestBody ArticleSuiviDTO articleSuiviDTO) {
        return articleSuiviCommandService.createArticleSuivi(articleSuiviDTO);
    }

    @PutMapping("/updateArticleSuivi/{id}")
    public ArticleSuiviDTO updateArticleSuivi(@PathVariable Long id, @RequestBody ArticleSuiviDTO articleSuiviDTO) {
        return articleSuiviCommandService.updateArticleSuivi(id, articleSuiviDTO);
    }

    @DeleteMapping("/deleteArticleSuivi/{id}")
    public void deleteArticleSuivi(@PathVariable Long id) {
        articleSuiviCommandService.deleteArticleSuivi(id);
    }
}