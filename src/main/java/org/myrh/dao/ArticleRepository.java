package org.myrh.dao;

import java.time.LocalDate;
import java.util.List;

import org.myrh.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ArticleRepository extends JpaRepository<Article, Long>{
	@Query("select a.id from Article a where a.id=:x")
	public Long touveId(@Param("x")Long id);
	@Transactional
	@Modifying
	@Query("update Article a set a.etat=true where a.id=:x")
	public int activerArticle(@Param("x")Long id);
	@Transactional
	@Modifying
	@Query("update Article a set a.etat=false where a.id=:x")
	public int desactiverArticle(@Param("x")Long id);
	@Query("select a from Article a ")
	public List<Article> getAllArticle();
	@Query("select a from Article a where a.pdf like :x or a.contenu like :x or a.image like :x or a.nomArticle like :x")
	public Page<Article> getAllArticleParMc(@Param("x")String mc,Pageable pageable);
	@Query("select a from Article a where a.categorieArticle.idCategorie=:x ")
	public Page<Article> getAllArticleParCat(@Param("x")Long id,Pageable pageable);
	@Query("select a from Article a where a.datePublication=:x and a.etat=true")
	public Page<Article> getAllArticleParDatePub(@Param("x")LocalDate date, Pageable pageable);
	@Query("select a from Article a where a.dateSuppression=:x and a.etat=false")
	public Page<Article> getAllArticleParDateSup(@Param("x")LocalDate date,Pageable pageable);
}
