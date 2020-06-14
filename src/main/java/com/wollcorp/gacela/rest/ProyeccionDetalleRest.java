package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.ProyeccionDetalle;
import com.wollcorp.gacela.service.ProyeccionDetalleService;

@RestController
@RequestMapping("/proyeccion-detalle")
public class ProyeccionDetalleRest {
	
	@Autowired
	ProyeccionDetalleService proyeccionDetalleService;
	
	@GetMapping
	public ResponseEntity<List<ProyeccionDetalle>> listar() {
		List<ProyeccionDetalle> detalle = proyeccionDetalleService.listar();
		return ResponseEntity.ok(detalle);
	}
	
}
