package org.myrh.metier;


import java.util.List;

import org.myrh.entities.ServiceCategorie;
import org.myrh.entities.ServiceProduit;
import org.springframework.data.domain.Page;

public interface ServiceCategorieMetier {
	public ServiceCategorie saveEquipe(ServiceCategorie s);
	public ServiceCategorie updateEquipe(Long id,ServiceCategorie s);
	public boolean deleteEquipe(Long id);
	public List<ServiceCategorie> getAllequipe();
	public Page<ServiceCategorie> getAllEquipeParMc(String mc, int page, int size);
	public ServiceCategorie getEquipeParId(Long id);
	public List<ServiceProduit> getProduitParCat(Long id);

}
