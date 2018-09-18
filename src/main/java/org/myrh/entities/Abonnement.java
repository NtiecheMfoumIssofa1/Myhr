package org.myrh.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Abonnement implements Serializable {
	@Id
	private String libelleAbonnement;
	private LocalDate dateAbonnement;
	private LocalDate dateResiliation;
	public Double coutAbonnement;
	private boolean etat;
	private boolean suspendre;
	private boolean desactiver;
	@OneToMany(mappedBy="abonnement")
	private Collection<Utilisateur> utilisateurs;
	@OneToMany(mappedBy="idF")
	private Collection<Facture> factures;
	public Abonnement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Abonnement(String libelleAbonnement, LocalDate dateAbonnement, LocalDate dateResiliation,
			Double coutAbonnement, boolean etat) {
		super();
		this.libelleAbonnement = libelleAbonnement;
		this.dateAbonnement = dateAbonnement;
		this.dateResiliation = dateResiliation;
		this.coutAbonnement = coutAbonnement;
		this.etat = etat;
	}

	public String getLibelleAbonnement() {
		return libelleAbonnement;
	}
	public void setLibelleAbonnement(String libelleAbonnement) {
		this.libelleAbonnement = libelleAbonnement;
	}
	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public boolean isSuspendre() {
		return suspendre;
	}

	public void setSuspendre(boolean suspendre) {
		this.suspendre = suspendre;
	}

	public boolean isDesactiver() {
		return desactiver;
	}

	public void setDesactiver(boolean desactiver) {
		this.desactiver = desactiver;
	}

	public LocalDate getDateAbonnement() {
		return dateAbonnement;
	}
	public void setDateAbonnement(LocalDate dateAbonnement) {
		this.dateAbonnement = dateAbonnement;
	}
	public LocalDate getDateResiliation() {
		return dateResiliation;
	}
	public void setDateResiliation(LocalDate dateResiliation) {
		this.dateResiliation = dateResiliation;
	}
	public Double getCoutAbonnement() {
		return coutAbonnement;
	}
	public void setCoutAbonnement(Double coutAbonnement) {
		this.coutAbonnement = coutAbonnement;
	}
	@JsonIgnore
	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	@JsonSetter
	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	@JsonIgnore
	public Collection<Facture> getFactures() {
		return factures;
	}
	@JsonSetter
	public void setFactures(Collection<Facture> factures) {
		this.factures = factures;
	}
	

}
