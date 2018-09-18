package org.myrh.dao;

import java.time.LocalDate;
import java.util.List;

import org.myrh.entities.Particulier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ParticulierRepository extends JpaRepository<Particulier, Long>{
	@Transactional
	@Modifying
	@Query("update Particulier p set p.etat=false where p.id=:x")
	public void deleteParticulier(@Param("x")Long id);
	@Query("select p from Particulier p where p.etat=true")
	public List<Particulier> findAllParticulier();
	@Query("select p from Particulier p where p.etat=true and (p.firstName like :x or p.lastName like :x or p.entreprise like :x or p.fonction like :x)")
	public Page<Particulier> getParticulierParMc(@Param("x")String mc,Pageable pageable);
	@Query("select p from Particulier p where p.statut=true")
	public List<Particulier> ListParticulierActif();
	@Query("select p.id from Particulier p where p.id=:x")
	public Long trouveId(@Param("x")Long id);
	@Query("select p from Particulier p where p.etat=true and p.statut=true")
	public List<Particulier> getParticulierActif();
	@Query(" select p from Particulier p  where p.utilisateur.login in"
			+ "(select u.login from Utilisateur u join u.roles r where r.role=:x)")
	public Page<Particulier> getParticulierParRole(@Param("x")String role, Pageable pageable);
	@Transactional
	@Modifying
	@Query("update Particulier p set p.statut=true where p.id=:x")
	public void activeParticulier(@Param("x")Long id);
	@Transactional
	@Modifying
	@Query("update Particulier p set p.statut=false where p.id=:x")
	public void desactiveParticulier(@Param("x")Long id);
	@Query("select p from Particulier p where p.dateInscription=:x and p.etat=true ")
	public Page<Particulier> getParticulierPardate(@Param("x")LocalDate date,Pageable pageable);
	@Transactional
	@Modifying
	@Query("update Particulier p set p.utilisateur.login=:x,p.etat=true where p.id=:y")
	public int addParticulierToUser(@Param("x")String login,@Param("y")Long id);
	@Transactional
	@Modifying
	@Query("update Particulier p set p.utilisateur.login=null,p.etat=true where p.id=:y")
	public int removeParticulierToUser(@Param("y")String id);

}
