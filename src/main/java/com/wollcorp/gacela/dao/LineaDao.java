package com.wollcorp.gacela.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wollcorp.gacela.entity.Linea;

public interface LineaDao extends JpaRepository<Linea, Integer> {
	public Linea findByCoIso(String coIso);

	public Linea findByCoSol(String coSol);
}
