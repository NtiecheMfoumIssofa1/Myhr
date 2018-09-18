package org.myrh.metier;


import java.util.List;

import org.myrh.entities.Mission;
import org.springframework.data.domain.Page;

public interface MissionMetier {
	public Mission saveEquipe(Mission m);
	public Mission updateEquipe(Long id,Mission m);
	public boolean deleteEquipe(Long id);
	public List<Mission> getAllequipe();
	public Page<Mission> getAllEquipeParMc(String mc, int page, int size);
	public Mission getEquipeParId(Long id);


}
