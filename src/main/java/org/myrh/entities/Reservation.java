package org.myrh.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reservation implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private String objet;
	private boolean etat;
	private boolean annule;
	private String ville;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String statut;
/*	@ManyToOne
	@JoinColumn(name="login")
	private Utilisateur utilisateur;*/
	@ManyToMany
	@JoinTable(name="Reservation_Produit",joinColumns=
	@JoinColumn(name="id"),inverseJoinColumns=
	@JoinColumn(name="idp"))
	private Collection<ServiceProduit> serviceProduits;
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reservation(String libelle, LocalDate dateDebut, LocalDate dateFin, boolean etat, boolean annule,
			String statut,String objet) {
		super();
		this.libelle = libelle;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etat = etat;
		this.annule = annule;
		this.statut = statut;
		this.objet=objet;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public boolean isAnnule() {
		return annule;
	}
	public void setAnnule(boolean annule) {
		this.annule = annule;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	/*public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}*/
	public Collection<ServiceProduit> getServiceProduits() {
		return serviceProduits;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setServiceProduits(Collection<ServiceProduit> serviceProduits) {
		this.serviceProduits = serviceProduits;
	}
	

}
