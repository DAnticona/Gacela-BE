package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wollcorp.gacela.entity.Linea;
import com.wollcorp.gacela.entity.Nave;
import com.wollcorp.gacela.entity.Servicio;
import com.wollcorp.gacela.service.LineaService;
import com.wollcorp.gacela.service.NaveService;
import com.wollcorp.gacela.service.ServicioService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/naves")
@Slf4j
public class NaveRest {

	@Autowired
	private NaveService naveService;

	@Autowired
	private ServicioService servicioService;

	@Autowired
	private LineaService lineaService;

	@GetMapping
	public ResponseEntity<List<Nave>> obtenerNaves() {

		List<Nave> naves = naveService.listar();
		return ResponseEntity.ok(naves);
	}

	@PostMapping
	public ResponseEntity<?> guardarNave(@RequestBody Nave nave) {

		if (nave != null) {

			Servicio servicio = new Servicio(nave.getServicio().getIdServicio());
			servicio = servicioService.encontrarPorId(servicio);

			Linea linea = new Linea(nave.getLinea().getIdLinea());
			linea = lineaService.encontrarPorId(linea);

			if (servicio != null && linea != null) {
				nave = naveService.guardar(nave);
				return ResponseEntity.ok(nave);
			} else {
				log.error("Service or Line not found");
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Service or Line not found");
			}
		} else {
			log.error("Incomplete parameters");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incomplete parameters");
		}

	}
}
