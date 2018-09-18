package org.myrh.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
@Entity
public class ServiceCategorie implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String source;
	private boolean etat;
	@OneToMany(mappedBy="serviceCategorie")
	private Collection<ServiceProduit> serviceProduit;
	public ServiceCategorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceCategorie(String description, String source) {
		super();
		this.description = description;
		this.source = source;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}
@JsonIgnore
	public Collection<ServiceProduit> getServiceProduit() {
		return serviceProduit;
	}
@JsonSetter
	public void setServiceProduit(Collection<ServiceProduit> serviceProduit) {
		this.serviceProduit = serviceProduit;
	}
	
	

}
