package org.myrh.dao;

import java.util.List;

import org.myrh.entities.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepository extends JpaRepository<Role, String> {
	@Transactional
	@Modifying
	@Query("update Role r set r.etat=false where r.role=:x")
	public void deleteRole(@Param("x")String role);
	@Query("select r from Role r where r.etat=true")
	public List<Role> findAllRole();
	@Query("select r from Role r where r.etat=true and r.role like :x")
	public Page<Role> getRoleParMc(@Param("x")String mc,Pageable pageable);
	@Query("select r from Role r where r.etat=true")
	public List<Role> ListRoleActif();
	@Query("select r.role from Role r where r.role=:x")
	public String trouveId(@Param("x")String role);
	@Query("select r.role from Role r where r.etat=true")
	public Long roleActif();
	@Query("select r from Role r where r.etat=true and r.role=:x")
	public Role getRole(@Param("x")String id);

}
