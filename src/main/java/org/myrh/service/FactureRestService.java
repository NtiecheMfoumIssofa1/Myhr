package org.myrh.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.myrh.entities.Facture;
import org.myrh.metier.FactureMetier;
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
public class FactureRestService {
	@Autowired
	private FactureMetier factureMetier;
	@RequestMapping(value="/Facture/{login}/{abonnement}",method=RequestMethod.POST)
	public Facture saveFacture(@RequestBody Facture f,@PathVariable String login, @PathVariable String abonnement) {
		return factureMetier.saveFacture(f,login,abonnement);
	}
	@RequestMapping(value="/Facture/{id}/{login}/{abonnement}",method=RequestMethod.PUT)
	public Facture updateFacture(@PathVariable String id,@PathVariable String login, @PathVariable String abonnement, @RequestBody Facture f) {
		return factureMetier.updateFacture(id,f,login, abonnement);
	}
	@RequestMapping(value="/Facture/{id}",method=RequestMethod.DELETE)
	public boolean deleteFacture(@PathVariable String id) {
		return factureMetier.deleteFacture(id);
	}
	@RequestMapping(value="/Facture",method=RequestMethod.GET)
	public List<Facture> getAllFacture() {
		return factureMetier.getAllFacture();
	}
	@RequestMapping(value="/FactureParMc",method=RequestMethod.GET)
	public Page<Facture> getFactureParMc(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size) {
		return factureMetier.getFactureParMc(mc,page,size);
	}
	@RequestMapping(value="/FactureParDate",method=RequestMethod.GET)
	public Page<Facture> getFactureParDate(
			@RequestParam(name="date",defaultValue="")String date,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size)  {
		LocalDate dates=LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return factureMetier.getFactureParDate(dates,page,size);
	}
	@RequestMapping(value="/generateFactureParticulier/{abonnement}/{login}",method=RequestMethod.GET)
	public List<Facture> genererFactureParticulier(@PathVariable String abonnement,
																								@PathVariable String login					) {
		return factureMetier.genererFactureParticulier(abonnement, login);
	}
	@RequestMapping(value="/generateFactureEntreprise/{abonnement}/{login}",method=RequestMethod.GET)
	public List<Facture> genererFactureEntreprise(
											@PathVariable String abonnement,
											@PathVariable String login
											) {
		return factureMetier.genererFactureEntreprise(abonnement, login);
	}
	@RequestMapping(value="/paiementFacture/{id}",method=RequestMethod.DELETE)
	public boolean paiementFacture(@PathVariable String id) {
		return factureMetier.paiementFacture(id);
	}
	@RequestMapping(value="/getFacture/{id}",method=RequestMethod.GET)
	public Facture getFacture(@PathVariable String id) {
		return factureMetier.getFacture(id);
	}

}
