package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.Proyeccion;
import com.wollcorp.gacela.service.ProyeccionService;

@RestController
@RequestMapping("/proyeccion")
public class ProyeccionRest {

	@Autowired
	ProyeccionService proyeccionService;
	
	@GetMapping
	public ResponseEntity<List<Proyeccion>> listar() {
		List<Proyeccion> proyecciones = proyeccionService.listar();
		return ResponseEntity.ok(proyecciones);
	}
}
