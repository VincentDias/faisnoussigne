package com.LSF.faisnoussigne.webservices.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/auth/articles")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ArticleController {

    @Autowired ArticleService service;

    @GetMapping()
    public List<Article> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Article getById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping()
    @PreAuthorize("hasRole('MODERATOR')")
    public Article createArticle(@RequestBody Article article){
        return service.saveArticle(article);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MODERATOR')")
    public Article updateArticle(@PathVariable Long id, @RequestBody Article article){
        return service.updateArticle(id, article);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArticle(@PathVariable Long id){
        service.deleteArticle(id);
    }

}
