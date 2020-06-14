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
@Table(name = "tipo_documento")
public class TipoDocumento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tidoc")
	private Integer idTiDoc;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "abrev")
	private String abrev;

	@Column(name = "us_crea")
	private String usCrea;

	@Column(name = "us_modi")
	private String usModi;

	@Column(name = "fe_crea")
	private LocalDateTime feCrea;

	@Column(name = "fe_modi")
	private LocalDateTime feModi;

	/**
	 * @return the idTiDoc
	 */
	public Integer getIdTiDoc() {
		return idTiDoc;
	}

	/**
	 * @param idTiDoc the idTiDoc to set
	 */
	public void setIdTiDoc(Integer idTiDoc) {
		this.idTiDoc = idTiDoc;
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
	 * @return the abrev
	 */
	public String getAbrev() {
		return abrev;
	}

	/**
	 * @param abrev the abrev to set
	 */
	public void setAbrev(String abrev) {
		this.abrev = abrev;
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
		return "TipoDocumento [idTiDoc=" + idTiDoc + ", nombre=" + nombre + ", abrev=" + abrev + ", usCrea=" + usCrea
				+ ", usModi=" + usModi + ", feCrea=" + feCrea + ", feModi=" + feModi + "]";
	}

}
