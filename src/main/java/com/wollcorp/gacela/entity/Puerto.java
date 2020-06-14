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
@Table(name = "puerto")
public class Puerto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_puerto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPuerto;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "co_sol")
	private String coSol;

	@Column(name = "co_iso")
	private String coIso;

	@Column(name = "fg_acti")
	private String fgActi;

	@Column(name = "us_crea")
	private String usCrea;

	@Column(name = "us_modi")
	private String usModi;

	@Column(name = "fe_crea")
	private LocalDateTime feCrea;

	@Column(name = "fe_modi")
	private LocalDateTime feModi;

	public Puerto() {

	}

	public Puerto(Integer idPuerto) {
		this.idPuerto = idPuerto;
	}

	/**
	 * @return the idPuerto
	 */
	public Integer getIdPuerto() {
		return idPuerto;
	}

	/**
	 * @param idPuerto the idPuerto to set
	 */
	public void setIdPuerto(Integer idPuerto) {
		this.idPuerto = idPuerto;
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
	 * @return the coSol
	 */
	public String getCoSol() {
		return coSol;
	}

	/**
	 * @param coSol the coSol to set
	 */
	public void setCoSol(String coSol) {
		this.coSol = coSol;
	}

	/**
	 * @return the coIso
	 */
	public String getCoIso() {
		return coIso;
	}

	/**
	 * @param coIso the coIso to set
	 */
	public void setCoIso(String coIso) {
		this.coIso = coIso;
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
		return "Puerto [idPuerto=" + idPuerto + ", nombre=" + nombre + ", coSol=" + coSol + ", coIso=" + coIso
				+ ", fgActi=" + fgActi + ", usCrea=" + usCrea + ", usModi=" + usModi + ", feCrea=" + feCrea
				+ ", feModi=" + feModi + "]";
	}

}
