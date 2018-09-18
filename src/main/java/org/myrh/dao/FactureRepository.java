package org.myrh.dao;

import java.time.LocalDate;
import java.util.List;

import org.myrh.entities.Facture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface FactureRepository extends JpaRepository<Facture, String>{
	@Query("select f.idF from Facture f where f.idF=:x and f.etat=true")
	public String trouveid(@Param("x")String id);
	@Transactional
	@Modifying
	@Query("update Facture f set f.etat=false where f.idF=:x")
	public int deleteFacture(@Param("x")String id);
	@Query("select f from Facture f where f.etat=true")
	public List<Facture> getAllFacture();
	@Query("select f from Facture f where f.etat=true and f.designation like :x")
	public Page<Facture> getFactureParMc(@Param("x")String mc,Pageable pageable);
	@Query("select f from Facture f where f.etat=true and f.date=:x")
	public Page<Facture> getFactureParDate(@Param("x")LocalDate date,Pageable pageable);
	@Query("select sum(a.coutAbonnement) from Abonnement a, Utilisateur u, Particulier p"
			+ " where a.libelleAbonnement=:x"
			+ " and u.login=:y"
			+ " and p.utilisateur.login=u.login")
	public List<Facture> genererFactureParticulier(@Param("x")String abonnement,@Param("y")String login);
	@Query("select sum(a.coutAbonnement) from Abonnement a, Utilisateur u, Entreprise e"
			+ " where a.libelleAbonnement=:x"
			+ " and u.login=:y"
			+ " and e.utilisateur.login=u.login")
	public List<Facture> genererFactureEntreprise(@Param("x")String abonnement,@Param("y")String login);
	@Transactional
	@Modifying
	@Query("update Facture f set f.paiement=true where f.idF=:x")
	public int paiementFacture(@Param("x")String id);
}
