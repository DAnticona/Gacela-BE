package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.Submenu;
import com.wollcorp.gacela.service.SubmenuService;

@RestController
@RequestMapping("/submenus")
public class SubmenuRest {

	@Autowired
	SubmenuService submenuService;

	@GetMapping
	public ResponseEntity<List<Submenu>> obtenerSubmenus() {

		List<Submenu> submenus = submenuService.listar();
		return ResponseEntity.ok(submenus);
	}
}
