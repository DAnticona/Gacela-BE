package com.wollcorp.gacela.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<LoginDto> login(@RequestParam String username, @RequestParam String passwd) throws Exception {

		this.autenticar(username, passwd);

		final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

		final String token = jwtToken.generarToken(userDetails);
		
		Usuario usuario = new Usuario(username);
		usuario = usuarioService.encontrarPorUsername(usuario);
		
		LoginDto loginDto = new LoginDto(token, usuario);

		return ResponseEntity.ok(loginDto);
	}

	private void autenticar(String usuario, String passwd) throws Exception {
		try {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario, passwd));

		} catch (DisabledException e) {

			log.info("USER_DISABLED");
			throw new Exception("USER_DISABLED", e);

		} catch (BadCredentialsException e) {

			log.info("INVALID_CREDENTIALS");
			throw new Exception("INVALID_CREDENTIALS", e);

		}
	}

}
