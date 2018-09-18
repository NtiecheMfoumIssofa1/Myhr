package org.myrh.dao;

import java.util.List;

import org.myrh.entities.Profil;
import org.myrh.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProfilRepository extends JpaRepository<Profil, Long>{
	@Transactional
	@Modifying
	@Query("update Profil p set p.etat=false where p.idprofil=:x")
	public void deleteProfil(@Param("x")Long idProfil);
	@Query("select p from Profil p where p.etat=true")
	public List<Profil> findAllProfil();
	@Query("select p from Profil p where p.etat=true and p.libelleProfil like :x")
	public Page<Profil> getProfilParMc(@Param("x")String mc,Pageable pageable);
	@Query("select p.idprofil from Profil p where p.idprofil=:x and p.etat=true")
	public Long trouveId(@Param("x")Long idProfil);
	@Query("select p from Profil p where p.etat=true and p.idprofil=:x")
	public Profil ProfilActif(@Param("x")Long idProfil);
	@Query(" select u from Utilisateur u  where u.profil.idprofil=:x")
	public List<Utilisateur> getUserParProfil(@Param("x")Long idprofil);
	@Transactional
	@Modifying
	@Query("update Utilisateur u set u.profil.idprofil=:x,u.etat=true where u.login=:y")
	public int addUserToProfil(@Param("x")Long idProfil,@Param("y")String idUser);
	@Transactional
	@Modifying
	@Query("update Utilisateur u set u.profil.idprofil=null,u.etat=true where u.login=:y")
	public int removeUserToProfil(@Param("y")String idUser);
	

}
