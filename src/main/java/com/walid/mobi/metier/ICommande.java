package com.walid.mobi.metier;

import com.walid.mobi.entities.Commande;

import java.util.List;

public interface ICommande {
    public List<Commande> findAll();
    public Commande findById(Long idCmd);
    public Commande create(Commande commande);
    public Commande update(Commande commande);
    public Commande delete(Long idCmd);
}
