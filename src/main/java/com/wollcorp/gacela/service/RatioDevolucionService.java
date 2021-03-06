package com.wollcorp.gacela.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.RatioDevolucionDao;
import com.wollcorp.gacela.entity.RatioDevolucion;

@Service
public class RatioDevolucionService {

	@Autowired
	RatioDevolucionDao ratioDevolucionDao;
	
	public List<RatioDevolucion> listar() {
		return ratioDevolucionDao.findAll();
	}

	public RatioDevolucion guardar(RatioDevolucion ratio) {
		ratio.setFeRatio(LocalDate.now());
		return ratioDevolucionDao.save(ratio);
	}

	public void eliminar(RatioDevolucion ratio) {
		ratioDevolucionDao.delete(ratio);
	}

	public RatioDevolucion encontrarPorId(RatioDevolucion ratio) {
		return ratioDevolucionDao.findById(ratio.getIdRatio()).orElse(null);
	}
}
