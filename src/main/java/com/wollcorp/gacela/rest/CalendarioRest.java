package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.Calendario;
import com.wollcorp.gacela.service.CalendarioService;

@RestController
@RequestMapping("/calendario")
public class CalendarioRest {

	@Autowired
	CalendarioService calendarioService;

	@GetMapping
	public ResponseEntity<?> listar() {
		List<Calendario> calendario = calendarioService.listar();
		return ResponseEntity.ok(calendario);
	} 
}
