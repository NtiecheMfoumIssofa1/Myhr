package org.myrh.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class ServiceProduit  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idp;
	private String libelle;
	private String description;
	private Double prix;
	@ManyToOne
	@JoinColumn(name="id")
	private ServiceCategorie serviceCategorie;
	private boolean etat;
	@ManyToMany(mappedBy="serviceProduits")
	private Collection<Reservation> reservations;
	public ServiceProduit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceProduit(String libelle, String description, Double prix) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.prix = prix;
	}

	public Long getIdp() {
		return idp;
	}

	public void setIdp(Long idp) {
		this.idp = idp;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public ServiceCategorie getServiceCategorie() {
		return serviceCategorie;
	}

	public void setServiceCategorie(ServiceCategorie serviceCategorie) {
		this.serviceCategorie = serviceCategorie;
	}

	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}


	

}
