package com.walid.mobi.metier.Impl;

import com.walid.mobi.dao.TelphoneMobileRepository;
import com.walid.mobi.entities.TelphoneMobile;
import com.walid.mobi.metier.ITelephone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TelphoneMobileImpl implements ITelephone{

    @Autowired
    private TelphoneMobileRepository telphoneMobileRepository;

    @Override
    public TelphoneMobile create(TelphoneMobile telphoneMobile){
        TelphoneMobile newTelphoneMobile= telphoneMobile;
        return telphoneMobileRepository.save(newTelphoneMobile);
    }

    @Override
    public TelphoneMobile consulterTelphoneMobile(Long idArt) {
        TelphoneMobile telphoneMobile = telphoneMobileRepository.findOne(idArt);
        if(telphoneMobile == null) throw new RuntimeException("TelphoneMobile introuvable");
        return telphoneMobile;
    }

    @Override
    public TelphoneMobile update(TelphoneMobile telphoneMobile){
        TelphoneMobile newTelphoneMobile= telphoneMobile;
        return telphoneMobileRepository.save(newTelphoneMobile);
    }

    @Override

    public TelphoneMobile findById(Long idArt){
        return telphoneMobileRepository.findOne(idArt);
    }

    @Override

    public List<TelphoneMobile> findAll(){
        List<TelphoneMobile> telphoneMobiles= telphoneMobileRepository.findAll();
        return telphoneMobiles;
    }

    @Override

    public TelphoneMobile delete(Long idArt) {
        TelphoneMobile deletedTelphoneMobile = telphoneMobileRepository.findOne(idArt);
        if (deletedTelphoneMobile == null)
            throw new RuntimeException("TelphoneMobile not found");
        telphoneMobileRepository.delete(deletedTelphoneMobile);

        return deletedTelphoneMobile;

    }
}
