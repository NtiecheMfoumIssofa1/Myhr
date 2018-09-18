package org.myrh.metier;

import java.util.List;

import org.myrh.dao.MissionRepository;
import org.myrh.entities.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MissionMetierimpl  implements MissionMetier{
	@Autowired
	private MissionRepository missionRepository;
	@Override
	public Mission saveEquipe(Mission m) {
		m.setEtat(true);
		return missionRepository.save(m);
	}

	@Override
	public Mission updateEquipe(Long id, Mission m) {
		m.setId(id);
		m.setEtat(true);
		return missionRepository.save(m);
	}

	@Override
	public boolean deleteEquipe(Long id) {
		missionRepository.deleteMission(id);
		return true;
	}

	@Override
	public List<Mission> getAllequipe() {
		// TODO Auto-generated method stub
		return missionRepository.getAllMission();
	}

	@Override
	public Page<Mission> getAllEquipeParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return missionRepository.getMissionPArMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public Mission getEquipeParId(Long id) {
		// TODO Auto-generated method stub
		return missionRepository.getOne(id);
	}

}
