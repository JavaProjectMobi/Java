package com.walid.mobi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
@Entity
@Table(name="carte")
public class Carte extends Article {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="dureeValidite")
	private Integer dureeValidite;
	
	@Column(name="Quantite")
	private Integer quantite;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private Type_Carte type;
	
	@Enumerated(EnumType.STRING)
	@Column(name="operateur")
	private Operateur operateur;
	
	
	public Integer getDureeValidite() {
		return dureeValidite;
	}
	public void setDureeValidite(Integer dureeValidite) {
		this.dureeValidite = dureeValidite;
	}
	public Type_Carte getType() {
		return type;
	}
	public void setType(Type_Carte type) {
		this.type = type;
	}
	public Operateur getOperateur() {
		return operateur;
	}
	public void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}
	
	
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	
	
	public Carte(double prix, Integer quantiteSeuil, Integer dureeValidite, Integer quantite, Type_Carte type,
			Operateur operateur) {
		super( quantiteSeuil,prix);
		this.dureeValidite = dureeValidite;
		this.quantite = quantite;
		this.type = type;
		this.operateur = operateur;
	}

	public Carte() {
	}

	@Override
	public String toString() {
		return "Carte [dureeValidite=" + dureeValidite + ", type=" + type + ", operateur="
				+ operateur + "]";
	}
	
	

}
