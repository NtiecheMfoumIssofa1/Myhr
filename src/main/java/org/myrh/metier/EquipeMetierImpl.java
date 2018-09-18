package org.myrh.metier;

import java.util.List;

import org.myrh.dao.EquipeRepository;
import org.myrh.entities.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EquipeMetierImpl  implements EquipeMetier{
	@Autowired
	private EquipeRepository equipeRepository;

	@Override
	public Equipe saveEquipe(Equipe e) {
			e.setEtat(true);
		return equipeRepository.save(e);
	}

	@Override
	public Equipe updateEquipe(Long id, Equipe e) {
		e.setId(id);
		e.setEtat(true);
		return equipeRepository.save(e);
	}

	@Override
	public boolean deleteEquipe(Long id) {
		equipeRepository.deleteEquipe(id);
		return true;
	}

	@Override
	public List<Equipe> getAllequipe() {
		// TODO Auto-generated method stub
		return equipeRepository.getAllEquipe();
	}

	@Override
	public Page<Equipe> getAllEquipeParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return equipeRepository.getEquipeParmc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public Equipe getEquipeParId(Long id) {
		// TODO Auto-generated method stub
		return equipeRepository.getOne(id);
	}

}
