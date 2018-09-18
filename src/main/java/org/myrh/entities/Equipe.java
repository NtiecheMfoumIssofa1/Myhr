package org.myrh.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Equipe  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nomEquipe;
	private String prenomEquipe;
	private String titreEquipe;
	private String urlLinkeldn;
	private String urlFacebook;
	private String photo;
	private String bibliographie;
	private boolean etat;
	
	
	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Equipe(String nomEquipe, String prenomEquipe, String titreEquipe, String urlLinkeldn, String urlFacebook,
			String photo, String bibliographie) {
		super();
		this.nomEquipe = nomEquipe;
		this.prenomEquipe = prenomEquipe;
		this.titreEquipe = titreEquipe;
		this.urlLinkeldn = urlLinkeldn;
		this.urlFacebook = urlFacebook;
		this.photo = photo;
		this.bibliographie = bibliographie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomEquipe() {
		return nomEquipe;
	}

	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}

	public String getPrenomEquipe() {
		return prenomEquipe;
	}

	public void setPrenomEquipe(String prenomEquipe) {
		this.prenomEquipe = prenomEquipe;
	}

	public String getTitreEquipe() {
		return titreEquipe;
	}

	public void setTitreEquipe(String titreEquipe) {
		this.titreEquipe = titreEquipe;
	}

	public String getUrlLinkeldn() {
		return urlLinkeldn;
	}

	public void setUrlLinkeldn(String urlLinkeldn) {
		this.urlLinkeldn = urlLinkeldn;
	}

	public String getUrlFacebook() {
		return urlFacebook;
	}

	public void setUrlFacebook(String urlFacebook) {
		this.urlFacebook = urlFacebook;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getBibliographie() {
		return bibliographie;
	}

	public void setBibliographie(String bibliographie) {
		this.bibliographie = bibliographie;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}


	
	

}
