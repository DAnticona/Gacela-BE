package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.Mtc1r999Dao;
import com.wollcorp.gacela.entity.Mtc1r999;

@Service
public class Mtc1r999Service {

	@Autowired
	Mtc1r999Dao mtc1r999Dao;
	
	public List<Mtc1r999> listar() {
		return mtc1r999Dao.findAll();
	}
	
	public void guardar(Mtc1r999 mtc1r999) {
		mtc1r999Dao.save(mtc1r999);
	}
	
	public void eliminar(Mtc1r999 mtc1r999) {
		mtc1r999Dao.delete(mtc1r999);
	}
	
	public Mtc1r999 encontrarPorId(Mtc1r999 mtc1r999) {
		return mtc1r999Dao.findById(mtc1r999.getIdMtc1r999()).orElse(null);
	}
}
