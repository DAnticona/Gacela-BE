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
@Table(name = "tipo_contenedor")
public class TipoContenedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ticon")
	private Integer idTicon;

	@Column(name = "co_iso")
	private String co_iso;

	@Column(name = "co_sol")
	private String co_sol;

	@Column(name = "us_crea")
	private String usCrea;

	@Column(name = "us_modi")
	private String usModi;

	@Column(name = "fe_crea")
	private LocalDateTime feCrea;

	@Column(name = "fe_modi")
	private LocalDateTime feModi;

	/**
	 * @return the idTicon
	 */
	public Integer getIdTicon() {
		return idTicon;
	}

	/**
	 * @param idTicon the idTicon to set
	 */
	public void setIdTicon(Integer idTicon) {
		this.idTicon = idTicon;
	}

	/**
	 * @return the co_iso
	 */
	public String getCo_iso() {
		return co_iso;
	}

	/**
	 * @param co_iso the co_iso to set
	 */
	public void setCo_iso(String co_iso) {
		this.co_iso = co_iso;
	}

	/**
	 * @return the co_sol
	 */
	public String getCo_sol() {
		return co_sol;
	}

	/**
	 * @param co_sol the co_sol to set
	 */
	public void setCo_sol(String co_sol) {
		this.co_sol = co_sol;
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
		return "TipoContenedor [idTicon=" + idTicon + ", co_iso=" + co_iso + ", co_sol=" + co_sol + ", usCrea=" + usCrea
				+ ", usModi=" + usModi + ", feCrea=" + feCrea + ", feModi=" + feModi + "]";
	}

}
