package org.myrh.service;

import java.util.ArrayList;
import java.util.List;

import org.myrh.entities.Profil;
import org.myrh.entities.Utilisateur;
import org.myrh.metier.ProfilMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")//cette anotation autorise l'acces a cette restService par n'importe quel application(c'est quand on developpe la partie front qu'on l'ajoute)
public class ProfilRestService {
	@Autowired
	private ProfilMetier profilMetier;
	
	
	@RequestMapping(value="/Profil",method=RequestMethod.POST)
	public Profil saveProfil(@RequestBody Profil p) {
		return profilMetier.saveProfil(p);
	}
	@RequestMapping(value="/Profil/{idProfil}",method=RequestMethod.PUT)
	public Profil updateProfil(@PathVariable Long idProfil,@RequestBody Profil p) {
		return profilMetier.updateProfil(idProfil, p);
	}
	@RequestMapping(value="/Profil/{idProfil}",method=RequestMethod.DELETE)
	public boolean deleteProfil(@PathVariable Long idProfil) {
		return profilMetier.deleteProfil(idProfil);
	}
	//@Secured(value={"ROLE_ADMIN","ROLE_EMPLOYE"})
	@RequestMapping(value="/Profil",method=RequestMethod.GET)
	public List<Profil> getAllProfil() {
		return profilMetier.getAllProfil();
	}
	@RequestMapping(value="/ProfilParMC",method=RequestMethod.GET)
	public Page<Profil> getAllProfilParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return profilMetier.getAllProfilParMc(mc, page, size);
	}

	@RequestMapping(value="/addUserToProfil/{idProfil}/{idUser}",method=RequestMethod.POST)
	public int addUserToProfil(@PathVariable Long idProfil, @PathVariable String idUser) {
		return profilMetier.addUserToProfil(idProfil, idUser);
	}
	@RequestMapping(value="/ProfilActif/{idProfil}",method=RequestMethod.GET)
	public Profil profilActif(@PathVariable Long idProfil) {
		return profilMetier.profilActif(idProfil);
	}
	@RequestMapping(value="/ProfilId/{idProfil}",method=RequestMethod.GET)
	public List<Utilisateur> getAllUserParProfil(@PathVariable Long idProfil) {
		return profilMetier.getAllUserParProfil(idProfil);
	}
	@RequestMapping(value="/removeUserToProfil/{idUser}",method=RequestMethod.POST)
	public int removeUserToProfil(@PathVariable String idUser) {
		return profilMetier.removeUserToProfil(idUser);
	}
	@RequestMapping(value="/getAllRecherche",method=RequestMethod.GET)
	public ArrayList<Object> getAllRecherche(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return profilMetier.getAllRecherche(mc, page, size);
	}

}
