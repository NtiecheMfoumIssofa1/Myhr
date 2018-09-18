package org.myrh.metier;

import java.time.LocalDate;
import java.util.List;

import org.myrh.entities.Facture;
import org.springframework.data.domain.Page;

public interface FactureMetier {
	public Facture saveFacture(Facture f,String login,String abonnement);
	public Facture updateFacture(String id, Facture f,String login,String abonnement);
	public boolean deleteFacture(String id);
	public List<Facture> getAllFacture();
	public Page<Facture> getFactureParDate(LocalDate date,int page,int size);
	public Page<Facture> getFactureParMc(String mc,int  page,int size);
	public List<Facture> genererFactureParticulier(String abonnement,String login);
	public List<Facture> genererFactureEntreprise(String abonnement,String login);
	public boolean paiementFacture(String id);
	public Facture getFacture(String id);
	

}
