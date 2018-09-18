package org.myrh.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Document implements Serializable{
	@Id
	private String intitule;
    private String lienTelechargement;
    private boolean archiver;
    private boolean etat;
    private LocalDate dateTelechargement;
    private boolean uploder;
    @ManyToMany
    @JoinTable(name="User_Doc",joinColumns=
    @JoinColumn(name="intitule"), inverseJoinColumns=
    @JoinColumn(name="login"))
    private Collection<Utilisateur>utilisateurs;
	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Document(String intitule, String lienTelechargement, boolean archiver, boolean etat,
			LocalDate dateTelechargement, boolean uploder) {
		super();
		this.intitule = intitule;
		this.lienTelechargement = lienTelechargement;
		this.archiver = archiver;
		this.etat = etat;
		this.dateTelechargement = dateTelechargement;
		this.uploder = uploder;
	}

	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getLienTelechargement() {
		return lienTelechargement;
	}
	public void setLienTelechargement(String lienTéléchargement) {
		this.lienTelechargement = lienTéléchargement;
	}
	public boolean isArchiver() {
		return archiver;
	}
	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public boolean isUploder() {
		return uploder;
	}

	public void setUploder(boolean uploder) {
		this.uploder = uploder;
	}

	public LocalDate getDateTelechargement() {
		return dateTelechargement;
	}
	public void setDateTelechargement(LocalDate dateTelechargement) {
		this.dateTelechargement = dateTelechargement;
	}
	@JsonIgnore
	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	@JsonSetter
	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
    
}
