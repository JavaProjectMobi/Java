package com.walid.mobi.metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.walid.mobi.dao.CarteRepository;
import com.walid.mobi.entities.Carte;
import com.walid.mobi.metier.ICarte;

@Service
@Transactional
public class CarteImpl implements ICarte {

	
	@Autowired
	private CarteRepository carteRepository;
	@Override
    public Carte create(Carte article){
        Carte newArticle= article;
        return carteRepository.save(newArticle);
    }

    @Override
    public Carte update(Carte article){
        Carte newArticle= article;
        return carteRepository.save(newArticle);
    }

    @Override
    public Carte findById(Long idArt){
        return carteRepository.findOne(idArt);
    }
    @Override
    public List<Carte> findAll(){
        return carteRepository.findAll();
    }
    @Override
    public Carte delete(Long idArt) {
        Carte deletedArticle = carteRepository.findOne(idArt);
        if (deletedArticle == null)
            throw new RuntimeException("Article not found");
        carteRepository.delete(deletedArticle);

        return deletedArticle;

    }


	@Override
	public Carte consulterCarte(Long id) {
		Carte article = carteRepository.findOne(id);
        if(article == null) throw new RuntimeException("Article introuvable");
        return article;
	}
}
