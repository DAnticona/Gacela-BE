package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.TipoContenedorDao;
import com.wollcorp.gacela.entity.TipoContenedor;

@Service
public class TipoContenedorService {
	@Autowired
	TipoContenedorDao tipoContenedorDao;

	public List<TipoContenedor> listar() {
		return tipoContenedorDao.findAll();
	}

	public void guardar(TipoContenedor tipo) {
		tipoContenedorDao.save(tipo);
	}

	public void eliminar(TipoContenedor tipo) {
		tipoContenedorDao.delete(tipo);
	}

	public TipoContenedor encontrarPorId(TipoContenedor tipo) {
		return tipoContenedorDao.findById(tipo.getIdTicon()).orElse(null);
	}
}
