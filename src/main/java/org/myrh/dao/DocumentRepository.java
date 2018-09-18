package org.myrh.dao;

import java.time.LocalDate;
import java.util.List;

import org.myrh.entities.Document;
import org.myrh.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DocumentRepository extends JpaRepository<Document, String>{
	@Query("select d.intitule from Document d where d.intitule=:x")
	public String trouveId(@Param("x")String intitule);
	@Transactional
	@Modifying
	@Query("update Document d set d.etat=false where d.intitule=:x")
	public int deleteDoc(@Param("x")String intitule);
	@Transactional
	@Modifying
	@Query("update Document d set d.uploder=true where d.intitule=:x")
	public int uploaderDoc(@Param("x")String intitule);
	@Transactional
	@Modifying
	@Query("update Document d set d.uploder=false where d.intitule=:x")
	public int downloaderDoc(@Param("x")String intitule);
	@Transactional
	@Modifying
	@Query("update Document d set d.archiver=false where d.intitule=:x")
	public int archiverDoc(@Param("x")String intitule);
	@Transactional
	@Modifying
	@Query("update Document d set d.archiver=true where d.intitule=:x")
	public int desarchiverDoc(@Param("x")String intitule);
	@Query("select d from Document d where d.etat=true")
	public List<Document> getAllDoc();
	@Query("select d from Document d where d.etat=true and (d.intitule like :x or d.lienTelechargement like :x)")
	public Page<Document> getAllParMc(@Param("x")String mc, Pageable pageable);
	@Query("select d from Document d where d.etat=true and d.dateTelechargement=:x")
	public List<Document> getAllParDateTelechargement(@Param("x")LocalDate date);
	@Query("select d from Document d where d.etat=true and d.archiver=true")
	public Page<Document> getAllDocArchive(Pageable pageable);
	@Query("select d from Document d where d.etat=true and d.uploder=true")
	public Page<Document> getAllDocUploder(Pageable pageable);
	@Query("select u from Utilisateur u join u.documents d where d.intitule=:x and d.dateTelechargement=:y")
	public Page<Utilisateur> getUserParDateTelechargement(@Param("y")LocalDate date,@Param("x")String intitule,Pageable pageable);

}
