package com.walid.mobi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
@Entity
@Table(name="cle")
public class Cle extends Article {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="numeroSerie")
	private String numeroSerie;
	
	@Column(name="debit")
	private String debitConnexion;
	
	@Column(name="capaciteMaxTelechargement")
	private String capaciteMaxTelechargement;
	
	@Enumerated(EnumType.STRING)
	@Column(name="operateur")
	private Operateur operateur;
	
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public String getDebitConnexion() {
		return debitConnexion;
	}
	public void setDebitConnexion(String debitConnexion) {
		this.debitConnexion = debitConnexion;
	}
	public String getCapaciteMaxTelechargement() {
		return capaciteMaxTelechargement;
	}
	public void setCapaciteMaxTelechargement(String capaciteMaxTelechargement) {
		this.capaciteMaxTelechargement = capaciteMaxTelechargement;
	}

	public Operateur getOperateur() {
		return operateur;
	}
	public void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}
	
	
	public Cle(double prix, Integer quantiteSeuil, String numeroSerie, String debitConnexion,
			String capaciteMaxTelechargement, Operateur operateur) {
		super( quantiteSeuil,prix);
		this.numeroSerie = numeroSerie;
		this.debitConnexion = debitConnexion;
		this.capaciteMaxTelechargement = capaciteMaxTelechargement;
		this.operateur = operateur;
	}

	public Cle() {
	}

	@Override
	public String toString() {
		return "Cle [numeroSerie=" + numeroSerie + ", debitConnexion=" + debitConnexion + ", capaciteMaxTelechargement="
				+ capaciteMaxTelechargement + ", operateur=" + operateur + "]";
	}
	
	

}
