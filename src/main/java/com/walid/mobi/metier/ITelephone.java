package com.walid.mobi.metier;

import com.walid.mobi.entities.TelphoneMobile;

import java.util.List;

public interface ITelephone {
    public List<TelphoneMobile > findAll();
    public TelphoneMobile  findById(Long idArt);
    public TelphoneMobile  create(TelphoneMobile telphoneMobile);
    public TelphoneMobile update(TelphoneMobile telphoneMobile);
    public TelphoneMobile delete(Long idArt);
    public TelphoneMobile consulterTelphoneMobile(Long idArt);


}
