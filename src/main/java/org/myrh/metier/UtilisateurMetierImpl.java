package org.myrh.metier;

import java.util.List;

import org.myrh.dao.AbonnementRepository;
import org.myrh.dao.ProfilRepository;
import org.myrh.dao.RoleRepository;
import org.myrh.dao.UtilisateurRepository;
import org.myrh.entities.Abonnement;
import org.myrh.entities.Profil;
import org.myrh.entities.Role;
import org.myrh.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class UtilisateurMetierImpl implements UtilisateurMetier{
	@Autowired
	private UtilisateurRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private ProfilRepository profilRepository;
	@Autowired
	private AbonnementRepository abonnementRepository;
	@Override
	public Utilisateur saveUser(Utilisateur u,Long profil,String abonnemen) {
	 if((abonnemen==null)
			 ||(abonnementRepository.getOne(abonnemen)==null)
			 ||(profil==0)
			 ||(profilRepository.ProfilActif(profil)==null)){
				u.setEtat(true);
				u.setStatut(true);
			String abonnement="Classic";//permet de figer le champs libAbonnement a classic
			Abonnement a=abonnementRepository.getOne(abonnement);
			u.setAbonnement(a);
			Long prof=0L;
			Profil p=profilRepository.getOne(prof);
			u.setProfil(p);
			return userRepository.save(u);
		}else if((abonnementRepository.getOne(abonnemen)!=null)){
				u.setEtat(true);
				u.setStatut(true);
				Abonnement a=abonnementRepository.getOne(abonnemen);
				u.setAbonnement(a);
				Profil p=profilRepository.getOne(profil);
				u.setProfil(p);
				return userRepository.save(u);
				
		}else{
			return u;
		}
		
	
	}

	@Override
	public Utilisateur updateUser(String login, Utilisateur u,Long profil,String abonnemen) {
		if((abonnemen==null)
				 ||(abonnementRepository.getOne(abonnemen)==null)
				 ||(profil==0)
				 ||(profilRepository.ProfilActif(profil)==null)
				 ||(trouve(login)==false)){
		
					u.setEtat(true);
					u.setStatut(true);
				String abonnement="Classic";//permet de figer le champs libAbonnement a classic
				Abonnement a=abonnementRepository.getOne(abonnement);
				u.setAbonnement(a);
				Long prof=0L;
				Profil p=profilRepository.getOne(prof);
				u.setProfil(p);
				return userRepository.save(u);
		
			}else if((profil!=0)&&(abonnemen!=null)){
				
					u.setEtat(true);
					u.setStatut(true);
					u.setLogin(login);
					Abonnement a=abonnementRepository.getOne(abonnemen);
					u.setAbonnement(a);
					Profil p=profilRepository.getOne(profil);
					u.setProfil(p);
					return userRepository.save(u);
				
			}else{
				return u;
			}
			
		
		}

	@Override
	public boolean deleteUser(String login) {
		if(trouve(login)==false){
			return false;
		}else{
			userRepository.deleteUser(login);
			return true;
		}
		
	}

	@Override
	public List<Utilisateur> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAllUser();
	}

	@Override
	public Page<Utilisateur> getAllUserParMc(String mc,int page,int size) {
		// TODO Auto-generated method stub
		return userRepository.getUserParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public List<Utilisateur> getAllActif() {
		// TODO Auto-generated method stub
		return userRepository.ListUserActif();
	}

	@Override
	public boolean trouve(String login) {
		if(userRepository.trouveId(login)==null)
		return false;
		else return true;
	}

	@Override
	public Utilisateur addRoleToUser(String login, String role) {
		if(((trouve(login)==false)
				||roleRepository.trouveId(role)==null)){//||roleRepository.roleActif()==null...||
			return null;
		}else{
			Utilisateur u=userRepository.getOne(login);
			Role r=roleRepository.getOne(role);
			u.getRoles().add(r);
			r.getUtilisateurs().add(u);
			userRepository.save(u);
			roleRepository.save(r);
			return u;
		}
		
	}

	@Override
	public boolean userActif(String login) {
		if(userRepository.UserActif(login)==null)
			return false;
		else return true;
	}

	@Override
	public List<Utilisateur> getAllParRole(String role) {
		// TODO Auto-generated method stub
		return userRepository.getUserParRole(role);
	}

	@Override
	public void activeUser(String login) {
		userRepository.activeUser(login);
		
	}

	@Override
	public Utilisateur getUser(String login) {
		
		return userRepository.getOne(login);
	}

}
