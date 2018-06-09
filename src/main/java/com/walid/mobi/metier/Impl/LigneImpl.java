package com.walid.mobi.metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.walid.mobi.dao.LigneTelRepository;
import com.walid.mobi.entities.Ligne_Telep;
import com.walid.mobi.metier.ILigne;

@Service
@Transactional
public class LigneImpl implements ILigne{
	
	@Autowired
	private LigneTelRepository ligneRepository;

	@Override
    public Ligne_Telep create(Ligne_Telep article){
        Ligne_Telep newArticle= article;
        return ligneRepository.save(newArticle);
    }

    @Override
    public Ligne_Telep update(Ligne_Telep article){
        Ligne_Telep newArticle= article;
        return ligneRepository.save(newArticle);
    }

    @Override
    public Ligne_Telep findById(Long idArt){
        return ligneRepository.findOne(idArt);
    }
    @Override
    public List<Ligne_Telep> findAll(){
        return ligneRepository.findAll();
    }
    @Override
    public Ligne_Telep delete(Long idArt) {
        Ligne_Telep deletedArticle = ligneRepository.findOne(idArt);
        if (deletedArticle == null)
            throw new RuntimeException("Article not found");
        ligneRepository.delete(deletedArticle);

        return deletedArticle;

    }


	@Override
	public Ligne_Telep consulterLigne(Long id) {
		Ligne_Telep article = ligneRepository.findOne(id);
        if(article == null) throw new RuntimeException("Article introuvable");
        return article;
	}

}
