package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.Mtc1r999Detalle;
import com.wollcorp.gacela.service.Mtc1r999DetalleService;

@RestController
@RequestMapping("/mtc1r999-detalle")
public class Mtc1r999DetalleRest {

	@Autowired
	Mtc1r999DetalleService mtc1r999DetalleService;
	
	@GetMapping
	public ResponseEntity<List<Mtc1r999Detalle>> listar() {
		List<Mtc1r999Detalle> detalle = mtc1r999DetalleService.listar();
		return ResponseEntity.ok(detalle);
	}
}
