package org.myrh.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
//@DiscriminatorValue("ENTREPRISE")
public class Entreprise implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String formeJuridique;
	private String tailleEntreprise;
	private String nombreEmploye;
	private String secteurActivite;
	private String addresse;
	private String ville;
	private String siteWeb;
	private String telephone;   
	private String nomRepresentant;
	private String fonction;
	private boolean etat;
	private boolean statut;//permet de savoir s'il est connecté ou pas
	private LocalDate dateInscription;
	private String password;
	private String confirmPassword;
	@ManyToOne
	@JoinColumn(name="login")
	private Utilisateur utilisateur;
	public Entreprise() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Entreprise(String nom, String formeJuridique, String nombreEmploye, String secteurActivite, String addresse,
			String siteWeb, String telephone, String nomRepresentant, String fonction, boolean etat, boolean statut,
			LocalDate dateInscription,String tailleEntreprise) {
		super();
		this.nom = nom;
		this.formeJuridique = formeJuridique;
		this.nombreEmploye = nombreEmploye;
		this.secteurActivite = secteurActivite;
		this.addresse = addresse;
		this.siteWeb = siteWeb;
		this.telephone = telephone;
		this.nomRepresentant = nomRepresentant;
		this.fonction = fonction;
		this.etat = etat;
		this.statut = statut;
		this.dateInscription = dateInscription;
		this.tailleEntreprise=tailleEntreprise;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDateInscription() {
		return dateInscription;
	}



	public void setDateInscription(LocalDate dateInscription) {
		this.dateInscription = dateInscription;
	}



	public String getFormeJuridique() {
		return formeJuridique;
	}

	public void setFormeJuridique(String formeJuridique) {
		this.formeJuridique = formeJuridique;
	}

	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}



	public String getNombreEmploye() {
		return nombreEmploye;
	}

	public void setNombreEmploye(String nombreEmploye) {
		this.nombreEmploye = nombreEmploye;
	}

	public String getSecteurActivite() {
		return secteurActivite;
	}

	public void setSecteurActivite(String secteurActivite) {
		this.secteurActivite = secteurActivite;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getConfirmPassword() {
		return confirmPassword;
	}



	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getTailleEntreprise() {
		return tailleEntreprise;
	}



	public void setTailleEntreprise(String tailleEntreprise) {
		this.tailleEntreprise = tailleEntreprise;
	}



	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNomRepresentant() {
		return nomRepresentant;
	}

	public void setNomRepresentant(String nomRepresentant) {
		this.nomRepresentant = nomRepresentant;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
   
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
   
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
   
}
