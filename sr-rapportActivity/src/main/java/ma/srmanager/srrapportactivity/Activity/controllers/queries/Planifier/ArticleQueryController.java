package ma.srmanager.srrapportactivity.Activity.controllers.queries.Planifier;

import ma.srmanager.srrapportactivity.Activity.models.Planifier.ArticleDTO;
import ma.srmanager.srrapportactivity.Activity.services.queries.Planifier.ArticleQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;






@RestController
@RequestMapping("/api/query/articles")
@CrossOrigin("*")
public class ArticleQueryController {

    @Autowired
    private ArticleQueryService articleQueryService;

    @GetMapping("/getArticleById/{id}")
    public ArticleDTO getArticleById(@PathVariable Long id) {
        return articleQueryService.getArticleById(id);
    }

    @GetMapping("/getAllArticles")
    public List<ArticleDTO> getAllArticles() {
        return articleQueryService.getAllArticles();
    }
}