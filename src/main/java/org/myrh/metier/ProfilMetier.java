package org.myrh.metier;

import java.util.ArrayList;
import java.util.List;

import org.myrh.entities.Profil;
import org.myrh.entities.Utilisateur;
import org.springframework.data.domain.Page;

public interface ProfilMetier {
	public Profil saveProfil(Profil p);
	public Profil updateProfil(Long idProfil,Profil p);
	public boolean deleteProfil(Long idProfil);
    public List<Profil> getAllProfil();
    public Page<Profil> getAllProfilParMc(String mc,int page,int size);
    public boolean trouve(Long idProfil);
    public int addUserToProfil(Long idProfil,String idUser);
    public Profil profilActif(Long idProfil);
    public List<Utilisateur> getAllUserParProfil(Long idProfil);
    public int removeUserToProfil(String idUser);
    public ArrayList<Object> getAllRecherche(String mc,int page,int size);

}
