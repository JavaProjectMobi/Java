package com.walid.mobi.metier;

import com.walid.mobi.entities.Article;
import com.walid.mobi.entities.Commande;

import java.util.List;

public interface IArticle {
    public List<Article > findAll();
    public Article  findById(Long idArt);
    public Article  create(Article article);
    public Article update(Article article);
    public Article delete(Long idArt);
    public Article consulterArticle(Long cin);


}
