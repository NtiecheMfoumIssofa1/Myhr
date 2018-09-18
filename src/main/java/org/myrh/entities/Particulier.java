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
//@DiscriminatorValue("PARTICULIER")
public class Particulier implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String mail;
	private String firstName;
	private String lastName;
	private String entreprise;
	private String fonction;
	private String sexe;
	private String ville;
	private String telephone;
	private boolean etat;
	private boolean statut;
	private LocalDate dateInscription;
	private String password;
	private String confirmPassword;


	@ManyToOne
	@JoinColumn(name="login")
	private Utilisateur utilisateur;
	public Particulier() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Particulier(String mail, String firstName, String lastName, String entreprise, String fonction, String sexe,
			String telephone, String ville,boolean etat, boolean statut, LocalDate dateInscription) {
		super();
		this.mail = mail;
		this.firstName = firstName;
		this.lastName = lastName;
		this.entreprise = entreprise;
		this.fonction = fonction;
		this.sexe = sexe;
		this.telephone = telephone;
		this.etat = etat;
		this.statut = statut;
		this.ville=ville;
		this.dateInscription = dateInscription;
		
	}

	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
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

	public LocalDate getDateInscription() {
		return dateInscription;
	}



	public void setDateInscription(LocalDate dateInscription) {
		this.dateInscription = dateInscription;
	}



	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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



	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getSexe() {
		return sexe;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
   
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
   
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	

}
