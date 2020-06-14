package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.Nave;
import com.wollcorp.gacela.service.NaveService;

@RestController
@RequestMapping("/naves")
public class NaveRest {
	
	@Autowired
	private NaveService naveService;
	
	@GetMapping
	public ResponseEntity<List<Nave>> obtenerNaves() {
		
		List<Nave> naves = naveService.listar();
		return ResponseEntity.ok(naves);
	}
}
