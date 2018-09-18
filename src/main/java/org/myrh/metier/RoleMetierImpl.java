package org.myrh.metier;

import java.util.List;

import org.myrh.dao.RoleRepository;
import org.myrh.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class RoleMetierImpl implements RoleMetier{
	@Autowired
	private RoleRepository rolerepository;
	@Override
	public Role saveRole(Role r) {
		r.setEtat(true);
		return rolerepository.save(r);
	}

	@Override
	public Role updateRole(String idRole, Role r) {
		if(trouve(idRole)==false)
			return null;
		else{
			r.setEtat(true);
			//r.setIdRole(idRole);
			return rolerepository.save(r);	
		}
	}

	@Override
	public boolean deleteRole(String idRole) {
		if(trouve(idRole)==false)
			return false;
		else{
			rolerepository.deleteRole(idRole);
			return true;
		}
		
	}

	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return rolerepository.findAllRole();
	}

	@Override
	public Page<Role> getAllRoleParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return rolerepository.getRoleParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public List<Role> getAllActif() {
		// TODO Auto-generated method stub
		return rolerepository.ListRoleActif();
	}

	@Override
	public boolean trouve(String role) {
		if(rolerepository.trouveId(role)==null)
		return false;
		else return true;
	}

	@Override
	public Role getRole(String id) {
		if(rolerepository.getRole(id)==null)
			return null;
		else return rolerepository.getRole(id);
	}

}
