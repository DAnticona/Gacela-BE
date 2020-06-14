package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.Usuario;
import com.wollcorp.gacela.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosRest {
	
	 @Autowired
	 UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> obtenerUsuarios() {
		
		List<Usuario> usuarios = usuarioService.listar();
		
		return ResponseEntity.ok(usuarios);
	}
}
