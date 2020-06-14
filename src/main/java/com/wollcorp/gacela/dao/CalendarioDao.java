package com.wollcorp.gacela.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wollcorp.gacela.entity.Calendario;

public interface CalendarioDao extends JpaRepository<Calendario, Integer> {

}
