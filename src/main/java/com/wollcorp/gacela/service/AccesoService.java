package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.AccesoDao;
import com.wollcorp.gacela.entity.Acceso;

@Service
public class AccesoService {
	
	@Autowired
	private AccesoDao accesoDao;
	
	public List<Acceso> listar() {
		return accesoDao.findAll();
	}
	
	public void guardar(Acceso acceso) {
		accesoDao.save(acceso);
	}
	
	public void eliminar(Acceso acceso) {
		accesoDao.delete(acceso);
	}
	
	public Acceso encontrarPorId(Acceso acceso) {
		return accesoDao.findById(acceso.getIdAcceso()).orElse(null);
	}

}
