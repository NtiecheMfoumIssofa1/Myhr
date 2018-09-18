package org.myrh.metier;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.myrh.entities.Article;
import org.springframework.data.domain.Page;

public interface ArticleMetier {
	public Article saveArticle(Article a,Long idCat);
	public Article updateArticle(Long idCat,Long idArt, Article a);
	public boolean ActiverArticle(Long idArt);
	public boolean DesactiverArticle(Long idArt);
	public List<Article> getAllArticle();
	public Page<Article> getAllParMc(String mc, int page,int size);
	public Page<Article> getAllParCategorie(Long idCat,int page,int size);
	public Page<Article> getAllParDatePub(LocalDate date,int page,int size);
	public Page<Article> getAllParDateSup(LocalDate date,int page,int size);
	public boolean trouveId(Long id);
	public Article getArticle(Long id);
	public BufferedImage decoderStringToImage(String image) throws Exception;

}
