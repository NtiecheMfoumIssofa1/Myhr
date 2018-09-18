package org.myrh.metier;

import java.util.List;

import org.myrh.entities.Equipe;
import org.springframework.data.domain.Page;

public interface EquipeMetier {
	public Equipe saveEquipe(Equipe e);
	public Equipe updateEquipe(Long id,Equipe e);
	public boolean deleteEquipe(Long id);
	public List<Equipe> getAllequipe();
	public Page<Equipe> getAllEquipeParMc(String mc, int page, int size);
	public Equipe getEquipeParId(Long id);
	

}
