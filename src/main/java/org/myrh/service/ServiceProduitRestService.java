package org.myrh.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.myrh.entities.ServiceProduit;
import org.myrh.metier.ServiceProduitMetier;
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
public class ServiceProduitRestService {
@Autowired
	private ServiceProduitMetier serviceProduitMetier;

@RequestMapping(value="/ServiceProd/{ids}",method=RequestMethod.POST)
public ServiceProduit saveserviceProd(@RequestBody ServiceProduit s, @PathVariable Long ids) {
	return serviceProduitMetier.saveserviceProd(s, ids);
}

@RequestMapping(value="/ServiceProd/{idp}/{ids}",method=RequestMethod.PUT)
public ServiceProduit updateProduit(@RequestBody ServiceProduit s, @PathVariable Long idp,
																		@PathVariable Long ids) {
	return serviceProduitMetier.updateProduit(s, idp, ids);
}

@RequestMapping(value="/ServiceProd/{id}",method=RequestMethod.DELETE)
public boolean deleteProduit(@PathVariable Long id) {
	return serviceProduitMetier.deleteProduit(id);
}

@RequestMapping(value="/ServiceProd",method=RequestMethod.GET)
public List<ServiceProduit> getAllProduit() {
	return serviceProduitMetier.getAllProduit();
}
@RequestMapping(value="/ServiceProdParMc",method=RequestMethod.GET)
public Page<ServiceProduit> getAllProduitParMc(
										@RequestParam(name="mc", defaultValue="")String mc,
										@RequestParam(name="page", defaultValue="0")int page, 
										@RequestParam(name="size", defaultValue="5")int size) {
	return serviceProduitMetier.getAllProduitParMc(mc, page, size);
}
@RequestMapping(value="/ServiceProdId/{id}",method=RequestMethod.GET)
public ServiceProduit getProduit(@PathVariable  Long id) {
	return serviceProduitMetier.getProduit(id);
}
@RequestMapping(value="/getProdReserve/",method=RequestMethod.GET)
public Page<ServiceProduit> getProdReserve(
		@RequestParam(name="date", defaultValue="")String date,
		@RequestParam(name="page", defaultValue="0")int page, 
		@RequestParam(name="size", defaultValue="5")int size){
	LocalDate dates= LocalDate.parse("date", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	return serviceProduitMetier.getProdReserve(dates, page, size);
}

}
