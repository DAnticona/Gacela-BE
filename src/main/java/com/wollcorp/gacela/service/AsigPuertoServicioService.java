package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.AsigPuertoServicioDao;
import com.wollcorp.gacela.entity.AsigPuertoServicio;

@Service
public class AsigPuertoServicioService {
	
	@Autowired
	AsigPuertoServicioDao asigPuertoServicioDao;

	public List<AsigPuertoServicio> listar() {
		return asigPuertoServicioDao.findAll();
	}
	
	public void guardar(AsigPuertoServicio asig) {
		asigPuertoServicioDao.save(asig);
	}
	
	public void eliminar(AsigPuertoServicio asig) {
		asigPuertoServicioDao.delete(asig);
	}
	
	public AsigPuertoServicio encontrarPorId(AsigPuertoServicio asig) {
		return asigPuertoServicioDao.findById(asig.getIdAsig()).orElse(null);
	}
}
