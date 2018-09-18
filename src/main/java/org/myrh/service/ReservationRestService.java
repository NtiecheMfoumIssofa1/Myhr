package org.myrh.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.mail.MessagingException;

import org.myrh.entities.HTMLMail;
import org.myrh.entities.Reservation;
import org.myrh.metier.ReservationMetier;
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
public class ReservationRestService {
	@Autowired
	private ReservationMetier reservationMetier; 
	@Autowired
	private MailSenderService sendMail;
	  
	
	@RequestMapping(value="/Reservation",method=RequestMethod.POST)
	public void saveReservation(@RequestBody Reservation r) throws MessagingException {
		HTMLMail mail = new HTMLMail("youssouf.tiefa@gmail.com");
		
			reservationMetier.saveReservation( r);
		sendMail.sendHTMLMail(mail,r);  
	}
	@RequestMapping(value="/Reservation/{id}",method=RequestMethod.PUT)
	public Reservation updateReservation( @RequestBody Reservation r, @PathVariable Long id) {
		return reservationMetier.updateReservation( r, id);
	}
	@RequestMapping(value="/Reservation/{id}",method=RequestMethod.DELETE)
	public boolean deleteReservation(@PathVariable Long id) {
		return reservationMetier.deleteReservation(id);
	}
	@RequestMapping(value="/Reservation",method=RequestMethod.GET)
	public List<Reservation> getAllReservation() {
		return reservationMetier.getAllReservation();
	}
	@RequestMapping(value="/ReservationParMc",method=RequestMethod.GET)
	public Page<Reservation> getAllReservationParMc(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size) {
		return reservationMetier.getAllReservationParMc(mc,page,size);
	}
	@RequestMapping(value="/ReservationParStatut/{id}/{statut}",method=RequestMethod.GET)
	public Reservation getSatutReservation(@PathVariable Long id, @PathVariable String statut) {
		return reservationMetier.getSatutReservation(id, statut);
	}
	@RequestMapping(value="/annulerReservation/{id}",method=RequestMethod.DELETE)
	public boolean annulerReservation(@PathVariable Long id) {
		return reservationMetier.annulerReservation(id);
	}
	@RequestMapping(value="/activerStatut/{id}/{statut}",method=RequestMethod.PUT)
	public int activerStatut(@PathVariable Long id,@PathVariable String statut) {
		return reservationMetier.activerStatut(id, statut);
	}
	@RequestMapping(value="/desactiverStatut/{id}/{statut}",method=RequestMethod.PUT)
	public int desactiverStatut(@PathVariable Long id,@PathVariable String statut) {
		return reservationMetier.desactiverStatut(id, statut);
	}
	@RequestMapping(value="/getReservationId/{id}",method=RequestMethod.GET)
	public Reservation getReservation(@PathVariable Long id) {
		return reservationMetier.getReservation(id);
	}
	@RequestMapping(value="/getReservationParDate",method=RequestMethod.GET)
	public Page<Reservation> getReservationParDate(
			@RequestParam(name="date",defaultValue="")String date,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size)  {
		LocalDate dates=LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return reservationMetier.getReservationParDate(dates, page, size);
	}
	@RequestMapping(value="/getReservationEntreDeuxDate",method=RequestMethod.GET)
	public Page<Reservation> getReservationEntreDeuxDate(
			@RequestParam(name="date1",defaultValue="")String date1,
			@RequestParam(name="date1",defaultValue="")String date2,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size)  {
		LocalDate dates1=LocalDate.parse(date1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate dates2=LocalDate.parse(date2, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return reservationMetier.getReservationEntreDeuxDate(dates1, dates2,page,size);
	}
	@RequestMapping(value="/addProduitToReservation",method=RequestMethod.DELETE)
	public Reservation addProduitToReservation(@PathVariable Long idReservation, @PathVariable Long idProduit) {
		return reservationMetier.addProduitToReservation(idReservation, idProduit);
	}
	@RequestMapping(value="/removeProduitToReservation",method=RequestMethod.DELETE)
	public Reservation removeProduitToReservation(@PathVariable Long idReservation, @PathVariable Long idProduit) {
		return reservationMetier.removeProduitToReservation(idReservation, idProduit);
	}

}
