package org.myrh.service;

import java.util.List;

import org.myrh.entities.ServiceCategorie;
import org.myrh.entities.ServiceProduit;
import org.myrh.metier.ServiceCategorieMetier;
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
public class ServiceCategorieRestService {
	@Autowired
	private ServiceCategorieMetier serviceMetier;
	
	@RequestMapping(value="/Service", method=RequestMethod.POST)
	public ServiceCategorie saveEquipe(@RequestBody ServiceCategorie s) {
		return serviceMetier.saveEquipe(s);
	}
	 @RequestMapping(value="/Service/{id}", method=RequestMethod.PUT)
	public ServiceCategorie updateEquipe(@PathVariable Long id, @RequestBody ServiceCategorie s) {
		return serviceMetier.updateEquipe(id, s);
	}
	 @RequestMapping(value="/Service/{id}", method=RequestMethod.DELETE)
	public boolean deleteEquipe(@PathVariable Long id) {
		return serviceMetier.deleteEquipe(id);
	}
	 @RequestMapping(value="/Service", method=RequestMethod.GET)
	public List<ServiceCategorie> getAllequipe() {
		return serviceMetier.getAllequipe();
	}
	 @RequestMapping(value="/ServiceParMc", method=RequestMethod.GET)
	public Page<ServiceCategorie> getAllEquipeParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return serviceMetier.getAllEquipeParMc(mc, page, size);
	} 
	 @RequestMapping(value="/ServiceId/{id}", method=RequestMethod.GET)
	public ServiceCategorie getEquipeParId(@PathVariable  Long id) {
		return serviceMetier.getEquipeParId(id);
	}
	 @RequestMapping(value="/getProduitParCat/{id}", method=RequestMethod.GET)
	public List<ServiceProduit> getProduitParCat(@PathVariable Long id) {
		return serviceMetier.getProduitParCat(id);
	}
	

}
