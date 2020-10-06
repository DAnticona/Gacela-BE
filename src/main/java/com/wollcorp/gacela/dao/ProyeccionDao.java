package com.wollcorp.gacela.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wollcorp.gacela.entity.Proyeccion;

public interface ProyeccionDao extends JpaRepository<Proyeccion, Long> {
	
	@Query("SELECT p FROM Proyeccion p WHERE p.fgActi = :fgActi and fgTipo = :fgTipo")
	public Proyeccion findByFgActiAndFgTipo(String fgActi, String fgTipo);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Proyeccion p SET p.fgActi = :newFgActi WHERE p.fgActi = :oldFgActi")
	public void updateAllFgActi(String newFgActi, String oldFgActi);

}
