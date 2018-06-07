package com.walid.mobi.metier.Impl;

import com.walid.mobi.dao.ReglementRepository;
import com.walid.mobi.entities.Reglement;
import com.walid.mobi.metier.IReglement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReglementImpl implements IReglement {


    @Autowired
    private ReglementRepository reglementRepository;

    @Override
    public Reglement create(Reglement reglement){
        Reglement newReglement= reglement;
        return reglementRepository.save(newReglement);
    }

    @Override
    public Reglement update(Reglement reglement){
        Reglement newReglement= reglement;
        return reglementRepository.save(newReglement);
    }

    @Override
    public Reglement findById(Long id){
        return reglementRepository.findOne(id);
    }
    @Override
    public List<Reglement> findAll(){
        return reglementRepository.findAll();
    }
    @Override
    public Reglement delete(Long id) {
        Reglement deletedReglement = reglementRepository.findOne(id);
        if (deletedReglement == null)
            throw new RuntimeException("Reglement not found");
        reglementRepository.delete(deletedReglement);

        return deletedReglement;

    }
}
