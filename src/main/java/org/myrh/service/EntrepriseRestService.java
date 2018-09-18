package org.myrh.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.myrh.entities.Entreprise;
import org.myrh.metier.EntrepriseMetier;
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
public class EntrepriseRestService {
	@Autowired
	public EntrepriseMetier entrepriseMetier;

	@RequestMapping(value="/Entreprise/{login}",method=RequestMethod.POST)
	public Entreprise saveEntreprise(@RequestBody Entreprise u, @PathVariable String login) {
		return entrepriseMetier.saveEntreprise(u,login);
	}
	@RequestMapping(value="/Entreprise/{id}/{login}",method=RequestMethod.PUT)
	public Entreprise updateEntreprise(@PathVariable Long id, @RequestBody Entreprise u,@PathVariable String login) {
		return entrepriseMetier.updateEntreprise(id, u,login);
	}
	@RequestMapping(value="/Entreprise/{id}",method=RequestMethod.DELETE)
	public boolean deleteEntreprise(@PathVariable Long id) {
		return entrepriseMetier.deleteEntreprise(id);
	}
	@RequestMapping(value="/Entreprise",method=RequestMethod.GET)
	public List<Entreprise> getAllEntreprise() {
		return entrepriseMetier.getAllEntreprise();
	}
	@RequestMapping(value="/EntrepriseParMc",method=RequestMethod.GET)
	public Page<Entreprise> getAllEntrepriseParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return entrepriseMetier.getAllEntrepriseParMc(mc, page, size);
	}
	@RequestMapping(value="/EntrepriseActif",method=RequestMethod.GET)
	public List<Entreprise> getAllActif() {
		return entrepriseMetier.getAllActif();
	}
	@RequestMapping(value="/addEntrepriseToUser/{login}/{id}",method=RequestMethod.POST)
	public int addEntrepriseToUser(@PathVariable String login, @PathVariable Long id) {
		return entrepriseMetier.addEntrepriseToUser(login, id);
	}
	@RequestMapping(value="/EntrepriseParRole",method=RequestMethod.GET)
	public Page<Entreprise> getAllParRole(
			@RequestParam(name="role",defaultValue="")String role, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return entrepriseMetier.getAllParRole(role,page,size);
	}
	@RequestMapping(value="/activeEntreprise/{id}",method=RequestMethod.DELETE)
	public void activeEntreprise(@PathVariable Long id) {
		entrepriseMetier.activeEntreprise(id);
	}
	@RequestMapping(value="/EntrepriseParDate",method=RequestMethod.GET)
	public Page<Entreprise> getEntrepriseParDate(
			@RequestParam(name="date",defaultValue="")String date, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		LocalDate dates=LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return entrepriseMetier.getEntrepriseParDate(dates,page,size);
	}
	@RequestMapping(value="/desactiveEntreprise/{id}",method=RequestMethod.DELETE)
	public void desactiveEntreprise(@PathVariable Long id) {
		entrepriseMetier.desactiveEntreprise(id);
	}
	@RequestMapping(value="/EntrepriseId/{id}",method=RequestMethod.GET)
	public Entreprise getEntreprise(@PathVariable Long id) {
		return entrepriseMetier.getEntreprise(id);
	}

}
