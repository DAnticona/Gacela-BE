package com.wollcorp.gacela.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nave")
public class Nave implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nave")
	private Integer idNave;

	@ManyToOne
	@JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
	private Servicio servicio;

	@ManyToOne
	@JoinColumn(name = "id_linea", referencedColumnName = "id_linea")
	private Linea linea;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "codigo")
	private String codigo;

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

	/**
	 * @return the idNave
	 */
	public Integer getIdNave() {
		return idNave;
	}

	/**
	 * @param idNave the idNave to set
	 */
	public void setIdNave(Integer idNave) {
		this.idNave = idNave;
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
	 * @return the linea
	 */
	public Linea getLinea() {
		return linea;
	}

	/**
	 * @param linea the linea to set
	 */
	public void setLinea(Linea linea) {
		this.linea = linea;
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
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
		return "Nave [idNave=" + idNave + ", servicio=" + servicio + ", linea=" + linea + ", nombre=" + nombre
				+ ", codigo=" + codigo + ", fgActi=" + fgActi + ", usCrea=" + usCrea + ", usModi=" + usModi
				+ ", feCrea=" + feCrea + ", feModi=" + feModi + "]";
	}

}
