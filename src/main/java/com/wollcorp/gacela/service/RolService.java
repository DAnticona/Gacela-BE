package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.RolDao;
import com.wollcorp.gacela.entity.Rol;

@Service
public class RolService {

	@Autowired
	RolDao rolDao;

	public List<Rol> listar() {
		return rolDao.findAll();
	}

	public void guardar(Rol rol) {
		rolDao.save(rol);
	}

	public void eliminar(Rol rol) {
		rolDao.delete(rol);
	}

	public Rol encontrarPorId(Rol rol) {
		return rolDao.findById(rol.getIdRol()).orElse(null);
	}
}
