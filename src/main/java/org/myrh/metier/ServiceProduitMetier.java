package org.myrh.metier;

import java.time.LocalDate;
import java.util.List;

import org.myrh.entities.ServiceProduit;
import org.springframework.data.domain.Page;

public interface ServiceProduitMetier {
	
	public ServiceProduit saveserviceProd(ServiceProduit s, Long ids);
	public ServiceProduit updateProduit(ServiceProduit s, Long idp, Long ids);
	public boolean deleteProduit(Long id);
	public List<ServiceProduit> getAllProduit();
	public Page<ServiceProduit> getAllProduitParMc(String mc, int page,int size);
	public ServiceProduit getProduit(Long id);
	public Page<ServiceProduit> getProdReserve(LocalDate date,int page, int size);

}
