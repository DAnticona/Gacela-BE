package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.NaveDao;
import com.wollcorp.gacela.entity.Nave;

@Service
public class NaveService {

	@Autowired
	NaveDao naveDao;
	
	public List<Nave> listar() {
		return naveDao.findAll();
	}
	
	public void guardar(Nave nave) {
		naveDao.save(nave);
	}
	
	public void eliminar(Nave nave) {
		naveDao.delete(nave);
	}
	
	public Nave encontrarPorId(Nave nave) {
		return naveDao.findById(nave.getIdNave()).orElse(null);
	}
}
