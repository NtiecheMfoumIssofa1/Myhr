package org.myrh.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Role implements Serializable {
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//private Long idRole;
	@Id
	private String role;
	private boolean etat;
	@ManyToMany(mappedBy="roles")
	private Collection<Utilisateur>utilisateurs;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String role) {
		super();
		this.role = role;
	}
	/*public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}*/
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
