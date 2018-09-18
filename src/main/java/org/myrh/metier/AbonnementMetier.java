package org.myrh.metier;

import java.util.List;

import org.myrh.entities.Abonnement;
import org.myrh.entities.Utilisateur;
import org.springframework.data.domain.Page;

public interface AbonnementMetier {
	public Abonnement saveA(Abonnement a);
	public Abonnement updateA(String id, Abonnement a);
	public boolean deleteA(String abonnement);
	public List<Abonnement> getAllAbonnement();
	public Page<Abonnement> getAllParMc(String mc, int page, int size);
	public List<Abonnement> getAllAbonnementParCout();
	public boolean desactiverA(String abonnement);
	public int upgradeEtdowngradeAParticulier(String abonnement);
	public int upgradeEtdowngradeAEntreprise(String abonnement);
	public boolean resilierAParticulier(Long id);
	public boolean resilierAEntrprise(Long id);
	public List<Object> getUserParAbonnement(String abonnement);
	public int activerA(String abonnement);
	public int suspendre(String abonnement);
	public int reactiverA(String abonnement);
	public boolean trouve(String abonnement);
	public boolean addAbonnementToUser(String login,String abonnement);
}
