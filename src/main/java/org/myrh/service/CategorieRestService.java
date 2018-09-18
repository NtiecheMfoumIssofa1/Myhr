package org.myrh.service;

import java.util.List;

import org.myrh.entities.CategorieArticle;
import org.myrh.metier.CategorieArtMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CategorieRestService {
	@Autowired
	private CategorieArtMetier categorieArtMetier;
	
	@RequestMapping(value="/CategorieArt",method=RequestMethod.POST)
	public CategorieArticle saveCat(@RequestBody CategorieArticle c) {
		return categorieArtMetier.saveCat(c);
	}
	@RequestMapping(value="/CategorieArt/{id}",method=RequestMethod.PUT)
	public CategorieArticle updateCat(@PathVariable Long id,@RequestBody CategorieArticle c) {
		return categorieArtMetier.updateCat(id, c);
	}
	@RequestMapping(value="/CategorieArt/{id}",method=RequestMethod.DELETE)
	public boolean deleteCat(@PathVariable Long id) {
		return categorieArtMetier.deleteCat(id);
	}
	@RequestMapping(value="/CategorieArtId/{idCat}",method=RequestMethod.GET)
	public CategorieArticle getCat(@PathVariable Long idCat) {
		return categorieArtMetier.getCat(idCat);
	}
	@RequestMapping(value="/CategorieArt",method=RequestMethod.GET)
	public List<CategorieArticle> getAllCat() {
		return categorieArtMetier.getAllCat();
	}
	@RequestMapping(value="/CategorieArtParMc",method=RequestMethod.GET)
	public Page<CategorieArticle> getAllCatParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return categorieArtMetier.getAllCatParMc(mc, page, size);
	}

}
