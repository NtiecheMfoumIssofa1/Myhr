package org.myrh.metier;

import java.time.LocalDate;
import java.util.List;

import org.myrh.entities.Entreprise;
import org.springframework.data.domain.Page;

public interface EntrepriseMetier {
	public Entreprise saveEntreprise(Entreprise u,String login);
	public Entreprise updateEntreprise(Long id,Entreprise u,String login);
	public boolean deleteEntreprise(Long id);
    public List<Entreprise> getAllEntreprise();
    public Page<Entreprise> getAllEntrepriseParMc(String mc,int page,int size);
    public List<Entreprise> getAllActif();
    public boolean trouve(Long id);
    public int addEntrepriseToUser(String login,Long id);
    public Page<Entreprise> getAllParRole(String role,int page,int size);
    public boolean activeEntreprise(Long id);
    public Page<Entreprise> getEntrepriseParDate(LocalDate date,int page,int size);
    public boolean desactiveEntreprise(Long id);
    public Entreprise getEntreprise(Long id);

}
