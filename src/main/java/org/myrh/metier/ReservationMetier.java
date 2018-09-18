package org.myrh.metier;

import java.time.LocalDate;
import java.util.List;

import org.myrh.entities.Reservation;
import org.springframework.data.domain.Page;

public interface ReservationMetier {
	public void saveReservation(Reservation r);
	public Reservation updateReservation(Reservation r,Long id);
	public boolean deleteReservation(Long id);
	public List<Reservation> getAllReservation();
	public Page<Reservation> getAllReservationParMc(String mc,int page,int size);
	public Reservation getSatutReservation(Long id,String statut);
	public boolean annulerReservation(Long id);
	public int activerStatut(Long id,String statut);
	public int desactiverStatut(Long id,String statut);
	public Reservation getReservation(Long id);
	public Page<Reservation> getReservationParDate(LocalDate date,int page,int size);
	public Page<Reservation> getReservationEntreDeuxDate(LocalDate date1,LocalDate date2,int page,int size);
	public Reservation addProduitToReservation(Long idReservation, Long idProduit);
	public Reservation removeProduitToReservation(Long idReservation, Long idProduit);
	

}
