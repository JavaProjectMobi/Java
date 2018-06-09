package com.walid.mobi.metier;

import java.util.List;

import com.walid.mobi.entities.Cle;

public interface ICle {

	 public List<Cle > findAll();
	    public Cle  findById(Long idArt);
	    public Cle  create(Cle Cle);
	    public Cle update(Cle Cle);
	    public Cle delete(Long idArt);
	    public Cle consulterCle(Long cin);
}
