package com.walid.mobi.metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.walid.mobi.dao.CleRepository;
import com.walid.mobi.entities.Cle;
import com.walid.mobi.metier.ICle;

@Service
@Transactional
public class CleImpl implements ICle{
	
	@Autowired
	private CleRepository cleRepository;

	@Override
    public Cle create(Cle article){
        Cle newArticle= article;
        return cleRepository.save(newArticle);
    }

    @Override
    public Cle update(Cle article){
        Cle newArticle= article;
        return cleRepository.save(newArticle);
    }

    @Override
    public Cle findById(Long idArt){
        return cleRepository.findOne(idArt);
    }
    @Override
    public List<Cle> findAll(){
        return cleRepository.findAll();
    }
    @Override
    public Cle delete(Long idArt) {
        Cle deletedArticle = cleRepository.findOne(idArt);
        if (deletedArticle == null)
            throw new RuntimeException("Article not found");
        cleRepository.delete(deletedArticle);

        return deletedArticle;

    }


	@Override
	public Cle consulterCle(Long id) {
		Cle article = cleRepository.findOne(id);
        if(article == null) throw new RuntimeException("Article introuvable");
        return article;
	}

}
