package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.Mtc1r999DetalleDao;
import com.wollcorp.gacela.entity.Mtc1r999Detalle;
import com.wollcorp.gacela.entity.id.Mtc1r999DetalleId;

@Service
public class Mtc1r999DetalleService {

	@Autowired
	Mtc1r999DetalleDao mtc1r999DetalleDao;
	
	public List<Mtc1r999Detalle> listar() {
		return mtc1r999DetalleDao.findAll();
	}
	
	public void guardar(Mtc1r999Detalle detalle) {
		mtc1r999DetalleDao.save(detalle);
	}
	
	public void eliminar(Mtc1r999Detalle detalle) {
		mtc1r999DetalleDao.delete(detalle);
	}
	
	public Mtc1r999Detalle encontrarPorId(Mtc1r999Detalle detalle) {
		return mtc1r999DetalleDao
				.findById(new Mtc1r999DetalleId(detalle.getMtc1r999DetalleId().getIdMtc1r999(),
												detalle.getMtc1r999DetalleId().getItem()))
				.orElse(null);
	}
}
