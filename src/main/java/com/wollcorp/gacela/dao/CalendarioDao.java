package com.wollcorp.gacela.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wollcorp.gacela.entity.Calendario;

public interface CalendarioDao extends JpaRepository<Calendario, Integer> {

	@Query("SELECT c FROM Calendario c WHERE c.fecha >= :fechaIni AND c.fecha <= :fechaFin")
	public List<Calendario> findByDates(LocalDate fechaIni, LocalDate fechaFin);
	
	@Query("SELECT c FROM Calendario c WHERE c.fecha = :fecha")
	public Calendario findByDate(LocalDate fecha);
	
}
