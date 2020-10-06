package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.RatioDevolucion;
import com.wollcorp.gacela.service.RatioDevolucionService;

@RestController
@RequestMapping("/ratio-devolucion")
public class RatioDevolucionRest {

	@Autowired
	RatioDevolucionService ratioDevolucionService;

	@GetMapping
	public ResponseEntity<?> listar() {
		List<RatioDevolucion> ratios = ratioDevolucionService.listar();
		return ResponseEntity.ok(ratios);
	}

	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody RatioDevolucion ratio) {
		ratio = ratioDevolucionService.guardar(ratio);
		return ResponseEntity.ok(ratio);

	}
}
