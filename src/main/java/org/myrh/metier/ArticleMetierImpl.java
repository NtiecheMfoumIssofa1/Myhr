package org.myrh.metier;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.myrh.dao.ArticleRepository;
import org.myrh.dao.CategorieArticleRepository;
import org.myrh.entities.Article;
import org.myrh.entities.CategorieArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class ArticleMetierImpl implements ArticleMetier{
	@Autowired
	private ArticleRepository aricleRepository;
	@Autowired
	private CategorieArticleRepository  categorieArticle;

	@Override
	public Article saveArticle(Article a, Long idCat) {
		if(categorieArticle.trouveId(idCat)==null)
			return null;
		else{
			CategorieArticle c=categorieArticle.getOne(idCat);
			a.setCategorieArticle(c);
			//insertion automatique de la date
			Date date= new Date();
			//convertion en localDateTime
			  LocalDateTime localDateTime=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				//convertion en localDate
			  LocalDate localDate=localDateTime.toLocalDate();
				a.setDatePublication(localDate);
			return aricleRepository.save(a);
		}
		
	}

	@Override
	public Article updateArticle(Long idCat, Long idArt, Article a) {
		if((categorieArticle.trouveId(idCat)==null)||trouveId(idArt)==false) 
			return null;
		else{
			CategorieArticle c=categorieArticle.getOne(idCat);
			a.setCategorieArticle(c);
			a.setId(idArt);
			return aricleRepository.save(a);
		}
	}

	@Override
	public boolean ActiverArticle(Long idArt) {
		if(trouveId(idArt)==false)
			return false;
		else{
		
			//insertion automatique de la date
			Date date= new Date();
			//convertion en localDateTime
			  LocalDateTime localDateTime=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				//convertion en localDate
			  LocalDate localDate=localDateTime.toLocalDate();
			  Article a = aricleRepository.getOne(idArt);
			  a.setDatePublication(localDate);
			  a.setDateSuppression(null);
				aricleRepository.activerArticle(idArt);
			return true;
		}
	}

	@Override
	public boolean DesactiverArticle(Long idArt) {
		if(trouveId(idArt)==false)
			return false;
		else{
			
			Date date= new Date();
			//convertion en localDateTime
			  LocalDateTime localDateTime=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				//convertion en localDate
			  LocalDate localDate=localDateTime.toLocalDate();
			  Article a = aricleRepository.getOne(idArt);
			  a.setDatePublication(null);
			  a.setDateSuppression(localDate);
			  aricleRepository.desactiverArticle(idArt);
			return true;
		}
	}

	@Override
	public List<Article> getAllArticle() {
		// TODO Auto-generated method stub
		return aricleRepository.getAllArticle();
	}

	@Override
	public Page<Article> getAllParMc(String mc, int page,int size) {
		// TODO Auto-generated method stub
		return aricleRepository.getAllArticleParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public Page<Article> getAllParDatePub(LocalDate date,int page,int size) {
		// TODO Auto-generated method stub
		return aricleRepository.getAllArticleParDatePub(date,new PageRequest(page, size));
	}

	@Override
	public Page<Article> getAllParDateSup(LocalDate date,int page,int size) {
		// TODO Auto-generated method stub
		return aricleRepository.getAllArticleParDateSup(date,new PageRequest(page, size));
	}

	@Override
	public boolean trouveId(Long id) {
		if(aricleRepository.touveId(id)==null)
			return false;
		else return true;
	}

	@Override
	public Page<Article> getAllParCategorie(Long idCat,int page,int size) {
		if(categorieArticle.trouveId(idCat)==null)
			return null;
		else{
			return aricleRepository.getAllArticleParCat(idCat, new PageRequest(page, size));
		}
		
	}

	@Override
	public Article getArticle(Long id) {
		// TODO Auto-generated method stub
		return aricleRepository.getOne(id);
	}

	@Override
	public BufferedImage decoderStringToImage(String image) throws Exception {
			BufferedImage images=null;
			ByteArrayInputStream bis=new ByteArrayInputStream(Base64.getDecoder().decode(image));
			images=ImageIO.read(bis);
			bis.close();
		return images;
	}

}
