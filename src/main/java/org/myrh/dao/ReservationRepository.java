package org.myrh.dao;

import java.time.LocalDate;
import java.util.List;

import org.myrh.entities.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	@Query("select r.id from Reservation r where r.id=:x")
	public Long trouveid(@Param("x")Long id);
	@Transactional
	@Modifying
	@Query("update Reservation r set r.etat=false where r.id=:x")
	public int deleteReservation(@Param("x")Long id);
	@Query("select r from Reservation r where r.etat=true")
	public List<Reservation> getAllReservation();
	@Query("select r from Reservation r where r.etat=true and r.libelle like :x")
	public Page<Reservation> getAllReservationParMc(@Param("x")String mc,Pageable pageable);
	@Query("select r from Reservation r where r.etat=true and r.statut=:y and r.id=:x")
	public Reservation getSatutReservation(@Param("x")Long id,@Param("y")String statut);
	@Transactional
	@Modifying
	@Query("update Reservation r set r.annule=true where r.id=:x")
	public int annulerReservation(@Param("x")Long id);
	@Transactional
	@Modifying
	@Query("update Reservation r set r.statut=:y where r.id=:x")
	public int activerStatut(@Param("x")Long id,@Param("y")String statut);
	@Transactional
	@Modifying
	@Query("update Reservation r set r.statut=:y where r.id=:x")
	public int desactiverStatut(@Param("x")Long id,@Param("y")String statut);
	@Query("select r from Reservation r where r.etat=true and r.id=:x")
	public Reservation getReservation(@Param("x")Long id);
	@Query("select r from Reservation r where r.etat=true and r.dateDebut=:x")
	public Page<Reservation> getReservationParDate(@Param("x")LocalDate date, Pageable pageable);
	@Query("select r from Reservation r where r.etat=true and r.dateDebut between :x and :y ")
	public Page<Reservation> getReservationEntreDeuxDate(@Param("x")LocalDate date1,@Param("y")LocalDate date2,Pageable pageable);
	
}
