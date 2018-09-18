package org.myrh.metier;

import java.time.LocalDate;
import java.util.List;

import org.myrh.entities.Particulier;
import org.springframework.data.domain.Page;

public interface ParticulierMetier {
	public Particulier saveParticulier(Particulier u,String login);
	public Particulier updateParticulier(Long id,Particulier u,String login);
	public boolean deleteParticulier(Long id);
    public List<Particulier> getAllParticulier();
    public Page<Particulier> getAllParticulierParMc(String mc,int page,int size);
    public List<Particulier> getAllActif();
    public boolean trouve(Long id);
    public int addParticulierToUser(String login,Long id);
    public List<Particulier> particulierActif();
    public Page<Particulier> getAllParRole(String role,int page,int size);
    public boolean activeParticulier(Long id);
    public Page<Particulier> ParticulierParDate(LocalDate date,int page,int size);
    public boolean desactiveParticulier(Long id);
    public Particulier getParticulier(Long id);

}
