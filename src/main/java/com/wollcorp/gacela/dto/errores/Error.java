package com.wollcorp.gacela.dto.errores;

import java.io.Serializable;

public class Error implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mensaje;

	private String criticidad;

	public Error(String mensaje, String criticidad) {
		this.mensaje = mensaje;
		this.criticidad = criticidad;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the criticidad
	 */
	public String getCriticidad() {
		return criticidad;
	}

	/**
	 * @param criticidad the criticidad to set
	 */
	public void setCriticidad(String criticidad) {
		this.criticidad = criticidad;
	}
}
