package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.Acceso;
import com.wollcorp.gacela.service.AccesoService;

@RestController
@RequestMapping("/accesos")
public class AccesoRest {

	@Autowired
	AccesoService accesoService;

	@GetMapping
	private ResponseEntity<List<Acceso>> listar() {
		List<Acceso> accesos = accesoService.listar();

		return ResponseEntity.ok(accesos);
	}
}
