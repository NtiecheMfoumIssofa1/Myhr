package org.myrh.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public  class Utilisateur implements Serializable{
	
	@Id
	private String login;
	private boolean statut;
	private boolean etat;
	@ManyToMany
	@JoinTable(name="Utilisateur_roles",joinColumns=
	@JoinColumn(name="login"),inverseJoinColumns=
	@JoinColumn(name="role"))
	private Collection<Role> roles;
	@ManyToOne
	@JoinColumn(name="idprofil")
	private Profil profil;
	@OneToMany(mappedBy="utilisateur")
	private Collection<Entreprise>entreprises;
	@OneToMany(mappedBy="utilisateur")
	private Collection<Particulier> particuliers;
	@ManyToMany(mappedBy="utilisateurs")
	private Collection<Document>documents;
	@ManyToMany(mappedBy="utilisateur")
	private Collection<Facture>factures;
	@ManyToOne
	@JoinColumn(name="libelleAbonnement")
	private Abonnement abonnement;
	/*@OneToMany(mappedBy="utilisateur")
	private Collection<Reservation>reservations;*/
	public Utilisateur() {
		
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String login, String password, boolean statut) {
		super();
		this.login = login;
		this.statut = statut;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}
   @JsonIgnore
	public Collection<Role> getRoles() {
		return roles;
	}
   	@JsonSetter
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
   	
	public Profil getProfil() {
		return profil;
	}
   
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
   	@JsonIgnore
	public Collection<Entreprise> getEntreprises() {
		return entreprises;
	}
   	@JsonSetter
	public void setEntreprises(Collection<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}
   	@JsonIgnore
	public Collection<Particulier> getParticuliers() {
		return particuliers;
	}
   	@JsonSetter
	public void setParticuliers(Collection<Particulier> particuliers) {
		this.particuliers = particuliers;
	}
	@JsonIgnore
	public Collection<Document> getDocuments() {
		return documents;
	}
	@JsonSetter
	public void setDocuments(Collection<Document> documents) {
		this.documents = documents;
	}
	
	public Abonnement getAbonnement() {
		return abonnement;
	}
	
	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}
	@JsonIgnore
	public Collection<Facture> getFactures() {
		return factures;
	}
    @JsonSetter
	public void setFactures(Collection<Facture> factures) {
		this.factures = factures;
	}
/*	@JsonIgnore
	public Collection<Reservation> getReservations() {
		return reservations;
	}
	@JsonSetter
	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
	*/

}
