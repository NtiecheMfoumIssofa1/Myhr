package org.myrh.dao;

import java.time.LocalDate;
import java.util.List;

import org.myrh.entities.ServiceProduit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ServiceProduitRepository  extends JpaRepository<ServiceProduit, Long>{
	@Transactional
	@Modifying
	@Query("update ServiceProduit s set  s.etat=false where s.id=:x")
	public  void deleteProduit(@Param("x")Long id);
	@Query(" select s from ServiceProduit s where s.etat=true")
	public List<ServiceProduit> getAll();
	@Query(" select s from ServiceProduit s where (s.libelle like :x or s.description like :x) and s.etat=true")
	public Page<ServiceProduit> getProduitParMc(@Param("x")String mc, Pageable pageable);
	@Query("select p from ServiceProduit p join p.reservations r  where r.dateDebut like :x")
	public Page<ServiceProduit> getProduitReservePardate(@Param("x")LocalDate date,Pageable pageable);

}
