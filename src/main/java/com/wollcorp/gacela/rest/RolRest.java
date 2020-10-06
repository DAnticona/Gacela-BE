package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.Rol;
import com.wollcorp.gacela.service.RolService;

@RestController
@RequestMapping("/roles")
public class RolRest {

	@Autowired
	RolService perfilService;

	@GetMapping
	private ResponseEntity<List<Rol>> obtenerPerfiles() {
		List<Rol> roles = perfilService.listar();
		return ResponseEntity.ok(roles);
	}

}
