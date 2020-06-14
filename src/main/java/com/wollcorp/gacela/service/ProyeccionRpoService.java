package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.ProyeccionRpoDao;
import com.wollcorp.gacela.entity.ProyeccionRpo;
import com.wollcorp.gacela.entity.id.ProyeccionRpoId;

@Service
public class ProyeccionRpoService {

	@Autowired
	ProyeccionRpoDao proyeccionRpoDao;
	
	public List<ProyeccionRpo> listar() {
		return proyeccionRpoDao.findAll();
	}
	
	public void guardar(ProyeccionRpo rpo) {
		proyeccionRpoDao.save(rpo);
	}
	
	public void eliminar(ProyeccionRpo rpo) {
		proyeccionRpoDao.delete(rpo);
	}
	
	public ProyeccionRpo encontrarPorId(ProyeccionRpo rpo) {
		return proyeccionRpoDao
				.findById(new ProyeccionRpoId(rpo.getProyeccionRpoId().getIdProyeccion(),
											rpo.getProyeccionRpoId().getItem()))
				.orElse(null);
	}
}
