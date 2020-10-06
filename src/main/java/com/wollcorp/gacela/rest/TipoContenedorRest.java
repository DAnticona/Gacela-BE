package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.TipoContenedor;
import com.wollcorp.gacela.service.TipoContenedorService;

@RestController
@RequestMapping("/tipos-contenedor")
public class TipoContenedorRest {

	@Autowired
	TipoContenedorService tipoContenedorService;

	@GetMapping
	public ResponseEntity<List<TipoContenedor>> listar() {
		List<TipoContenedor> tiposContenedor = tipoContenedorService.listar();
		return ResponseEntity.ok(tiposContenedor);
	}
}
