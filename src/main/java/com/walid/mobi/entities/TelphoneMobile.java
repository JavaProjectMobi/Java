package com.walid.mobi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="mobile")
public class TelphoneMobile extends Article {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="model")
	private String model;
	
	@Column(name="reference")
	private String refrence;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRefrence() {
		return refrence;
	}
	public void setRefrence(String refrence) {
		this.refrence = refrence;
	}
	
	public TelphoneMobile(double prix, Integer quantiteSeuil, String model, String refrence) {
		super(quantiteSeuil,prix);
		this.model = model;
		this.refrence = refrence;
	}

	public TelphoneMobile() {
	}

	@Override
	public String toString() {
		return "TelphoneMobile [model=" + model + ", refrence=" + refrence + "]";
	}
	
}
