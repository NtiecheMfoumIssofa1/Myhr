package org.myrh.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.myrh.entities.Article;
import org.myrh.metier.ArticleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")//a}
public class ArticleRestService {
	@Autowired
	private ArticleMetier articleMetier;	
	@RequestMapping(value="/Article/{idCat}",  
										produces = {MediaType.APPLICATION_JSON_VALUE, 
															MediaType.APPLICATION_XML_VALUE},
										method=RequestMethod.POST)
	public Article saveArticle( @PathVariable Long idCat,
													@RequestParam MultipartFile pdf,
													@RequestParam MultipartFile image,
													@RequestParam(name="nomArticle") String nomArticle,
													  @RequestParam(name="contenu") String contenu) throws IOException {
		
		Article a=new Article();
		a.setImage(image.getOriginalFilename()); 
		a.setPdf(pdf.getOriginalFilename());
		a.setNomArticle(nomArticle);      
		a.setContenu(contenu);
		
		
		return articleMetier.saveArticle(a, idCat); 
		
	}
	
	
	@RequestMapping(value="/Article/{idCat}/{idArt}",method=RequestMethod.PUT)
	public Article updateArticle(@PathVariable Long idCat, @PathVariable Long idArt, 
														@RequestBody Article a, MultipartFile file) {
		
	
		return articleMetier.updateArticle(idCat, idArt, a);
	}
	@RequestMapping(value="/ActiverArticle/{idArt}",method=RequestMethod.DELETE)  
	public boolean ActiverArticle(@PathVariable Long idArt) {
		return articleMetier.ActiverArticle(idArt);
	}
	@RequestMapping(value="/DesactiverArticle/{idArt}",method=RequestMethod.DELETE)    
	public boolean DesactiverArticle(@PathVariable Long idArt) {
		return articleMetier.DesactiverArticle(idArt);
	}
	@RequestMapping(value="/Article",method=RequestMethod.GET)
	public List<Article> getAllArticle() {
		return articleMetier.getAllArticle();
	}
	@RequestMapping(value="/ArticleParMc",method=RequestMethod.GET)
	public Page<Article> getAllParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		
		return articleMetier.getAllParMc(mc, page, size);
	}
	@RequestMapping(value="/ArticleParCat/{idCat}",method=RequestMethod.GET)
	public Page<Article> getAllParCategorie(@PathVariable Long idCat, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return articleMetier.getAllParCategorie(idCat, page, size);
	}
	@RequestMapping(value="/ArticleParDatePub",method=RequestMethod.GET)
	public Page<Article> getAllParDatePub( 
			@RequestParam(name="date",defaultValue="")String date,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size) {
		LocalDate dates=LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return articleMetier.getAllParDatePub(dates,page, size);  
	}
	@RequestMapping(value="/ArticleParDateSup",method=RequestMethod.GET)
	public Page<Article> getAllParDateSup(
			@RequestParam(name="date",defaultValue="")String date,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size) {
		LocalDate dates=LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return articleMetier.getAllParDateSup(dates,page, size);
	}
	@RequestMapping(value="/DecoderStringToImage",method=RequestMethod.GET)
	public BufferedImage decoderStringToImage(
											@RequestParam(name="image")String image) throws Exception {
		return articleMetier.decoderStringToImage(image);
	}
	@RequestMapping(value="/getArticle/{id}",method=RequestMethod.GET)
	public Article getArticle(@PathVariable Long id) {
		return articleMetier.getArticle(id);
	}
/*	
	 //recuperation de la photo
	 @RequestMapping(value="uploadImage",produces=MediaType.IMAGE_JPEG_VALUE)
	 @ResponseBody 
	 public byte[] uploadImage(@RequestParam(name="id") Long id) throws IOException{ 
		
		 	Article a=	articleMetier.getArticle(id);
		return IOUtils.toByteArray(new ByteArrayInputStream(a.getImages()));
	 }*/

}
