package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.ProyeccionDetalleDao;
import com.wollcorp.gacela.entity.ProyeccionDetalle;
import com.wollcorp.gacela.entity.id.ProyeccionDetalleId;

@Service
public class ProyeccionDetalleService {

	@Autowired
	ProyeccionDetalleDao proyeccionDetalleDao;
	
	public List<ProyeccionDetalle> listar() {
		return proyeccionDetalleDao.findAll();
	}
	
	public void guardar(ProyeccionDetalle detalle) {
		proyeccionDetalleDao.save(detalle);
	}
	
	public void eliminar(ProyeccionDetalle detalle) {
		proyeccionDetalleDao.delete(detalle);
	}
	
	public ProyeccionDetalle encontrarPorId(ProyeccionDetalle detalle) {
		return proyeccionDetalleDao
				.findById(new ProyeccionDetalleId(detalle.getProyeccionDetalleId().getIdProyeccion(),
												detalle.getProyeccionDetalleId().getItem()))
				.orElse(null);
	}
}
