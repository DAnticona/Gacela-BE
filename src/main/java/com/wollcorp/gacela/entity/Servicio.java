package com.wollcorp.gacela.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servicio")
	private Integer idServicio;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "fg_acti")
	private String fgActi;

	@Column(name = "fg_far_east")
	private String fgFarEast;

	@Column(name = "us_crea")
	private String usCrea;

	@Column(name = "us_modi")
	private String usModi;

	@Column(name = "fe_crea")
	private LocalDateTime feCrea;

	@Column(name = "fe_modi")
	private LocalDateTime feModi;

	/**
	 * @return the idServicio
	 */
	public Integer getIdServicio() {
		return idServicio;
	}

	/**
	 * @param idServicio the idServicio to set
	 */
	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the fgActi
	 */
	public String getFgActi() {
		return fgActi;
	}

	/**
	 * @param fgActi the fgActi to set
	 */
	public void setFgActi(String fgActi) {
		this.fgActi = fgActi;
	}

	/**
	 * @return the fgFarEast
	 */
	public String getFgFarEast() {
		return fgFarEast;
	}

	/**
	 * @param fgFarEast the fgFarEast to set
	 */
	public void setFgFarEast(String fgFarEast) {
		this.fgFarEast = fgFarEast;
	}

	/**
	 * @return the usCrea
	 */
	public String getUsCrea() {
		return usCrea;
	}

	/**
	 * @param usCrea the usCrea to set
	 */
	public void setUsCrea(String usCrea) {
		this.usCrea = usCrea;
	}

	/**
	 * @return the usModi
	 */
	public String getUsModi() {
		return usModi;
	}

	/**
	 * @param usModi the usModi to set
	 */
	public void setUsModi(String usModi) {
		this.usModi = usModi;
	}

	/**
	 * @return the feCrea
	 */
	public LocalDateTime getFeCrea() {
		return feCrea;
	}

	/**
	 * @param feCrea the feCrea to set
	 */
	public void setFeCrea(LocalDateTime feCrea) {
		this.feCrea = feCrea;
	}

	/**
	 * @return the feModi
	 */
	public LocalDateTime getFeModi() {
		return feModi;
	}

	/**
	 * @param feModi the feModi to set
	 */
	public void setFeModi(LocalDateTime feModi) {
		this.feModi = feModi;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", nombre=" + nombre + ", fgActi=" + fgActi + ", fgFarEast="
				+ fgFarEast + ", usCrea=" + usCrea + ", usModi=" + usModi + ", feCrea=" + feCrea + ", feModi=" + feModi
				+ "]";
	}

}
