package org.myrh.service;

import java.util.List;

import org.myrh.entities.Abonnement;
import org.myrh.entities.Utilisateur;
import org.myrh.metier.AbonnementMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AbonnementRestService {
	@Autowired
	private AbonnementMetier abonnementMetier;

	@RequestMapping(value="/Abonnement",method=RequestMethod.POST)
	public Abonnement saveA(@RequestBody Abonnement a) {
		return abonnementMetier.saveA(a);
	}
	@RequestMapping(value="/Abonnement/{id}",method=RequestMethod.PUT)
	public Abonnement updateA(@PathVariable String id, @RequestBody Abonnement a) {
		return abonnementMetier.updateA(id, a);
	}
	@RequestMapping(value="/Abonnement/{id}",method=RequestMethod.DELETE)
	public boolean deleteA(@PathVariable String id) {
		return abonnementMetier.deleteA(id);
	}
	@RequestMapping(value="/Abonnement",method=RequestMethod.GET)
	public List<Abonnement> getAllAbonnement() {
		return abonnementMetier.getAllAbonnement();
	}
	@RequestMapping(value="/AbonnementParMc",method=RequestMethod.GET)
	public Page<Abonnement> getAllParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return abonnementMetier.getAllParMc(mc, page, size);
	}
	@RequestMapping(value="/AbonnementParCout",method=RequestMethod.GET)
	public List<Abonnement> getAllAbonnementParCout() {
		return abonnementMetier.getAllAbonnementParCout();
	}
	@RequestMapping(value="/desactiverAbonnement/{abonnement}",method=RequestMethod.PUT)
	public boolean desactiverA(@PathVariable String abonnement) {
		return abonnementMetier.desactiverA(abonnement);
	}
	@RequestMapping(value="/UpOuDOWAbonnementParticulier/{abonnement}",method=RequestMethod.PUT)
	public int upgradeEtdowngradeAParticulier(@PathVariable String abonnement) {
		return abonnementMetier.upgradeEtdowngradeAParticulier(abonnement);
	}
	@RequestMapping(value="/UpOuDOWAbonnementEntreprise/{abonnement}",method=RequestMethod.PUT)
	public int upgradeEtdowngradeAEntreprise(@PathVariable String abonnement) {
		return abonnementMetier.upgradeEtdowngradeAEntreprise(abonnement);
	}
	@RequestMapping(value="/resilierABonnementParticulier/{id}",method=RequestMethod.PUT)
	public boolean resilierAParticulier(@PathVariable Long id) {
		return abonnementMetier.resilierAParticulier(id);
	}
	@RequestMapping(value="/resilierABonnementEntreprise/{id}",method=RequestMethod.PUT)
	public boolean resilierAEntrprise(@PathVariable Long id) {
		return abonnementMetier.resilierAEntrprise(id);
	}
	@RequestMapping(value="/getUserParAbonnement/{abonnement}",method=RequestMethod.GET)
	public List<Object> getUserParAbonnement(@PathVariable String abonnement) {
		return abonnementMetier.getUserParAbonnement(abonnement);
	}
	@RequestMapping(value="/activerAbonnement/{abonnement}",method=RequestMethod.PUT)
	public int activerA(@PathVariable String abonnement) {
		return abonnementMetier.activerA(abonnement);
	}
	@RequestMapping(value="/suspendreAbonnement/{abonnement}",method=RequestMethod.PUT)
	public int suspendre(@PathVariable String abonnement) {
		return abonnementMetier.suspendre(abonnement);
	}
	@RequestMapping(value="/reactiverAbonnement/{abonnement}",method=RequestMethod.PUT)
	public int reactiverA(@PathVariable String abonnement) {
		return abonnementMetier.reactiverA(abonnement);
	}
	@RequestMapping(value="addAbonnementToUser/{login}/{abonnement}",method=RequestMethod.POST)
	public boolean addAbonnementToUser(@PathVariable String login,@PathVariable String abonnement) {
		return abonnementMetier.addAbonnementToUser(login, abonnement);
	}

}
