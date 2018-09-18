package org.myrh.metier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.myrh.dao.DocumentRepository;
import org.myrh.dao.UtilisateurRepository;
import org.myrh.entities.Document;
import org.myrh.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class DocumentMetierImpl implements DocumentMetier{
	@Autowired
	private DocumentRepository documentRepository;
	@Autowired
	private UtilisateurRepository userRepository;
	@Override
	public Document saveDoc(Document d) {
		
		Date date= new Date();
		//convertion en localDateTime
		  LocalDateTime localDateTime=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			//convertion en localDate
		  LocalDate localDate=localDateTime.toLocalDate();
		  d.setDateTelechargement(localDate);
		d.setEtat(true);
		return documentRepository.save(d);
	}

	@Override
	public Document updateDoc(String intitule, Document d) {
		if(trouve(intitule)==false)
			return null;
		else{
			d.setIntitule(intitule);
			d.setEtat(true);
			return documentRepository.save(d);
		}
	}

	@Override
	public boolean deleteDoc(String intitule) {
		if(trouve(intitule)==false)
			return false;
		else{
			documentRepository.deleteDoc(intitule);
			return true;
		}
		
	}

	@Override
	public boolean uploderDoc(String intitule) {
		if(trouve(intitule)==false)
			return false;
		else{
			documentRepository.uploaderDoc(intitule);
			return true;
		}
		
	}

	@Override
	public boolean archiverDoc(String intitule) {
		if(trouve(intitule)==false)
			return false;
		else{
			documentRepository.archiverDoc(intitule);
			return true;
		}
		
	}

	@Override
	public List<Document> getAllDoc() {
		// TODO Auto-generated method stub
		return documentRepository.getAllDoc();
	}

	@Override
	public Page<Document> getDocParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return documentRepository.getAllParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public List<Document> getAllParDateTelechargement(LocalDate date) {
		// TODO Auto-generated method stub
		return documentRepository.getAllParDateTelechargement(date);
	}

	@Override
	public Page<Document> getAllDocArchive(int page, int size) {
		// TODO Auto-generated method stub
		return documentRepository.getAllDocArchive(new PageRequest(page, size));
	}

	@Override
	public Page<Document> getAllDocUploder(int page, int size) {
		// TODO Auto-generated method stub
		return documentRepository.getAllDocUploder(new PageRequest(page, size));
	}


	@Override
	public Page<Utilisateur> getUserParDateTelechargement(LocalDate date, String intitule, int page, int size) {
		// TODO Auto-generated method stub
		return documentRepository.getUserParDateTelechargement(date, intitule, new PageRequest(page, size));
	}

	@Override
	public boolean trouve(String intitule) {
		if(documentRepository.trouveId(intitule)==null)
			return false;
		else return true;
	}

	@Override
	public boolean downloadDoc(String intitule) {
		if(trouve(intitule)==false)
			return false;
		else{
			documentRepository.downloaderDoc(intitule);
			return true;
		}
	}

	@Override
	public boolean desarchiverDoc(String intitule) {
		if(trouve(intitule)==false)
			return false;
		else{
			documentRepository.desarchiverDoc(intitule);
			return true;
		}
		
	}

	@Override
	public Utilisateur addUserToDocument(String login, String intitule) {
		if((trouve(intitule)==false)||(userRepository.trouveId(login)==null))//||(userRepository.UserActif()==null)
			return null;
		else{
			Utilisateur u=userRepository.getOne(login);
			Document d=documentRepository.getOne(intitule);
			u.getDocuments().add(d);
			d.getUtilisateurs().add(u);
			userRepository.save(u);
			documentRepository.save(d);
			return u;
		}
	}

	@Override
	public Document getDoc(String intitule) {
		// TODO Auto-generated method stub
		return documentRepository.getOne(intitule);
	}

}
