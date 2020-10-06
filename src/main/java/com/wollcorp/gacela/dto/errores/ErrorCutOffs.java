package com.wollcorp.gacela.dto.errores;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class ErrorCutOffs implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nave;

	private String viaje;

	private List<LocalDate> cutOffs;

	public ErrorCutOffs() {
	}

	public ErrorCutOffs(String nave, String viaje) {
		this.nave = nave;
		this.viaje = viaje;
	}

	/**
	 * @return the nave
	 */
	public String getNave() {
		return nave;
	}

	/**
	 * @param nave the nave to set
	 */
	public void setNave(String nave) {
		this.nave = nave;
	}

	/**
	 * @return the viaje
	 */
	public String getViaje() {
		return viaje;
	}

	/**
	 * @param viaje the viaje to set
	 */
	public void setViaje(String viaje) {
		this.viaje = viaje;
	}

	/**
	 * @return the cutOffs
	 */
	public List<LocalDate> getCutOffs() {
		return cutOffs;
	}

	/**
	 * @param cutOffs the cutOffs to set
	 */
	public void setCutOffs(List<LocalDate> cutOffs) {
		this.cutOffs = cutOffs;
	}
}
