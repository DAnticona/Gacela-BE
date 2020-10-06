package com.wollcorp.gacela.dto;

import java.io.Serializable;

import com.wollcorp.gacela.entity.Proyeccion;

public class ProyeccionDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Proyeccion proyeccion;
	private Proyeccion unificada;
	/**
	 * @return the proyeccion
	 */
	public Proyeccion getProyeccion() {
		return proyeccion;
	}
	/**
	 * @param proyeccion the proyeccion to set
	 */
	public void setProyeccion(Proyeccion proyeccion) {
		this.proyeccion = proyeccion;
	}
	/**
	 * @return the unificada
	 */
	public Proyeccion getUnificada() {
		return unificada;
	}
	/**
	 * @param unificada the unificada to set
	 */
	public void setUnificada(Proyeccion unificada) {
		this.unificada = unificada;
	}
}
