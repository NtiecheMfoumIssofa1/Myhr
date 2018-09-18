package org.myrh.metier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.myrh.dao.EntrepriseRepository;
import org.myrh.dao.UtilisateurRepository;
import org.myrh.entities.Entreprise;
import org.myrh.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class EntrepriseMetierImpl implements EntrepriseMetier{
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private UtilisateurRepository userRepository;
	@Override
	public Entreprise saveEntreprise(Entreprise e,String login) {
		if(userRepository.UserActif(login)==null)
			return null;
		else{
					Utilisateur u=userRepository.getOne(login);
					e.setUtilisateur(u);
					//insertion automatique de la date
					Date date= new Date();
					//convertion en localDateTime
					  LocalDateTime localDateTime=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
						//convertion en localDate
					  LocalDate localDate=localDateTime.toLocalDate();
					  e.setDateInscription(localDate);
					e.setEtat(true);
					return entrepriseRepository.save(e);
		}
		
	}

	@Override
	public Entreprise updateEntreprise(Long id, Entreprise e,String login) {
		if((trouve(id)==false)||(userRepository.UserActif(login)==null))
			return null;
		else if(e.getPassword()!=(e.getConfirmPassword())) {
			return e;
		}else{
			Utilisateur u=userRepository.getOne(login);
			e.setUtilisateur(u);
			e.setId(id);
			e.setEtat(true);
			return entrepriseRepository.save(e);
		}
	}

	@Override
	public boolean deleteEntreprise(Long id) {
		if(trouve(id)==false)
			return false;
		else {
			entrepriseRepository.deleteEntreprise(id);
			return true;
		}
	}

	@Override
	public List<Entreprise> getAllEntreprise() {
		// TODO Auto-generated method stub
		return entrepriseRepository.findAllEntreprise();
	}

	@Override
	public Page<Entreprise> getAllEntrepriseParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return entrepriseRepository.getEntrepriseParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public List<Entreprise> getAllActif() {
		// TODO Auto-generated method stub
		return entrepriseRepository.getEntrepriseActif();
	}

	@Override
	public boolean trouve(Long id) {
		if(entrepriseRepository.trouveId(id)==null)
		return false;
		else return true;
	}

	@Override
	public int addEntrepriseToUser(String login, Long id) {
		if((trouve(id)==false)||(userRepository.trouveId(login)==null))
			return 0;
		else{
			entrepriseRepository.addEntrepriseToUser(login, id);
			return 1;
		}
	}

	@Override
	public Page<Entreprise> getAllParRole(String role,int page,int size) {
		// TODO Auto-generated method stub
		return entrepriseRepository.getEntrepriseParRole(role,new PageRequest(page, size));
	}

	@Override
	public boolean activeEntreprise(Long id) {
		if(trouve(id)==false)
			 return false;
		else{
			entrepriseRepository.activeEntreprise(id);
			return true;
		}
		
		
	}

	@Override
	public Page<Entreprise> getEntrepriseParDate(LocalDate date,int page,int size) {
		// TODO Auto-generated method stub
		return entrepriseRepository.getEntreprisePardate(date,new PageRequest(page, size));
	}

	@Override
	public boolean desactiveEntreprise(Long id) {
		if(trouve(id)==false)
			return false;
		else{
			entrepriseRepository.desactiveEntreprise(id);
			return true;
		}
		
		
	}

	@Override
	public Entreprise getEntreprise(Long id) {
		// TODO Auto-generated method stub
		return entrepriseRepository.getOne(id);
	}

}
