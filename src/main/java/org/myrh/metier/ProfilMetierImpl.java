package org.myrh.metier;

import java.util.ArrayList;
import java.util.List;

import org.myrh.dao.ArticleRepository;
import org.myrh.dao.CategorieArticleRepository;
import org.myrh.dao.DocumentRepository;
import org.myrh.dao.EntrepriseRepository;
import org.myrh.dao.ParticulierRepository;
import org.myrh.dao.ProfilRepository;
import org.myrh.dao.UtilisateurRepository;
import org.myrh.entities.Article;
import org.myrh.entities.CategorieArticle;
import org.myrh.entities.Document;
import org.myrh.entities.Entreprise;
import org.myrh.entities.Particulier;
import org.myrh.entities.Profil;
import org.myrh.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class ProfilMetierImpl implements ProfilMetier{
	@Autowired
	private ProfilRepository profilRepository;
	@Autowired
	private UtilisateurRepository userRepository;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	  public CategorieArticleRepository categorieRepository;
	@Autowired
	private DocumentRepository documentRepository;
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private ParticulierRepository particulierRepository;
	@Override
	public Profil saveProfil(Profil p) {
		p.setEtat(true);
		return profilRepository.save(p);
	}

	@Override
	public Profil updateProfil(Long idProfil, Profil p) {
		if(trouve(idProfil)==false)
			return null;
		else{
			p.setIdprofil(idProfil);
			p.setEtat(true);
			return	profilRepository.save(p);
		}
	}

	@Override
	public boolean deleteProfil(Long idProfil) {
		if(trouve(idProfil)==false)
			return false;
		else{
			profilRepository.deleteProfil(idProfil);
			return true;
		}
		
	}

	@Override
	public List<Profil> getAllProfil() {
		// TODO Auto-generated method stub
		return profilRepository.findAllProfil();
	}

	@Override
	public Page<Profil> getAllProfilParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return profilRepository.getProfilParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public boolean trouve(Long idProfil) {
		if(profilRepository.trouveId(idProfil)==null)
			return false;
		else return true;
	}

	@Override
	public int addUserToProfil(Long idProfil, String idUser) {
		if((trouve(idProfil)==false)||(userRepository.trouveId(idUser)==null)){
			return 0;
		}else{
			
			 profilRepository.addUserToProfil(idProfil, idUser);
			 return 1;
		}
		
	}

	@Override
	public Profil profilActif(Long idProfil) {
		if(profilRepository.ProfilActif(idProfil)==null)
			return null;
		else{
			
			return profilRepository.ProfilActif(idProfil);
		}
		
	}

	@Override
	public List<Utilisateur> getAllUserParProfil(Long idProfil) {
		// TODO Auto-generated method stub
		return profilRepository.getUserParProfil(idProfil);
	}
//enlever un profil a un utilisateur
	
	public int removeUserToProfil(String idUser) {
		if((userRepository.trouveId(idUser)==null)){
			return 0;
		}else{
			
			 profilRepository.removeUserToProfil(idUser);
			 return 1;
		}
	}

	@Override
	public ArrayList<Object> getAllRecherche(String mc,int page,int size) {
		ArrayList<Object> liste=new ArrayList<>();
		Page Profil =   profilRepository.getProfilParMc("%"+mc+"%", new PageRequest(page, size));
		liste.add(Profil);
	/*	Page Article = articleRepository.getAllArticleParMc("%"+mc+"%", new PageRequest(page, size));
		liste.add(Article);
		Page CategorieArticle = categorieRepository.getCatParMc("%"+mc+"%", new PageRequest(page, size));
		liste.add(CategorieArticle);
		Page Document = documentRepository.getAllParMc("%"+mc+"%", new PageRequest(page, size));
		liste.add(Document);
		Page Entreprise = entrepriseRepository.getEntrepriseParMc("%"+mc+"%", new PageRequest(page, size));
		liste.add(Entreprise);
		Page Particulier = particulierRepository.getParticulierParMc("%"+mc+"%", new PageRequest(page, size));
		liste.add(Particulier);*/
		return  liste;
	}

}
