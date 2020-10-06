package com.wollcorp.gacela.entity;

import java.io.Serializable;
import java.util.List;

public class Forecast implements Serializable {

	private static final long serialVersionUID = 1L;

	private Servicio servicio;

	private Nave nave;

	private String fgProp;

	private List<ForecastDetalle> detalle;

	public Forecast() {

	}

	public Forecast(Servicio servicio, Nave nave, String fgProp) {
		this.servicio = servicio;
		this.nave = nave;
		this.fgProp = fgProp;
	}

	/**
	 * @return the fgProp
	 */
	public String getFgProp() {
		return fgProp;
	}

	/**
	 * @param fgProp the fgProp to set
	 */
	public void setFgProp(String fgProp) {
		this.fgProp = fgProp;
	}

	/**
	 * @return the servicio
	 */
	public Servicio getServicio() {
		return servicio;
	}

	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	/**
	 * @return the nave
	 */
	public Nave getNave() {
		return nave;
	}

	/**
	 * @param nave the nave to set
	 */
	public void setNave(Nave nave) {
		this.nave = nave;
	}

	/**
	 * @return the detalle
	 */
	public List<ForecastDetalle> getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<ForecastDetalle> detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "ForecastInput [servicio=" + servicio + ", nave=" + nave + "]";
	}
}
