package org.myrh.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CategorieArticle implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategorie;
	private String libelle;
	private boolean etat;
	@OneToMany(mappedBy="categorieArticle")
	private Collection<Article>articles;
	
	public CategorieArticle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CategorieArticle(String libelle, boolean etat) {
		super();
		this.libelle = libelle;
		this.etat = etat;
	}

	public Long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	@JsonIgnore
	public Collection<Article> getArticles() {
		return articles;
	}
	@JsonSetter
	public void setArticles(Collection<Article> articles) {
		this.articles = articles;
	}
	

}
