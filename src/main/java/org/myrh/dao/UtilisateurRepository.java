package org.myrh.dao;

import java.util.List;



import org.myrh.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String>{
	@Transactional
	@Modifying
	@Query("update Utilisateur u set u.etat=false where u.login=:x")
	public void deleteUser(@Param("x")String login);
	@Query("select u from Utilisateur u where u.etat=true and u.statut=true")
	public List<Utilisateur> findAllUser();
	@Query("select u from Utilisateur u where u.etat=true and u.login like :x")
	public Page<Utilisateur> getUserParMc(@Param("x")String mc,Pageable pageable);
	@Query("select u from Utilisateur u where u.statut=true")
	public List<Utilisateur> ListUserActif();
	@Query("select u.login from Utilisateur u where u.login=:x")
	public String trouveId(@Param("x")String login);
	@Query("select u.login from Utilisateur u where u.etat=true and u.login=:x")
	public String UserActif(@Param("x")String login);
	@Query(" select u from Utilisateur u join u.roles r where r.role=:x")
	public List<Utilisateur> getUserParRole(@Param("x")String idRole);
	@Transactional
	@Modifying
	@Query("update Utilisateur u set u.etat=true,u.statut=true where u.login=:x")
	public void activeUser(@Param("x")String login);
	@Transactional
	@Modifying
	@Query("update Utilisateur u set u.etat=true, u.statut=true,u.abonnement.libelleAbonnement=:y where u.login=:x  ")
	public void addClassicToUser(@Param("x")String login,@Param("x")String y);

}
