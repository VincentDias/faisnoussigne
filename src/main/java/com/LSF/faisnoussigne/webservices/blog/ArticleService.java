package com.LSF.faisnoussigne.webservices.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired ArticleRepository repository;

    public List<Article> findAll(){
        return repository.findAll();
    }

    public Article findById(Long id){
        return repository.findById(id).get();
    }

    public Article saveArticle(Article article){
        return repository.save(article);
    }

    public Article updateArticle(Long id, Article article){
        Article articleToUpdate = repository.findById(id).get();
        articleToUpdate.setTitle(article.getTitle());
        articleToUpdate.setContent(article.getContent());
        articleToUpdate.setImg(article.getImg());
        articleToUpdate.setPublishAt(article.getPublishAt());
        return repository.save(articleToUpdate);
    }

    public void deleteArticle(Long id){
        repository.deleteById(id);
    }


}
