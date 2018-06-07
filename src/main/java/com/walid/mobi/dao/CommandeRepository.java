package com.walid.mobi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walid.mobi.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
