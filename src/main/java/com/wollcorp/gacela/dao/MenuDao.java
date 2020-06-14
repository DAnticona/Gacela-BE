package com.wollcorp.gacela.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wollcorp.gacela.entity.Menu;

public interface MenuDao extends JpaRepository<Menu, Integer> {

}
