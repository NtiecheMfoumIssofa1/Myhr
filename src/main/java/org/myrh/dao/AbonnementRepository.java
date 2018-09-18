package org.myrh.dao;

import java.util.List;

import org.myrh.entities.Abonnement;
import org.myrh.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement, String>{
	@Query("select a.libelleAbonnement from Abonnement a where a.libelleAbonnement=:x")
	public String trouveId(@Param("x")String abonnement);
	@Transactional
	@Modifying
	@Query("update Abonnement a set a.etat=false where a.libelleAbonnement=:x")
	public int deleteAbonnement(@Param("x")String abonnement);
	@Query("select a from Abonnement a where a.etat=true")
	public List<Abonnement> getAllAbonnement();
	@Query("select a from Abonnement a where a.libelleAbonnement like :x")
	public Page<Abonnement> getAllParMc(@Param("x")String mc,Pageable pageable);
	@Query("select a from Abonnement a order by a.coutAbonnement")
	public List<Abonnement> getAllAbonnementParCout();
	@Transactional
	@Modifying
	@Query("update Abonnement a set a.desactiver=false where a.libelleAbonnement=:x")
	public int desactiverA(@Param("x")String abonnement);
	@Query("select distinct e.secteurActivite,p.firstName "
			+ "from Utilisateur u, Particulier p, Entreprise e"
			+ " where u.abonnement.libelleAbonnement=:x"
			+ "  and  e.utilisateur.login = u.login"
			+ "  or p.utilisateur.login = u.login"
			)//
	public List<Object> getUserParAbonnement(@Param("x")String abonnement);
	@Transactional
	@Modifying 
	@Query("update Particulier p set p.utilisateur.login =(select u.login from Utilisateur u where u.abonnement.libelleAbonnement=:x)")
	public int upgradeEtdowngradeAParticulier(@Param("x")String abonnement);
	@Transactional
	@Modifying 
	@Query("update Particulier p set p.utilisateur.login=null where p.id=:x")
	public int resilierAParticulier(@Param("x")Long id);
	@Transactional
	@Modifying 
	@Query("update Entreprise e set e.utilisateur.login =(select u.login from Utilisateur u where u.abonnement.libelleAbonnement=:x)")
	public int upgradeEtdowngradeAEntreprise(@Param("x")String abonnement);
	@Transactional
	@Modifying 
	@Query("update Entreprise e set e.utilisateur.login=null where e.id=:x")
	public int resilierAEntreprise(@Param("x")Long id);
	@Transactional
	@Modifying 
	@Query("update Abonnement a set a.desactiver=true where a.libelleAbonnement=:x")
	public int activerA(@Param("x")String abonnement);
	@Transactional
	@Modifying 
	@Query("update Abonnement a set a.suspendre=false where a.libelleAbonnement=:x")
	public int suspendre(@Param("x")String abonnement);
	@Transactional
	@Modifying 
	@Query("update Abonnement a set a.suspendre=true where a.libelleAbonnement=:x")
	public int reactiverA(@Param("x")String abonnement);
	@Transactional
	@Modifying 
	@Query("update Utilisateur u set u.abonnement.libelleAbonnement=:x where u.login=:y")
	public int addAbonnementToUser(@Param("x")String abonnement,@Param("y")String login);

}
