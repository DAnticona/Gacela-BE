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
	private String coIso;

	@Column(name = "co_iso2")
	private String coIso2;

	@Column(name = "co_sol")
	private String coSol;

	@Column(name = "us_crea")
	private String usCrea;

	@Column(name = "us_modi")
	private String usModi;

	@Column(name = "fe_crea")
	private LocalDateTime feCrea;

	@Column(name = "fe_modi")
	private LocalDateTime feModi;

	/**
	 * @return the coIso2
	 */
	public String getCoIso2() {
		return coIso2;
	}

	/**
	 * @param coIso2 the coIso2 to set
	 */
	public void setCoIso2(String coIso2) {
		this.coIso2 = coIso2;
	}

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
	 * @return the coIso
	 */
	public String getCoIso() {
		return coIso;
	}

	/**
	 * @param coIso the co_iso to set
	 */
	public void setCoIso(String coIso) {
		this.coIso = coIso;
	}

	/**
	 * @return the coSol
	 */
	public String getCoSol() {
		return coSol;
	}

	/**
	 * @param co_sol the coSol to set
	 */
	public void setCoSol(String coSol) {
		this.coSol = coSol;
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
		return "TipoContenedor [idTicon=" + idTicon + ", coIso=" + coIso + ", coIso2=" + coIso2 + ", coSol=" + coSol
				+ ", usCrea=" + usCrea + ", usModi=" + usModi + ", feCrea=" + feCrea + ", feModi=" + feModi + "]";
	}

}
