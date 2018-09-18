package org.myrh.metier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.myrh.dao.ParticulierRepository;
import org.myrh.dao.UtilisateurRepository;
import org.myrh.entities.Particulier;
import org.myrh.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class ParticulierMetierImpl implements ParticulierMetier{
@Autowired
private ParticulierRepository particulierRepository;
@Autowired
private UtilisateurRepository userRepository;
	@Override
	public Particulier saveParticulier(Particulier p,String login) {
		if(userRepository.UserActif(login)==null)
			return null;
		else{
			Utilisateur u=userRepository.getOne(login);
			p.setUtilisateur(u);
			//insertion automatique de la date
			Date date= new Date();
			//convertion en localDateTime
			  LocalDateTime localDateTime=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				//convertion en localDate
			  LocalDate localDate=localDateTime.toLocalDate();
			  p.setDateInscription(localDate);
			p.setEtat(true);
			p.setStatut(true);
			return particulierRepository.save(p);
		}
		
	}

	@Override
	public Particulier updateParticulier(Long id, Particulier p,String login) {
		if((trouve(id)==false)||(userRepository.UserActif(login)==null)) 
			return null;
			else {
				Utilisateur u=userRepository.getOne(login);
				p.setUtilisateur(u);
				p.setId(id);
				p.setEtat(true);
				p.setStatut(true);
				return particulierRepository.save(p);
			}
	}

	@Override
	public boolean deleteParticulier(Long id) {
		if(trouve(id)==false) 
			return false;
		else{
			particulierRepository.deleteParticulier(id);
			return true;
		}
	}

	@Override
	public List<Particulier> getAllParticulier() {
		// TODO Auto-generated method stub
		return particulierRepository.findAllParticulier();
	}

	@Override
	public Page<Particulier> getAllParticulierParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return particulierRepository.getParticulierParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public List<Particulier> getAllActif() {
		// TODO Auto-generated method stub
		return particulierRepository.getParticulierActif();
	}

	@Override
	public boolean trouve(Long id) {
	if(particulierRepository.trouveId(id)==null)
			return false;
		else return true;
	}

	@Override
	public int addParticulierToUser(String login,Long id) {
		if((trouve(id)==false)||userRepository.trouveId(login)==null)
			return 0;
		else{
			particulierRepository.addParticulierToUser(login, id);
			return 1; 
		}
		
	}

	@Override
	public List<Particulier> particulierActif() {
		
	return	particulierRepository.getParticulierActif();
		
	}

	@Override
	public Page<Particulier> getAllParRole(String role,int page, int size) {
		// TODO Auto-generated method stub
		return particulierRepository.getParticulierParRole(role, new PageRequest(page, size));
	}

	@Override
	public boolean activeParticulier(Long id) {
		if(trouve(id)==false)
			return false;
			
		else{
			particulierRepository.activeParticulier(id);
			return true;
		}
		
		
	}

	@Override
	public Page<Particulier> ParticulierParDate(LocalDate date,int page,int size) {
		// TODO Auto-generated method stub
		return particulierRepository.getParticulierPardate(date, new PageRequest(page, size));
	}

	@Override
	public boolean desactiveParticulier(Long id) {
		if(trouve(id)==false) 
			return false;
		else{
			particulierRepository.desactiveParticulier(id);
			return true;
		}
	}
	@Override
	public Particulier getParticulier(Long id) {
		// TODO Auto-generated method stub
		return particulierRepository.getOne(id);
	}

}
