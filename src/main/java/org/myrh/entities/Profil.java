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
public class Profil implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idprofil;
	private String libelleProfil;
	private boolean etat;
	@OneToMany(mappedBy="profil")
	private Collection<Utilisateur> utilisateurs;
	public Profil() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profil(String libelleProfil) {
		super();
		this.libelleProfil = libelleProfil;
	}
	public Long getIdprofil() {
		return idprofil;
	}
	public void setIdprofil(Long idprofil) {
		this.idprofil = idprofil;
	}
	public String getLibelleProfil() {
		return libelleProfil;
	}
	public void setLibelleProfil(String libelleProfil) {
		this.libelleProfil = libelleProfil;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
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
