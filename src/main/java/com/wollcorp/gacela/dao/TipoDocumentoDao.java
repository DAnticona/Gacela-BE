package com.wollcorp.gacela.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wollcorp.gacela.entity.TipoDocumento;

public interface TipoDocumentoDao extends JpaRepository<TipoDocumento, Integer> {

}
