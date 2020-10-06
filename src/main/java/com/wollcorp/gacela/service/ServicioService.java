package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.ServicioDao;
import com.wollcorp.gacela.entity.Servicio;

@Service
public class ServicioService {

	@Autowired
	ServicioDao servicioDao;

	public List<Servicio> listar() {
		return servicioDao.findAll();
	}

	public void guardar(Servicio servicio) {
		servicioDao.save(servicio);
	}

	public void eliminar(Servicio servicio) {
		servicioDao.delete(servicio);
	}

	public Servicio encontrarPorId(Servicio servicio) {
		return servicioDao.findById(servicio.getIdServicio()).orElse(null);
	}
}
