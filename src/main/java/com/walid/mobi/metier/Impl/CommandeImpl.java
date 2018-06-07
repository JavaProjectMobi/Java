package com.walid.mobi.metier.Impl;

import com.walid.mobi.dao.CommandeRepository;
import com.walid.mobi.dao.CommandeRepository;
import com.walid.mobi.entities.Commande;
import com.walid.mobi.metier.ICommande;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommandeImpl implements ICommande{


    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public Commande create(Commande commande){
        Commande newCommande= commande;
        return commandeRepository.save(newCommande);
    }

    @Override
    public Commande update(Commande commande){
        Commande newCommande= commande;
        return commandeRepository.save(newCommande);
    }

    @Override
    public Commande findById(Long idCmd){
        return commandeRepository.findOne(idCmd);
    }
    @Override
    public List<Commande> findAll(){
        return commandeRepository.findAll();
    }
    @Override
    public Commande delete(Long idCmd) {
        Commande deletedCommande = commandeRepository.findOne(idCmd);
        if (deletedCommande == null)
            throw new RuntimeException("Commande not found");
        commandeRepository.delete(deletedCommande);

        return deletedCommande;

    }
}
