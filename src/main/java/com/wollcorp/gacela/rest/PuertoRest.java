package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.Puerto;
import com.wollcorp.gacela.service.PuertoService;

@RestController
@RequestMapping("/puertos")
public class PuertoRest {

	@Autowired
	PuertoService puertoService;
	
	@GetMapping
	public ResponseEntity<List<Puerto>> listar() {
		List<Puerto> puertos = puertoService.listar();
		return ResponseEntity.ok(puertos);
	}
}
