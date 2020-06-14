package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.ProyeccionDao;
import com.wollcorp.gacela.entity.Proyeccion;

@Service
public class ProyeccionService {

	@Autowired
	ProyeccionDao proyeccionDao;
	
	public List<Proyeccion> listar() {
		return proyeccionDao.findAll();
	}
	
	public void guardar(Proyeccion proyeccion) {
		proyeccionDao.save(proyeccion);
	}
	
	public void eliminar(Proyeccion proyeccion) {
		proyeccionDao.delete(proyeccion);
	}
	
	public Proyeccion encontrarPorId(Proyeccion proyeccion) {
		return proyeccionDao.findById(proyeccion.getIdProyeccion()).orElse(null);
	}
}
