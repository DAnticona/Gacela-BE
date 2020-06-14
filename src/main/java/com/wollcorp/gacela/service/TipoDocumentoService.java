package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.TipoDocumentoDao;
import com.wollcorp.gacela.entity.TipoDocumento;

@Service
public class TipoDocumentoService {

	@Autowired
	TipoDocumentoDao tipoDocumentoDao;

	public List<TipoDocumento> listar() {
		return tipoDocumentoDao.findAll();
	}

	public void guardar(TipoDocumento tipoDocumento) {
		tipoDocumentoDao.save(tipoDocumento);
	}

	public void eliminar(TipoDocumento tipoDocumento) {
		tipoDocumentoDao.delete(tipoDocumento);
	}

	public TipoDocumento encontrarPorId(TipoDocumento tipoDocumento) {
		return tipoDocumentoDao.findById(tipoDocumento.getIdTiDoc()).orElse(null);
	}

}
