package com.wollcorp.gacela.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wollcorp.gacela.entity.ProyeccionDetalle;
import com.wollcorp.gacela.entity.id.ProyeccionDetalleId;

public interface ProyeccionDetalleDao extends JpaRepository<ProyeccionDetalle, ProyeccionDetalleId> {

}
