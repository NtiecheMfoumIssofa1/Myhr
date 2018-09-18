package org.myrh.service;

import java.util.List;

import org.myrh.entities.Role;
import org.myrh.metier.RoleMetier;
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
public class RoleRestService {
	@Autowired
	private RoleMetier roleMetier;

	@RequestMapping(value="/role",method=RequestMethod.POST)
	public Role saveRole(@RequestBody Role r) {
		return roleMetier.saveRole(r);
	}
	@RequestMapping(value="/role/{idRole}",method=RequestMethod.PUT)
	public Role updateRole(@PathVariable String idRole,@RequestBody Role r) {
		return roleMetier.updateRole(idRole, r);
	}
	@RequestMapping(value="/role/{idRole}",method=RequestMethod.DELETE)
	public boolean deleteRole(@PathVariable String idRole) {
		return roleMetier.deleteRole(idRole);
	}
	@RequestMapping(value="/role",method=RequestMethod.GET)
	public List<Role> getAllRole() {
		return roleMetier.getAllRole();
	}
	@RequestMapping(value="/roleParMc",method=RequestMethod.GET)
	public Page<Role> getAllRoleParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return roleMetier.getAllRoleParMc(mc, page, size);
	}
	@RequestMapping(value="/roleActif",method=RequestMethod.GET)
	public List<Role> getAllActif() {
		return roleMetier.getAllActif();
	}
	@RequestMapping(value="/roleId/{id}",method=RequestMethod.GET)
	public Role getRole(@PathVariable String id) {
		return roleMetier.getRole(id);
	}

}
