package org.myrh.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.myrh.entities.Document;
import org.myrh.entities.Utilisateur;
import org.myrh.metier.DocumentMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
public class DocumentRestService {
	@Autowired
	private DocumentMetier documentMetier;
	
	@RequestMapping(value="/Document",method=RequestMethod.POST)
	
	public Document saveDoc(@RequestParam MultipartFile lienTelechargement,
														@RequestParam(name="intitule") String intitule) {
		Document d = new Document();
		d.setIntitule(intitule);
		d.setLienTelechargement(lienTelechargement.getOriginalFilename());
		return documentMetier.saveDoc(d);
	}
	@RequestMapping(value="/Document/{intitule}",method=RequestMethod.PUT)
	public Document updateDoc(@PathVariable String intitule, @RequestBody Document d) {
		return documentMetier.updateDoc(intitule, d);
	}
	@RequestMapping(value="/Document/{intitule}",method=RequestMethod.DELETE)
	public boolean deleteDoc(@PathVariable String intitule) {
		return documentMetier.deleteDoc(intitule);
	}
	@RequestMapping(value="/DocumentUploader/{intitule}",method=RequestMethod.DELETE)
	public boolean uploderDoc(@PathVariable String intitule) {
		return documentMetier.uploderDoc(intitule);
	}
	@RequestMapping(value="/DocumentDowaload/{intitule}",method=RequestMethod.DELETE)
	public boolean downloadDoc(@PathVariable String intitule) {
		return documentMetier.downloadDoc(intitule);
	}
	@RequestMapping(value="/Documentarchiver/{intitule}",method=RequestMethod.DELETE)
	public boolean archiverDoc(@PathVariable String intitule) {
		return documentMetier.archiverDoc(intitule);
	}
	@RequestMapping(value="/Documentdesarchiver/{intitule}",method=RequestMethod.DELETE)
	public boolean desarchiverDoc(@PathVariable String intitule) {
		return documentMetier.desarchiverDoc(intitule);
	}
	@RequestMapping(value="/Document",method=RequestMethod.GET)
	public List<Document> getAllDoc() {
		return documentMetier.getAllDoc();
	}
	@RequestMapping(value="/DocumentParMc",method=RequestMethod.GET)
	public Page<Document> getDocParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return documentMetier.getDocParMc(mc, page, size);
	}
	@RequestMapping(value="/DocumentParDateTelechargement/{date}",method=RequestMethod.GET)
	public List<Document> getAllParDateTelechargement(@PathVariable String date) {
		LocalDate dates=LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return documentMetier.getAllParDateTelechargement(dates);
	}
	@RequestMapping(value="/DocumentArchive",method=RequestMethod.GET)
	public Page<Document> getAllDocArchive(
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return documentMetier.getAllDocArchive(page, size);
	}
	@RequestMapping(value="/DocumentAllDocUploder",method=RequestMethod.GET)
	public Page<Document> getAllDocUploder(
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return documentMetier.getAllDocUploder(page, size);
	}
	@RequestMapping(value="/DocumentParUser/{date}/{intitule}",method=RequestMethod.GET)
	public Page<Utilisateur> getUserParDateTelechargement(@PathVariable String date, @PathVariable String intitule, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		LocalDate dates=LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return documentMetier.getUserParDateTelechargement(dates, intitule, page, size);
	}
	@RequestMapping(value="/addUserToDocument/{login}/{intitule}",method=RequestMethod.POST)
	public Utilisateur addUserToDocument(@PathVariable String login, @PathVariable String intitule) {
		return documentMetier.addUserToDocument(login, intitule);
	}
	@RequestMapping(value="/DocumentId/{intitule}",method=RequestMethod.GET)
	public Document getDoc(@PathVariable String intitule) {
		return documentMetier.getDoc(intitule);
	}

}
