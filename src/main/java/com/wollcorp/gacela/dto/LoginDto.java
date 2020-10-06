package com.wollcorp.gacela.dto;

import java.io.Serializable;

import com.wollcorp.gacela.entity.Usuario;

public class LoginDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String token;

	private Usuario usuario;

	public LoginDto(String token, Usuario usuario) {
		this.token = token;
		this.usuario = usuario;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
