package org.myrh.dao;


import java.util.List;

import org.myrh.entities.Equipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface EquipeRepository  extends JpaRepository<Equipe, Long>{
	@Transactional
	@Modifying
	@Query("update Equipe e set e.etat=false where e.id=:x")
	public void deleteEquipe(@Param("x")Long id);
	@Query("select e from Equipe e where e.etat=true")
	public List<Equipe> getAllEquipe();
	@Query("select e from Equipe e where (e.nomEquipe like :x or e. prenomEquipe like :x or e.titreEquipe like :x or e.bibliographie like :x or e.urlLinkeldn like :x or e.urlFacebook like :x) and e.etat=true")
	public Page<Equipe> getEquipeParmc(@Param("x")String mc,Pageable pageable);

}
