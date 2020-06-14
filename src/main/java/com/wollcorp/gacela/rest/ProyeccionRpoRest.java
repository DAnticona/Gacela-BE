package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.ProyeccionRpo;
import com.wollcorp.gacela.service.ProyeccionRpoService;

@RestController
@RequestMapping("/proyeccion-rpo")
public class ProyeccionRpoRest {
	
	@Autowired
	ProyeccionRpoService proyeccionRpoService;
	
	@GetMapping
	public ResponseEntity<List<ProyeccionRpo>> listar() {
		List<ProyeccionRpo> rpo = proyeccionRpoService.listar();
		return ResponseEntity.ok(rpo);
	}

}
