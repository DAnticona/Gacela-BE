package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wollcorp.gacela.entity.Nave;
import com.wollcorp.gacela.entity.RpoPlan;
import com.wollcorp.gacela.service.NaveService;
import com.wollcorp.gacela.service.RpoPlanService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rpo-plan")
@Slf4j
public class RpoPlanRest {

	@Autowired
	RpoPlanService rpoPlanService;
	@Autowired
	NaveService naveService;

	@GetMapping
	public ResponseEntity<?> listar() {
		List<RpoPlan> planes = rpoPlanService.listar();
		return ResponseEntity.ok(planes);
	}

	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody RpoPlan rpo) {

		if (rpo == null || rpo.getNave() == null || rpo.getViaje() == null || rpo.getEta() == null) {
			this.throwException(HttpStatus.BAD_REQUEST, "Parmámetros incorrectos");
		}
		
		Nave nave = naveService.encontrarPorId(rpo.getNave());
		
		if(nave == null) {
			this.throwException(HttpStatus.BAD_REQUEST, "Nave desconocida");
		}
		
		rpo.setNave(nave);
		
		rpo = rpoPlanService.guardar(rpo);

		return ResponseEntity.ok(rpo);
	}
	
	@DeleteMapping
	public ResponseEntity<?> eliminar(@RequestParam("rpo") Long idRpo) {
		
		if(idRpo == null) {
			this.throwException(HttpStatus.BAD_REQUEST, "Rpo desconocido");
		}
		
		RpoPlan rpo = new RpoPlan(idRpo);
		rpoPlanService.eliminar(rpo);
		return ResponseEntity.ok(rpo);
	}

	/**
	 * Método privado que lanza una exepción y la registra en el log ERROR en caso
	 * de encontrar un error
	 * 
	 * @param httpStatus Tipo de exception a lanzar.
	 * @param message    Mensaje a mostrar al Frontend.
	 */
	private void throwException(HttpStatus httpStatus, String message) {
		log.error(message);
		throw new ResponseStatusException(httpStatus, message);
	}

}
