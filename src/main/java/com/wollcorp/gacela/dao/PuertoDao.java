package com.wollcorp.gacela.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wollcorp.gacela.entity.Puerto;

public interface PuertoDao extends JpaRepository<Puerto, Integer> {
	public List<Puerto> findAllByOrderByCoSolAsc();

	public Puerto findByCoIso(String coIso);

	public Puerto findByCoSol(String coSol);
}
