package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.PuertoDao;
import com.wollcorp.gacela.entity.Puerto;

@Service
public class PuertoService {

	@Autowired
	PuertoDao puertoDao;

	public List<Puerto> listar() {
		return puertoDao.findAll();
	}

	public void guardar(Puerto puerto) {
		puertoDao.save(puerto);
	}

	public void eliminar(Puerto puerto) {
		puertoDao.delete(puerto);
	}

	public Puerto encontrarPorId(Puerto puerto) {
		return puertoDao.findById(puerto.getIdPuerto()).orElse(null);
	}

	public Puerto encontrarPorCoIso(Puerto puerto) {
		return puertoDao.findByCoIso(puerto.getCoIso());
	}

	public Puerto encontrarPorCoSol(Puerto puerto) {
		return puertoDao.findByCoSol(puerto.getCoSol());
	}

	public List<Puerto> listarOrdenarPorCoSol(Puerto puerto) {
		return puertoDao.findAllByOrderByCoSolAsc();
	}
}
