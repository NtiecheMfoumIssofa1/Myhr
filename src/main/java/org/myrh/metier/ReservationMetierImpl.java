package org.myrh.metier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.myrh.dao.ReservationRepository;
import org.myrh.dao.ServiceProduitRepository;
import org.myrh.dao.UtilisateurRepository;
import org.myrh.entities.Reservation;
import org.myrh.entities.ServiceProduit;
import org.myrh.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ReservationMetierImpl implements ReservationMetier{
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private UtilisateurRepository userRepository;
	@Autowired
	private ServiceProduitRepository produitRepository;
	@Override
	public void saveReservation(Reservation r) {
		
			Date date= new Date();
			//convertion en localDateTime
			  LocalDateTime localDateTime=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				//convertion en localDate
			  LocalDate localDate=localDateTime.toLocalDate();
			r.setEtat(true);
			r.setStatut("Debut");
			  r.setDateDebut(localDate);
			 reservationRepository.save(r);
	
	}

	@Override
	public Reservation updateReservation(Reservation r, Long id) {
		if((reservationRepository.trouveid(id)==null))
			return null;
		else{
			r.setEtat(true);
			r.setStatut("Debut");
			r.setId(id);
			return reservationRepository.save(r);
		}
	}

	@Override
	public boolean deleteReservation(Long id) {
		if(reservationRepository.trouveid(id)==null)
			return false;
		else
			 reservationRepository.deleteReservation(id);
		return true;
					
	}

	@Override
	public List<Reservation> getAllReservation() {
		// TODO Auto-generated method stub
		return reservationRepository.getAllReservation();
	}

	@Override
	public Page<Reservation> getAllReservationParMc(String mc,int page,int size) {
		// TODO Auto-generated method stub
		return reservationRepository.getAllReservationParMc("%"+mc+"%",new PageRequest(page, size));
	}

	@Override
	public Reservation getSatutReservation(Long id,String statut) {
		if(reservationRepository.trouveid(id)==null)
			return null;
		else
		return reservationRepository.getSatutReservation(id, statut);
	}

	@Override
	public boolean annulerReservation(Long id) {
		if(reservationRepository.trouveid(id)==null)
			return false;
		else{
			Date date= new Date();
			//convertion en localDateTime
			  LocalDateTime localDateTime=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				//convertion en localDate
			  LocalDate localDate=localDateTime.toLocalDate();
			  Reservation r = reservationRepository.getOne(id);
			  r.setDateFin(localDate);
			  reservationRepository.annulerReservation(id);
				return true;
		}
			
			
	}

	@Override
	public int activerStatut(Long id,String statut) {
		if(reservationRepository.trouveid(id)==null)
			return 0;
		else
			reservationRepository.activerStatut(id, statut);
		return 1;
	}

	@Override
	public int desactiverStatut(Long id,String statut) {
		if(reservationRepository.trouveid(id)==null)
			return 0;
		else
			reservationRepository.desactiverStatut(id, statut);
		return 1;
	}

	@Override
	public Reservation getReservation(Long id) {
		if(reservationRepository.trouveid(id)==null)
			return null;
		else
			
		return reservationRepository.getReservation(id);
	}

	@Override
	public Page<Reservation> getReservationParDate(LocalDate date,int page,int size) {
		// TODO Auto-generated method stub
		return reservationRepository.getReservationParDate(date,new PageRequest(page, size));
	}

	@Override
	public Page<Reservation> getReservationEntreDeuxDate(LocalDate date1, LocalDate date2,int page,int size) {
		// TODO Auto-generated method stub
		return reservationRepository.getReservationEntreDeuxDate(date1, date2,new PageRequest(page, size));
	}

	@Override
	public Reservation addProduitToReservation(Long idReservation, Long idProduit) {
		     Reservation r =  reservationRepository.getOne(idReservation);
		     ServiceProduit  p = produitRepository.getOne(idProduit);
		     r.getServiceProduits().add(p);
		     p.getReservations().add(r);
			return reservationRepository.save(r);
	}

	@Override
	public Reservation removeProduitToReservation(Long idReservation, Long idProduit) {
		 Reservation r =  reservationRepository.getOne(idReservation);
	     ServiceProduit  p = produitRepository.getOne(idProduit);
	     r.getServiceProduits().remove(p);
	     p.getReservations().remove(r);
		return reservationRepository.save(r);

	}

}
