package org.myrh.metier;

import java.time.LocalDate;
import java.util.List;

import org.myrh.dao.AbonnementRepository;
import org.myrh.dao.FactureRepository;
import org.myrh.dao.UtilisateurRepository;
import org.myrh.entities.Abonnement;
import org.myrh.entities.Facture;
import org.myrh.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class FactureMetierImpl implements FactureMetier{
	@Autowired
   private FactureRepository factureRepository;
	@Autowired
	private AbonnementRepository abonnementRepository;
	@Autowired
	private UtilisateurRepository userRepository;
	@Override
	public Facture saveFacture(Facture f,String login,String abonnement) {
		if((abonnementRepository.trouveId(abonnement)==null ||(userRepository.trouveId(login)==null)))
				return null;
		else{
			Abonnement a=abonnementRepository.getOne(abonnement);
			f.setAbonnement(a);
			Utilisateur u=userRepository.getOne(login);
			f.setUtilisateur(u);
			f.setEtat(true);
			return factureRepository.save(f);
		}
		
	}

	@Override
	public Facture updateFacture(String id, Facture f,String login,String abonnement) {
		if((factureRepository.trouveid(id)==null)||(abonnementRepository.trouveId(abonnement)==null ||(userRepository.trouveId(login)==null)))
			
			return null;
		else{
			Abonnement a=abonnementRepository.getOne(abonnement);
			f.setAbonnement(a);
			Utilisateur u=userRepository.getOne(login);
			f.setUtilisateur(u);
			f.setIdF(id);
			f.setEtat(true);
			return factureRepository.save(f);
		}
	}

	@Override
	public boolean deleteFacture(String id) {
		if(factureRepository.trouveid(id)==null)
			return false;
		else{
			factureRepository.deleteFacture(id);
			return true;
		}
	}

	@Override
	public List<Facture> getAllFacture() {
		// TODO Auto-generated method stub
		return factureRepository.getAllFacture();
	}

	@Override
	public Page<Facture> getFactureParMc(String mc,int page,int size) {
		// TODO Auto-generated method stub
		return factureRepository.getFactureParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public Page<Facture> getFactureParDate(LocalDate date,int page,int size) {
		// TODO Auto-generated method stub
		return factureRepository.getFactureParDate(date, new PageRequest(page, size));
	}

	@Override
	public List<Facture> genererFactureParticulier(String abonnement, String login) {
		if(abonnementRepository.trouveId(abonnement)==null||(userRepository.trouveId(login)==null))
			return null;
		else
		return factureRepository.genererFactureParticulier(abonnement, login);
	}

@Override
	public List<Facture> genererFactureEntreprise(String abonnement, String login) {
		if(abonnementRepository.trouveId(abonnement)==null||(userRepository.trouveId(login)==null))
			return null;
		else
		return factureRepository.genererFactureEntreprise(abonnement, login);
	}

	@Override
	public boolean paiementFacture(String id) {    
		if(factureRepository.trouveid(id)==null)
			return false;
		else{
			factureRepository.paiementFacture(id);
			return true;
		}
	}

	@Override
	public Facture getFacture(String id) {
		if(factureRepository.trouveid(id)==null)
			return null;
		else{
			Facture f=	factureRepository.getOne(id);
			return f;
		}
		
	}

}
