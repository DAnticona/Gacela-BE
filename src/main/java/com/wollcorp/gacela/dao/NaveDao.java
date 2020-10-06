package com.wollcorp.gacela.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wollcorp.gacela.entity.Nave;

public interface NaveDao extends JpaRepository<Nave, Integer> {
	public Nave findByCodigo(String codigo);
	
}
