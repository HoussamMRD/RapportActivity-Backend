package ma.srmanager.srrapportactivity.Activity.controllers.commandes.Planifier;

import ma.srmanager.srrapportactivity.Activity.models.Planifier.ArticleDTO;
import ma.srmanager.srrapportactivity.Activity.services.commandes.Planifier.ArticleCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/command/articles")
@CrossOrigin("*")
public class ArticleCommandController {

    private final ArticleCommandService articleCommandService;

    public ArticleCommandController(ArticleCommandService articleCommandService) {
        this.articleCommandService = articleCommandService;
    }

    @PostMapping("/createArticle")
    public ResponseEntity<ArticleDTO> createArticle(@Valid @RequestBody ArticleDTO articleDTO) {
        ArticleDTO createdArticle = articleCommandService.createArticle(articleDTO);
        return ResponseEntity.ok(createdArticle);
    }

    @PutMapping("/updateArticle/{id}")
    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable Long id, @Valid @RequestBody ArticleDTO articleDTO) {
        ArticleDTO updatedArticle = articleCommandService.updateArticle(id, articleDTO);
        return ResponseEntity.ok(updatedArticle);
    }

    @DeleteMapping("/deleteArticle/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleCommandService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}
