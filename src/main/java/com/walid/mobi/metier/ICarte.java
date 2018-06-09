package com.walid.mobi.metier;

import java.util.List;

import com.walid.mobi.entities.Carte;

public interface ICarte {
	 public List<Carte > findAll();
	    public Carte findById(Long idArt);
	    public Carte  create(Carte Carte);
	    public Carte update(Carte Carte);
	    public Carte delete(Long idArt);
	    public Carte consulterCarte(Long cin);

}
