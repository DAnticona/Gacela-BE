package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.Servicio;
import com.wollcorp.gacela.service.ServicioService;

@RestController
@RequestMapping("/servicios")
public class ServicioRest {

	@Autowired
	ServicioService servicioService;

	@GetMapping
	public ResponseEntity<List<Servicio>> obtenerServicios() {
		List<Servicio> servicios = servicioService.listar();
		return ResponseEntity.ok(servicios);
	}
}
