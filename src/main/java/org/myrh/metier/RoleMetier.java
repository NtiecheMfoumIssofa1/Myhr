package org.myrh.metier;

import java.util.List;

import org.myrh.entities.Role;
import org.springframework.data.domain.Page;

public interface RoleMetier {
	public Role saveRole(Role r);
	public Role updateRole(String role,Role r);
	public boolean deleteRole(String role);
    public List<Role> getAllRole();
    public Page<Role> getAllRoleParMc(String mc,int page,int size);
    public List<Role> getAllActif();
    public boolean trouve(String role);
    public Role getRole(String id);
 

}
