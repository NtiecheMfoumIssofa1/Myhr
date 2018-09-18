package org.myrh.metier;

import java.util.List;

import org.myrh.dao.AbonnementRepository;
import org.myrh.dao.EntrepriseRepository;
import org.myrh.dao.ParticulierRepository;
import org.myrh.dao.UtilisateurRepository;
import org.myrh.entities.Abonnement;
import org.myrh.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class AbonnementMetierImpl implements AbonnementMetier{
	@Autowired
	private AbonnementRepository abonnementRepository;
	@Autowired
	private  ParticulierRepository particulierRepository;
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private UtilisateurRepository userRepository;
	@Override
	public Abonnement saveA(Abonnement a) {
		a.setEtat(true);
		return abonnementRepository.save(a);
	}

	@Override
	public Abonnement updateA(String id, Abonnement a) {
		if(trouve(id)==false)
			return null;
		else{
			a.setEtat(true);
			a.setDesactiver(true);
			return abonnementRepository.save(a);
		}
	}

	@Override
	public boolean deleteA(String a) {
		if(trouve(a)==false)
			return false;
		else 
			 {
			abonnementRepository.deleteAbonnement(a);
			return true;
			 }
	}

	@Override
	public List<Abonnement> getAllAbonnement() {
		// TODO Auto-generated method stub
		return abonnementRepository.getAllAbonnement();
	}

	@Override
	public Page<Abonnement> getAllParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return abonnementRepository.getAllParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public boolean desactiverA(String abonnement) {
		if(trouve(abonnement)==false)
			return false;
		else {
			abonnementRepository.desactiverA(abonnement);
		}
			return true;
	}

	@Override
	public int upgradeEtdowngradeAParticulier(String abonnement) {
		if(trouve(abonnement)==false)
			return 0;
		else{
			 abonnementRepository.upgradeEtdowngradeAParticulier(abonnement);
			 return 1;
		}
		
	}

	@Override
	public boolean resilierAParticulier(Long id) {
		if((particulierRepository.trouveId(id)==null))
			return false;
		else{
			abonnementRepository.resilierAParticulier(id);
			return true;
		}
		
	}



	@Override
	public List<Object> getUserParAbonnement(String abonnement) {
		// TODO Auto-generated method stub
		return abonnementRepository.getUserParAbonnement(abonnement);
	}

	@Override
	public int activerA(String abonnement) {
		if(trouve(abonnement)==false)
			return 0;
		else 
			abonnementRepository.activerA(abonnement);
		return 1;
	}

	@Override
	public int suspendre(String abonnement) {
		if(trouve(abonnement)==false)
			return 0;
		else
			abonnementRepository.suspendre(abonnement);
		return 1;
	}

	@Override
	public boolean trouve(String abonnement) {
		if(abonnementRepository.trouveId(abonnement)==null)
			return false;
		else return true;
	}

	@Override
	public List<Abonnement> getAllAbonnementParCout() {
		// TODO Auto-generated method stub
		return abonnementRepository.getAllAbonnementParCout();
	}

	@Override
	public int upgradeEtdowngradeAEntreprise(String abonnement) {
		if(trouve(abonnement)==false)
			return 0;
		else{
			abonnementRepository.upgradeEtdowngradeAEntreprise(abonnement);
			return 1;
		}
	}

	@Override
	public boolean resilierAEntrprise(Long id) {
		if((entrepriseRepository.trouveId(id)==null))
			return false;
		else 
		{
			abonnementRepository.resilierAEntreprise(id);
		}
			return true;
	}

	@Override
	public int reactiverA(String abonnement) {
		return abonnementRepository.reactiverA(abonnement);
	}

	@Override
	public boolean addAbonnementToUser(String login, String abonnement) {
		if((trouve(abonnement)==false)||(userRepository.trouveId(login)==null))
		return false;
		else{
			abonnementRepository.addAbonnementToUser(abonnement, login);
			return true;
			
		}
	}

	

}
