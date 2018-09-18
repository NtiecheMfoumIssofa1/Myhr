package org.myrh.service;

import java.util.List;

import org.myrh.entities.Mission;
import org.myrh.metier.MissionMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class MissionRestService {
	@Autowired
	private MissionMetier  missionMetier;
@RequestMapping(value="/Mission",method=RequestMethod.POST)
	public Mission saveEquipe(@RequestBody Mission m) {
		return missionMetier.saveEquipe(m);
	}
@RequestMapping(value="/Mission/{id}",method=RequestMethod.PUT)
	public Mission updateEquipe(@PathVariable Long id, @RequestBody Mission m) {
		return missionMetier.updateEquipe(id, m);
	}
@RequestMapping(value="/Mission/{id}",method=RequestMethod.DELETE)
	public boolean deleteEquipe(@PathVariable Long id) {
		return missionMetier.deleteEquipe(id);
	}
@RequestMapping(value="/Mission",method=RequestMethod.GET)
	public List<Mission> getAllequipe() {
		return missionMetier.getAllequipe();
	}
@RequestMapping(value="/MissionParMc",method=RequestMethod.GET)
	public Page<Mission> getAllEquipeParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) { 
		return missionMetier.getAllEquipeParMc(mc, page, size);
	}
@RequestMapping(value="/MissionId/{id}",method=RequestMethod.GET)
	public Mission getEquipeParId(@PathVariable Long id) {
		return missionMetier.getEquipeParId(id);
	}

}
