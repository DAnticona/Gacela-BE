package com.wollcorp.gacela.service;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.Mtc1r999Dao;
import com.wollcorp.gacela.dao.Mtc1r999DetalleDao;
import com.wollcorp.gacela.dto.Mtc1r999Dto;
import com.wollcorp.gacela.entity.Mtc1r999;
import com.wollcorp.gacela.entity.Mtc1r999Detalle;
import com.wollcorp.gacela.service.mtc1r999.EjecutarBatch;
import com.wollcorp.gacela.service.mtc1r999.FileToMtc1r999;

@Service
public class Mtc1r999Service {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	Mtc1r999Dao mtc1r999Dao;

	@Autowired
	Mtc1r999DetalleDao mtc1r999DetalleDao;

	@Autowired
	FileToMtc1r999 fileToMtc1r999;

	@Autowired
	EjecutarBatch ejecutarBatch;

	public List<Mtc1r999> listar() {
		return mtc1r999Dao.findAll();
	}

	public List<Mtc1r999> listarNoEstado(String fgActi) {
		return mtc1r999Dao.findAllNotFgActi(fgActi);
	}

	public Mtc1r999 guardar(Mtc1r999 mtc1r999) {
		return mtc1r999Dao.save(mtc1r999);
	}

	public void actualizarEstado(Mtc1r999 mtc1r999) {
		mtc1r999Dao.updateFgActi(mtc1r999.getIdMtc1r999(), mtc1r999.getFgActi());
	}

	public void actualizarTodosLosEstados(String newfgActi, String fgActi) {
		mtc1r999Dao.updateAllFgActi(newfgActi, fgActi);
	}

	public void eliminar(Mtc1r999 mtc1r999) {
		mtc1r999Dao.delete(mtc1r999);
	}

	public Mtc1r999 encontrarPorId(Mtc1r999 mtc1r999) {
		return mtc1r999Dao.findById(mtc1r999.getIdMtc1r999()).orElse(null);
	}

	public Mtc1r999 encontrarPorEstado(Mtc1r999 mtc1r999) {
		return mtc1r999Dao.findByFgActi(mtc1r999.getFgActi());
	}

	public List<Mtc1r999Detalle> listarDetallePorId(Mtc1r999 mtc1r999) {
		return mtc1r999DetalleDao.findByMtc1r999(mtc1r999);
	}

	public Mtc1r999Dto fileToMtc1r999(Mtc1r999 mtc1r999, File file) {
		return fileToMtc1r999.extraerData(mtc1r999, file);
	}
	
	public Mtc1r999Dto validarMtc1r999(Mtc1r999 mtc1r999) {
		Mtc1r999Dto mtc1r999Dto = fileToMtc1r999.validarMtc1r999(mtc1r999);
		mtc1r999Dto.setErroresCutOffs(fileToMtc1r999.validarCuttOff(mtc1r999.getDetalle()));
		return mtc1r999Dto;
	}

	public void insertarDetalle(Mtc1r999Detalle detalle) {
		ejecutarBatch.insertarDetalle(detalle);
	}

}
