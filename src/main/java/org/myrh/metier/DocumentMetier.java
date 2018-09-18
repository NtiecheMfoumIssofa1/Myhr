package org.myrh.metier;

import java.time.LocalDate;
import java.util.List;

import org.myrh.entities.Document;
import org.myrh.entities.Utilisateur;
import org.springframework.data.domain.Page;

public interface DocumentMetier {
	public Document saveDoc(Document d);
	public Document updateDoc(String intitule,Document d);
	public boolean deleteDoc(String intitule);
	public boolean uploderDoc(String intitule);
	public boolean downloadDoc(String intitule);
	public boolean archiverDoc(String intitule);
	public boolean desarchiverDoc(String intitule);
	public List<Document> getAllDoc();
	public Page<Document> getDocParMc(String mc,int page,int size);
	public List<Document> getAllParDateTelechargement(LocalDate date);
	public Page<Document> getAllDocArchive(int page,int size);
	public Page<Document> getAllDocUploder(int page,int size);
	public Page<Utilisateur> getUserParDateTelechargement(LocalDate date,String intitule,int page,int size);
	public boolean trouve(String intitule);
	public Utilisateur addUserToDocument(String login, String intitule);
	public Document getDoc(String intitule);
}
