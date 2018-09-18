package org.myrh.metier;

import java.util.List;

import org.myrh.dao.CategorieArticleRepository;
import org.myrh.entities.CategorieArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class CategorieArtMetierImpl implements CategorieArtMetier{
	@Autowired
  public CategorieArticleRepository categorieRepository;
	@Override
	public CategorieArticle saveCat(CategorieArticle c) {
		c.setEtat(true);
		return categorieRepository.save(c);
	}

	@Override
	public CategorieArticle updateCat(Long id, CategorieArticle c) {
		if(trouveCat(id)==false)
			return null;
		else{
			c.setIdCategorie(id);
			c.setEtat(true);
		return	categorieRepository.save(c);
		}
	}

	@Override
	public boolean deleteCat(Long id) {
		if(trouveCat(id)==false||(categorieRepository.getArticleParCat(id)!=0))
			return false;
		else{
			categorieRepository.deleteCategorie(id);
			return true;
		}
		
	}

	@Override
	public CategorieArticle getCat(Long idCat) {
		// TODO Auto-generated method stub
		return categorieRepository.getOne(idCat);
	}

	@Override
	public List<CategorieArticle> getAllCat() {
		// TODO Auto-generated method stub
		return categorieRepository.getAllCat();
	}

	@Override
	public Page<CategorieArticle> getAllCatParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return categorieRepository.getCatParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public boolean trouveCat(Long id) {
		if(categorieRepository.trouveId(id)==null)
			return false;
		else return true;
	}

}
