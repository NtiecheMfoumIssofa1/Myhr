package org.myrh.dao;

import java.util.List;

import org.myrh.entities.Article;
import org.myrh.entities.CategorieArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CategorieArticleRepository extends JpaRepository<CategorieArticle, Long>{
	@Query("select c.idCategorie from CategorieArticle c where c.etat=true and c.idCategorie=:x")
	public Long trouveId(@Param("x")Long id);
	@Transactional
	@Modifying
	@Query("update CategorieArticle c set c.etat=false where c.idCategorie=:x")
	public void deleteCategorie(@Param("x")Long id);
	@Query("select c from CategorieArticle c where c.etat=true")
	public List<CategorieArticle> getAllCat();
	@Query("select c from CategorieArticle c where c.etat=true and c.libelle like :x")
	public Page<CategorieArticle> getCatParMc(@Param("x")String mc,Pageable pageable);
	@Query("select count(a.id) from Article a where a.categorieArticle.idCategorie=:x")
	public Long getArticleParCat(@Param("x")Long idCat);

}
