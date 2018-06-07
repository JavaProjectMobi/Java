package com.walid.mobi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="ligne_telep")
public class Ligne_Telep extends Article {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="numero")
	private long numeroTelephone;
	
	@Column(name="operateur")
	@Enumerated(EnumType.STRING)
	private Operateur operateur ;
	
	public long getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(long numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public Operateur getOperateur() {
		return operateur;
	}

	public void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}

	

	public Ligne_Telep(double prix, Integer quantiteSeuil, long numeroTelephone, Operateur operateur) {
		super( quantiteSeuil,prix);
		this.numeroTelephone = numeroTelephone;
		this.operateur = operateur;
	}

	public Ligne_Telep() {
	}

	@Override
	public String toString() {
		return "Ligne_Telep [numeroTelephone=" + numeroTelephone + ", operateur=" + operateur + "]";
	}


}
