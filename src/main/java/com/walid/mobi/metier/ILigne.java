package com.walid.mobi.metier;

import java.util.List;

import com.walid.mobi.entities.Ligne_Telep;

public interface ILigne {
	 public List<Ligne_Telep > findAll();
	    public Ligne_Telep  findById(Long idArt);
	    public Ligne_Telep  create(Ligne_Telep article);
	    public Ligne_Telep update(Ligne_Telep article);
	    public Ligne_Telep delete(Long idArt);
	    public Ligne_Telep consulterLigne(Long cin);

}
