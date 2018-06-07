package com.walid.mobi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walid.mobi.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

}
