package org.myrh.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Article implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String pdf;
	
	private String image;
	
	private String nomArticle; 
	private String contenu;
	private boolean etat;
	private LocalDate datePublication;
	private LocalDate dateSuppression;
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private CategorieArticle categorieArticle;
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(String pdf, String image,  String nomArticle, String contenu,
			boolean etat, LocalDate datePublication, LocalDate dateSuppression) {
		super();
		this.pdf = pdf;
		this.image = image;
		this.nomArticle = nomArticle;
		this.contenu = contenu;
		this.etat = etat;
		this.datePublication = datePublication;
		this.dateSuppression = dateSuppression;
	}





	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	public String getNomArticle() {
		return nomArticle;
	}


	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}


	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public LocalDate getDatePublication() {
		return datePublication;
	}



	public void setDatePublication(LocalDate datePublication) {
		this.datePublication = datePublication;
	}



	public LocalDate getDateSuppression() {
		return dateSuppression;
	}



	public void setDateSuppression(LocalDate dateSuppression) {
		this.dateSuppression = dateSuppression;
	}



	
	public CategorieArticle getCategorieArticle() {
		return categorieArticle;
	}
	public void setCategorieArticle(CategorieArticle categorieArticle) {
		this.categorieArticle = categorieArticle;
	}






 
}
