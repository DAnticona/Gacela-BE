package com.wollcorp.gacela.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wollcorp.gacela.dto.LoginDto;
import com.wollcorp.gacela.entity.Usuario;
import com.wollcorp.gacela.service.UsuarioService;
import com.wollcorp.gacela.util.JwtToken;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginRest {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtToken jwtToken;

	@PostMapping
	public ResponseEntity<?> login(@RequestBody Usuario usuario) {
		this.autenticar(usuario.getUsuario(), usuario.getPasswd());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(usuario.getUsuario());

		final String token = jwtToken.generarToken(userDetails);

		usuario = new Usuario(usuario.getUsuario());
		usuario = usuarioService.encontrarPorUsername(usuario);

		LoginDto loginDto = new LoginDto(token, usuario);

		return ResponseEntity.ok(loginDto);

	}

	private void autenticar(String usuario, String passwd) {
		try {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario, passwd));

		} catch (DisabledException e) {

			log.info("USER_DISABLED");
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "USER DISABLED", e);

		} catch (BadCredentialsException e) {

			log.info("INVALID_CREDENTIALS");
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "INVALID CREDENTIALS", e);

		}
	}

}
