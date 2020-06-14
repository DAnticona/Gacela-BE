package com.wollcorp.gacela.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wollcorp.gacela.entity.ProyeccionRpo;
import com.wollcorp.gacela.entity.id.ProyeccionRpoId;

public interface ProyeccionRpoDao extends JpaRepository<ProyeccionRpo, ProyeccionRpoId> {

}
