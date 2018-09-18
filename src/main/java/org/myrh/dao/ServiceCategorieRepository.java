package org.myrh.dao;


import java.util.List;

import org.myrh.entities.ServiceCategorie;
import org.myrh.entities.ServiceProduit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface ServiceCategorieRepository extends JpaRepository<ServiceCategorie,Long>{
	@Transactional
	@Modifying
	@Query("update ServiceCategorie s set s.etat=false where s.id=:x")
	public void deleteService(@Param("x")Long id);
	@Query("select s from ServiceCategorie s where s.etat =true")
	public List<ServiceCategorie> getAllService();
	@Query("select s from ServiceProduit s where s.serviceCategorie.id=:x and s.etat =true")
	public List<ServiceProduit> getAllProduit(@Param("x")Long id);
	@Query("select s from ServiceCategorie s where (s.description like :x or s.source like :x) and s.etat=true")
	public Page<ServiceCategorie> getAllServiceparMc(@Param("x")String mc, Pageable pageable);

}
