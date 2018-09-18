package org.myrh.metier;

import java.util.List;

import org.myrh.entities.Utilisateur;
import org.springframework.data.domain.Page;

public interface UtilisateurMetier {
	public Utilisateur saveUser(Utilisateur u,Long profil,String abonnement);
	public Utilisateur updateUser(String login,Utilisateur u,Long profil,String abonnement);
	public boolean deleteUser(String login);
    public List<Utilisateur> getAllUser();
    public Page<Utilisateur> getAllUserParMc(String mc,int page,int size);
    public List<Utilisateur> getAllActif();
    public boolean trouve(String login);
    public Utilisateur addRoleToUser(String login,String role);
    public boolean userActif(String login);
    public List<Utilisateur> getAllParRole(String role);
    public void activeUser(String login);
    public Utilisateur getUser(String login);
    
}
