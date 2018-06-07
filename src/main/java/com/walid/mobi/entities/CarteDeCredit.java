package com.walid.mobi.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="carteCredit")
public class CarteDeCredit extends Reglement{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="numeroCarte")
	private Long numeroCarte;

	public Long getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(Long numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	@Override
	public String toString() {
		return "CarteDeCredit [numeroCarte=" + numeroCarte + "]";
	}

	public CarteDeCredit(Date date, Float montant, Long numeroCarte) {
		super(date, montant);
		this.numeroCarte = numeroCarte;
	}

	
	
	
}
