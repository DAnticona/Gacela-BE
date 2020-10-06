package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.Menu;
import com.wollcorp.gacela.service.MenuService;

@RestController
@RequestMapping("/menus")
public class MenuRest {

	@Autowired
	MenuService menuService;

	@GetMapping
	public ResponseEntity<List<Menu>> obtenerMenus() {

		List<Menu> menus = menuService.listar();
		return ResponseEntity.ok(menus);
	}

}
