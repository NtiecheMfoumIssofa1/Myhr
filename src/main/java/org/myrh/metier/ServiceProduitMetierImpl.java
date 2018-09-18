package org.myrh.metier;

import java.time.LocalDate;
import java.util.List;

import org.myrh.dao.ServiceCategorieRepository;
import org.myrh.dao.ServiceProduitRepository;
import org.myrh.entities.ServiceCategorie;
import org.myrh.entities.ServiceProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class ServiceProduitMetierImpl   implements ServiceProduitMetier{
		@Autowired
	private ServiceCategorieRepository serviceCat;
		@Autowired
		private ServiceProduitRepository serviceProduit;
	@Override
	public ServiceProduit saveserviceProd(ServiceProduit s, Long ids) {
		ServiceCategorie c= serviceCat.getOne(ids);
		 s.setServiceCategorie(c);
		 s.setEtat(true);
		return serviceProduit.save(s);
	}

	@Override
	public ServiceProduit updateProduit(ServiceProduit s, Long idp, Long ids) {
		
		ServiceCategorie c= serviceCat.getOne(ids);
		 s.setServiceCategorie(c);
		 s.setIdp(idp);
		 s.setEtat(true);
		return serviceProduit.save(s);
	}

	@Override
	public boolean deleteProduit(Long id) {
		serviceProduit.deleteProduit(id);
		return true;
	}

	@Override
	public List<ServiceProduit> getAllProduit() {
		// TODO Auto-generated method stub
		return serviceProduit.getAll();
	}

	@Override
	public Page<ServiceProduit> getAllProduitParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return serviceProduit.getProduitParMc("%"+mc+"%", new PageRequest(page, size));
	}

	@Override
	public ServiceProduit getProduit(Long id) {
		// TODO Auto-generated method stub
		return serviceProduit.getOne(id);
	}

	@Override
	public Page<ServiceProduit> getProdReserve(LocalDate date,int page, int size) {
		// TODO Auto-generated method stub
		return serviceProduit.getProduitReservePardate(date, new PageRequest(page, size));
	}

}
