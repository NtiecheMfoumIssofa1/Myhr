package org.myrh.metier;

import java.util.List;

import org.myrh.dao.ServiceCategorieRepository;
import org.myrh.entities.ServiceCategorie;
import org.myrh.entities.ServiceProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class ServiceCategorieMetierImpl  implements ServiceCategorieMetier{
 @Autowired
	private ServiceCategorieRepository serviceRepository;
	@Override
	public ServiceCategorie saveEquipe(ServiceCategorie s) {
		s.setEtat(true);
		return serviceRepository.save(s);
	}

	@Override
	public ServiceCategorie updateEquipe(Long id, ServiceCategorie s) {
		s.setId(id);
		s.setEtat(true);
		return serviceRepository.save(s);
	}

	@Override
	public boolean deleteEquipe(Long id) {
		serviceRepository.deleteService(id);
		return true;
	}

	@Override
	public List<ServiceCategorie> getAllequipe() {
		// TODO Auto-generated method stub
		return serviceRepository.getAllService();
	}

	@Override
	public Page<ServiceCategorie> getAllEquipeParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return serviceRepository.getAllServiceparMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public ServiceCategorie getEquipeParId(Long id) {
		// TODO Auto-generated method stub
		return serviceRepository.getOne(id);
	}

	@Override
	public List<ServiceProduit> getProduitParCat(Long id) {
		// TODO Auto-generated method stub
		return serviceRepository.getAllProduit(id);
	}

}
