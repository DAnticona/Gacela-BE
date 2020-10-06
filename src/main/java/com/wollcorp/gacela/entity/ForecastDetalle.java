package com.wollcorp.gacela.entity;

import java.io.Serializable;

public class ForecastDetalle implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer fila;

	private String linea;

	private String pod;

	private Integer size;

	private String type;

	private String cnd;

	private Long vgm;

	private String imo;

	private String un;

	private String temperature;

	private String commodity;

	public ForecastDetalle() {

	}

	/**
	 * @return the fila
	 */
	public Integer getFila() {
		return fila;
	}

	/**
	 * @param fila the item to set
	 */
	public void setFila(Integer fila) {
		this.fila = fila;
	}

	/**
	 * @return the linea
	 */
	public String getLinea() {
		return linea;
	}

	/**
	 * @param linea the linea to set
	 */
	public void setLinea(String linea) {
		this.linea = linea;
	}

	/**
	 * @return the pod
	 */
	public String getPod() {
		return pod;
	}

	/**
	 * @param pod the pod to set
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}

	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the cnd
	 */
	public String getCnd() {
		return cnd;
	}

	/**
	 * @param cnd the cnd to set
	 */
	public void setCnd(String cnd) {
		this.cnd = cnd;
	}

	/**
	 * @return the vgm
	 */
	public Long getVgm() {
		return vgm;
	}

	/**
	 * @param vgm the vgm to set
	 */
	public void setVgm(Long vgm) {
		this.vgm = vgm;
	}

	/**
	 * @return the imo
	 */
	public String getImo() {
		return imo;
	}

	/**
	 * @param imo the imo to set
	 */
	public void setImo(String imo) {
		this.imo = imo;
	}

	/**
	 * @return the un
	 */
	public String getUn() {
		return un;
	}

	/**
	 * @param un the un to set
	 */
	public void setUn(String un) {
		this.un = un;
	}

	/**
	 * @return the temperature
	 */
	public String getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the commodity
	 */
	public String getCommodity() {
		return commodity;
	}

	/**
	 * @param commodity the commodity to set
	 */
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	@Override
	public String toString() {
		return "ForecastDetalle [fila=" + fila + ", linea=" + linea + ", pod=" + pod + ", size=" + size + ", type="
				+ type + ", cnd=" + cnd + ", vgm=" + vgm + ", imo=" + imo + ", un=" + un + ", temperature="
				+ temperature + ", commodity=" + commodity + "]";
	}
}
