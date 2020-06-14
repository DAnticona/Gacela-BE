package com.wollcorp.gacela.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wollcorp.gacela.entity.Submenu;
import com.wollcorp.gacela.entity.id.SubmenuId;

public interface SubmenuDao extends JpaRepository<Submenu, SubmenuId> {

}
