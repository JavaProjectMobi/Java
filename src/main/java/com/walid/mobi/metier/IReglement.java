package com.walid.mobi.metier;

import com.walid.mobi.entities.Reglement;

import java.util.List;

public interface IReglement {
    public List<Reglement> findAll();
    public Reglement findById(Long id);
    public Reglement create(Reglement reglement);
    public Reglement update(Reglement reglement);
    public Reglement delete(Long id);
}
