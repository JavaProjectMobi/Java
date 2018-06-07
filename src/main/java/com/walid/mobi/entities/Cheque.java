package com.walid.mobi.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="cheque")
public class Cheque extends Reglement{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="numero_cheque")
	private String numeroCheque;
	
	@Column(name="dateEcheance")
	@Temporal(TemporalType.DATE)
	private Date dateEcheance;
	
	public Date getDateEcheance() {
		return dateEcheance;
	}
	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}
	public String getNumeroCheque() {
		return numeroCheque;
	}
	public void setNumeroCheque(String numeroCheque) {
		this.numeroCheque = numeroCheque;
	}
	
	public Cheque(Date date, Float montant, Date dateEcheance, String numeroCheque) {
		super(date, montant);
		this.dateEcheance = dateEcheance;
		this.numeroCheque = numeroCheque;
	}
	@Override
	public String toString() {
		return "Cheque [dateEcheance=" + dateEcheance + ", numeroCheque=" + numeroCheque + "]";
	}
	
}
