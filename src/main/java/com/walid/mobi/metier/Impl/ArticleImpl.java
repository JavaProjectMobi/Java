package com.walid.mobi.metier.Impl;

import com.walid.mobi.dao.ArticleRepository;
import com.walid.mobi.entities.Article;
import com.walid.mobi.entities.Commande;
import com.walid.mobi.metier.IArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleImpl implements IArticle {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article consulterArticle(Long idArt) {
        Article article = articleRepository.findOne(idArt);
        if(article == null) throw new RuntimeException("Article introuvable");
        return article;
    }
    @Override
    public Article create(Article article){
        Article newArticle= article;
        return articleRepository.save(newArticle);
    }

    @Override
    public Article update(Article article){
        Article newArticle= article;
        return articleRepository.save(newArticle);
    }

    @Override
    public Article findById(Long idArt){
        return articleRepository.findOne(idArt);
    }
    @Override
    public List<Article> findAll(){
        return articleRepository.findAll();
    }
    @Override
    public Article delete(Long idArt) {
        Article deletedArticle = articleRepository.findOne(idArt);
        if (deletedArticle == null)
            throw new RuntimeException("Article not found");
        articleRepository.delete(deletedArticle);

        return deletedArticle;

    }

}