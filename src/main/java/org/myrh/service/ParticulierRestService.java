package org.myrh.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.myrh.entities.Particulier;
import org.myrh.metier.ParticulierMetier;
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
public class ParticulierRestService {
	@Autowired
	public ParticulierMetier particulierMetier;

	@RequestMapping(value="/Particulier/{login}",method=RequestMethod.POST)
	public Particulier saveParticulier(@RequestBody Particulier p, @PathVariable String login) {
		return particulierMetier.saveParticulier(p,login);
	}
	@RequestMapping(value="/Particulier/{id}/{login}",method=RequestMethod.PUT)
	public Particulier updateParticulier(@PathVariable Long id, @RequestBody Particulier u,@PathVariable String login) {
		return particulierMetier.updateParticulier(id, u,login);
	}
	@RequestMapping(value="/Particulier/{id}",method=RequestMethod.DELETE)
	public boolean deleteParticulier(@PathVariable Long id) {
		return particulierMetier.deleteParticulier(id);
	}
	@RequestMapping(value="/Particulier",method=RequestMethod.GET)
	public List<Particulier> getAllParticulier() {
		return particulierMetier.getAllParticulier();
	}
	@RequestMapping(value="/ParticulierParMc",method=RequestMethod.GET)
	public Page<Particulier> getAllParticulierParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return particulierMetier.getAllParticulierParMc(mc, page, size);
	}
	@RequestMapping(value="/ParticulierActif",method=RequestMethod.GET)
	public List<Particulier> getAllActif() {
		return particulierMetier.getAllActif();
	}
	@RequestMapping(value="/addParticulierToUser/{login}/{id}",method=RequestMethod.POST)
	public int addParticulierToUser(@PathVariable String login, @PathVariable Long id) {
		return particulierMetier.addParticulierToUser(login, id);
	}
	@RequestMapping(value="/ParticulierParRole",method=RequestMethod.GET)
	public Page<Particulier> ParticulierParRole(
			@RequestParam(name="role",defaultValue="")String role,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size) {
		return particulierMetier.getAllParRole(role,page,size);
	}
	@RequestMapping(value="/activeParticulier/{id}",method=RequestMethod.DELETE)
	public void activeParticulier(@PathVariable Long id) {
		particulierMetier.activeParticulier(id);
	}
	@RequestMapping(value="/ParticulierParDate",method=RequestMethod.GET)
	public Page<Particulier> getParticulierParDate(
			@RequestParam(name="date",defaultValue="")String date,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size) {
		LocalDate dates=LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return particulierMetier.ParticulierParDate(dates, page, size);   
	}
	@RequestMapping(value="/desactiveParticulier/{id}",method=RequestMethod.DELETE)
	public void desactiveParticulier(@PathVariable Long id) {
		particulierMetier.desactiveParticulier(id);
	}
	@RequestMapping(value="/getParticulierParId/{id}",method=RequestMethod.GET)
	public Particulier getParticulier(@PathVariable Long id) {
		return particulierMetier.getParticulier(id);
	}

}
