package org.myrh.metier;

import java.util.List;

import org.myrh.entities.CategorieArticle;
import org.springframework.data.domain.Page;

public interface CategorieArtMetier {
	public CategorieArticle saveCat(CategorieArticle c);
	public CategorieArticle updateCat(Long id,CategorieArticle c);
	public boolean deleteCat(Long id);
	public boolean trouveCat(Long id);
	public CategorieArticle getCat(Long idCat);
	public List<CategorieArticle> getAllCat();
	public Page<CategorieArticle> getAllCatParMc(String mc,int page,int size);
	
}
