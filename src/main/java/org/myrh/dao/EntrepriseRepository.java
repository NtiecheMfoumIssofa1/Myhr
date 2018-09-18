package org.myrh.dao;

import java.time.LocalDate;
import java.util.List;

import org.myrh.entities.Entreprise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long>{
	@Transactional
	@Modifying
	@Query("update Entreprise e set e.etat=false where e.id=:x")
	public void deleteEntreprise(@Param("x")Long id);
	@Query("select e from Entreprise e where e.etat=true")
	public List<Entreprise> findAllEntreprise();
	@Query("select e from Entreprise e where (e.nom like :x or e.formeJuridique like :x or e.secteurActivite like :x or e.fonction like :x or e. nombreEmploye like :x or e.tailleEntreprise like :x or e.ville like :x ) and e.etat=true")
	public Page<Entreprise> getEntrepriseParMc(@Param("x")String mc,Pageable pageable);
	@Query("select e from Entreprise e where e.statut=true")
	public List<Entreprise> ListEntrepriseActif();
	@Query("select e.id from Entreprise e where e.id=:x")
	public Long trouveId(@Param("x")Long id);
	@Query("select e from Entreprise e where e.etat=true and e.statut=true")
	public List<Entreprise> getEntrepriseActif();
	@Query(" select e from Entreprise e  where e.utilisateur.login in"
			+ "(select u.login from Utilisateur u join u.roles r where r.role=:x)")
	public Page<Entreprise> getEntrepriseParRole(@Param("x")String role,Pageable pageable);
	@Transactional
	@Modifying
	@Query("update Entreprise e set e.statut=true where e.id=:x")
	public void activeEntreprise(@Param("x")Long id);
	@Transactional
	@Modifying
	@Query("update Entreprise e set e.statut=false where e.id=:x")
	public void desactiveEntreprise(@Param("x")Long id);
	@Query("select e from Entreprise e where e.dateInscription=:x")
	public Page<Entreprise> getEntreprisePardate(@Param("x")LocalDate date,Pageable pageable);
	@Transactional
	@Modifying
	@Query("update Entreprise e set e.utilisateur.login=:x,e.etat=true where e.id=:y")
	public int addEntrepriseToUser(@Param("x")String login,@Param("y")Long id);
	@Transactional
	@Modifying
	@Query("update Entreprise e set e.utilisateur.login=null,e.etat=true where e.id=:y")
	public int removeEntrepriseToUser(@Param("y")String id);


}
