package org.myrh.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.myrh.entities.Article;
import org.myrh.entities.Equipe;
import org.myrh.metier.EquipeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
public class EquipeRestService {
	@Autowired
	private EquipeMetier equipeMetier;
	
	@RequestMapping(value="/Equipe",
										produces = {MediaType.APPLICATION_JSON_VALUE, 
																MediaType.APPLICATION_XML_VALUE},
																method=RequestMethod.POST)
	public Equipe savEquipe(@RequestParam MultipartFile photo,
													@RequestParam(name="nomEquipe") String nom,
													@RequestParam(name="prenomEquipe") String prenom,
													  @RequestParam(name="titreEquipe") String titre,
													  @RequestParam(name="bibliographie") String bibliographie,
													  @RequestParam(name="urlLinkeldn") String urlLinkeldn,
													  @RequestParam(name="urlFacebook") String urlFacebook) {
	
		Equipe  e=new Equipe();
		e.setPhoto(photo.getOriginalFilename());
		e.setNomEquipe(nom);
		e.setBibliographie(bibliographie);
		e.setUrlLinkeldn(urlLinkeldn);
		e.setTitreEquipe(titre);
		e.setPrenomEquipe(prenom);
		e.setUrlFacebook(urlFacebook);
	
		return equipeMetier.saveEquipe(e);
	}
	@RequestMapping(value="/Equipe/{id}",method=RequestMethod.PUT)
	public Equipe updateEquipe(@PathVariable Long id, @RequestBody  Equipe e) {
		return equipeMetier.updateEquipe(id, e);
	}
	@RequestMapping(value="/Equipe/{id}",method=RequestMethod.DELETE)
	public boolean deleteEquipe(@PathVariable Long id) {
		return equipeMetier.deleteEquipe(id);
	}
	@RequestMapping(value="/Equipe",method=RequestMethod.GET)
	public List<Equipe> getAllequipe() {
		return equipeMetier.getAllequipe();
	}
	@RequestMapping(value="/EquipeParMc",method=RequestMethod.GET)
	public Page<Equipe> getAllEquipeParMc(
					@RequestParam(name="mc",defaultValue="")String mc, 
					@RequestParam(name="page",defaultValue="0")int page, 
					@RequestParam(name="size",defaultValue="5")int size) {
		return equipeMetier.getAllEquipeParMc(mc, page, size);
	}
	@RequestMapping(value="/EquipeId/{id}",method=RequestMethod.GET)
	public Equipe getEquipeParId(@PathVariable Long id) {
		return equipeMetier.getEquipeParId(id);
	}

}
