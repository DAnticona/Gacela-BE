package com.wollcorp.gacela.dao;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wollcorp.gacela.entity.Mtc1r999;
import com.wollcorp.gacela.entity.Mtc1r999Detalle;
import com.wollcorp.gacela.entity.id.Mtc1r999DetalleId;

public interface Mtc1r999DetalleDao extends JpaRepository<Mtc1r999Detalle, Mtc1r999DetalleId> {

	public List<Mtc1r999Detalle> findByMtc1r999(Mtc1r999 mtc1r999);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Mtc1r999Detalle d " + "SET d.cutOff = :cutOff " + "WHERE d.mtc1r999 = :mtc1r999 "
			+ "AND d.nave = :nave " + "AND d.viaje = :viaje")
	public void updateCutOff(Mtc1r999 mtc1r999, String nave, String viaje, LocalDate cutOff);
}
