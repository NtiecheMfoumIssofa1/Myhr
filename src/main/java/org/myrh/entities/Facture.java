package org.myrh.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Facture implements Serializable{
	@Id
	private String idF;
	private String designation;
	private LocalDate date;
	private boolean paiement;
	@ManyToOne
	@JoinColumn(name="libelleAbonnement")
	private Abonnement abonnement;
	@ManyToOne
	@JoinColumn(name="login")
	private Utilisateur utilisateur;
	private boolean etat;
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facture(String idF, String designation, LocalDate date) {
		super();
		this.idF = idF;
		this.designation = designation;
		this.date = date;
	}
	public String getIdF() {
		return idF;
	}
	public void setIdF(String idF) {
		this.idF = idF;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isPaiement() {
		return paiement;
	}
	public void setPaiement(boolean paiement) {
		this.paiement = paiement;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public Abonnement getAbonnement() {
		return abonnement;
	}

	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
    
}
