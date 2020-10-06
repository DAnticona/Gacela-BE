package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.ProyeccionDao;
import com.wollcorp.gacela.dao.ProyeccionDetalleDao;
import com.wollcorp.gacela.entity.Mtc1r999;
import com.wollcorp.gacela.entity.Proyeccion;
import com.wollcorp.gacela.entity.ProyeccionDetalle;
import com.wollcorp.gacela.service.proyeccion.GenerarProyeccion;
import com.wollcorp.gacela.service.proyeccion.InsertarProyeccionDetalle;

@Service
public class ProyeccionService {

	@Autowired
	ProyeccionDao proyeccionDao;
	@Autowired
	ProyeccionDetalleDao proyeccionDetalleDao;
	@Autowired
	InsertarProyeccionDetalle insertarProyeccionDetalle;
	@Autowired
	GenerarProyeccion generarProyeccion;

	public List<Proyeccion> listar() {
		return proyeccionDao.findAll();
	}

	public Proyeccion guardar(Proyeccion proyeccion) {
		return proyeccionDao.save(proyeccion);
	}
	
	public void actualizarTodosEstados(String newState, String oldState) {
		proyeccionDao.updateAllFgActi(newState, oldState);
	}

	public void eliminar(Proyeccion proyeccion) {
		proyeccionDao.delete(proyeccion);
	}

	public Proyeccion encontrarPorId(Proyeccion proyeccion) {
		return proyeccionDao.findById(proyeccion.getIdProyeccion()).orElse(null);
	}
	
	public Proyeccion encontrarPorEstadoYTipo(Proyeccion proyeccion) {
		return proyeccionDao.findByFgActiAndFgTipo(proyeccion.getFgActi(), proyeccion.getFgTipo());
	}
	
	public void insertarDetalle(ProyeccionDetalle detalle) {
		insertarProyeccionDetalle.insertarDetalle(detalle);
	}
	
	public Proyeccion generarProyeccion(Proyeccion proyeccion, Mtc1r999 mtc1r999) {
		return generarProyeccion.generarProyeccion(proyeccion, mtc1r999);
	}
	
}
