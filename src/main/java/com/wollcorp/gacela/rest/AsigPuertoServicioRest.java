package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.AsigPuertoServicio;
import com.wollcorp.gacela.service.AsigPuertoServicioService;

@RestController
@RequestMapping("/puerto-servicio")
public class AsigPuertoServicioRest {

	@Autowired
	AsigPuertoServicioService asigPuertoServicioService;
	
	@GetMapping
	public ResponseEntity<List<AsigPuertoServicio>> listar() {
		List<AsigPuertoServicio> asignacion = asigPuertoServicioService.listar();
		return ResponseEntity.ok(asignacion);
	}
}
