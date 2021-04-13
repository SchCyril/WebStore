package fr.webservice.microservice.controller;

import fr.webservice.microservice.dao.ArticleDao;
import fr.webservice.microservice.exceptions.UnfindableArticle;
import fr.webservice.microservice.model.Article;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ArticleController {

    private final ArticleDao articleDao;

    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping(path = "/articles")
    public List<Article> getAllArticles() {
        return articleDao.findAll();
    }

    @GetMapping(path = "/articles/{id}")
    public Article getArticle(@PathVariable int id) {
        Article article = articleDao.findById(id);

        if (article == null) throw new UnfindableArticle(String.format("The article with the id %s is not available", id));
        return article;
    }

    @PostMapping(value = "/articles")
    public void addArticle(@RequestBody Article article) {
        articleDao.save(article);
    }

    @DeleteMapping(value = "/articles/{id}")
    public void deleteArticle(@PathVariable int id) {
        articleDao.deleteById(id);
    }

    @PutMapping(value = "/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable(value = "id") int id,
                                                 @Valid @RequestBody Article articleDetails) {

        Article article = articleDao.findById(id);

        article.setIdArticle(articleDetails.getIdArticle());
        article.setDescription(articleDetails.getDescription());
        article.setBrand(articleDetails.getBrand());
        article.setPrice(articleDetails.getPrice());
        articleDao.save(article);

        final Article updatedArticle = articleDao.save(article);
        return ResponseEntity.ok(updatedArticle);
    }
}
