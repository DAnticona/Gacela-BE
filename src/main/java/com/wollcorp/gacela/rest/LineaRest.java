package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.Linea;
import com.wollcorp.gacela.service.LineaService;

@RestController
@RequestMapping("/lineas")
public class LineaRest {

	@Autowired
	LineaService lineaService;

	@GetMapping
	public ResponseEntity<List<Linea>> listar() {
		List<Linea> lineas = lineaService.listar();
		return ResponseEntity.ok(lineas);
	}
}
