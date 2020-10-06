package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.LineaDao;
import com.wollcorp.gacela.entity.Linea;

@Service
public class LineaService {

	@Autowired
	LineaDao lineaDao;

	public List<Linea> listar() {
		return lineaDao.findAll();
	}

	public void guardar(Linea linea) {
		lineaDao.save(linea);
	}

	public void eliminar(Linea linea) {
		lineaDao.delete(linea);
	}

	public Linea encontrarPorId(Linea linea) {
		return lineaDao.findById(linea.getIdLinea()).orElse(null);
	}

	public Linea encontrarPorCoIso(Linea linea) {
		return lineaDao.findByCoIso(linea.getCoIso());
	}

	public Linea encontrarPorCoSol(Linea linea) {
		return lineaDao.findByCoSol(linea.getCoSol());
	}
}
