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
@Table(name = "ratio_devolucion")
public class RatioDevolucion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ratio")
	private Integer idRatio;

	@Column(name = "ratio_2sd")
	private Integer ratio2sd;

	@Column(name = "ratio_4sd")
	private Integer ratio4sd;

	@Column(name = "ratio_4sh")
	private Integer ratio4sh;

	@Column(name = "us_crea")
	private String usCrea;

	@Column(name = "us_modi")
	private String usModi;

	@Column(name = "fe_crea")
	private LocalDateTime feCrea;

	@Column(name = "fe_modi")
	private LocalDateTime feModi;

	/**
	 * @return the idRatio
	 */
	public Integer getIdRatio() {
		return idRatio;
	}

	/**
	 * @param idRatio the idRatio to set
	 */
	public void setIdRatio(Integer idRatio) {
		this.idRatio = idRatio;
	}

	/**
	 * @return the ratio2sd
	 */
	public Integer getRatio2sd() {
		return ratio2sd;
	}

	/**
	 * @param ratio2sd the ratio2sd to set
	 */
	public void setRatio2sd(Integer ratio2sd) {
		this.ratio2sd = ratio2sd;
	}

	/**
	 * @return the ratio4sd
	 */
	public Integer getRatio4sd() {
		return ratio4sd;
	}

	/**
	 * @param ratio4sd the ratio4sd to set
	 */
	public void setRatio4sd(Integer ratio4sd) {
		this.ratio4sd = ratio4sd;
	}

	/**
	 * @return the ratio4sh
	 */
	public Integer getRatio4sh() {
		return ratio4sh;
	}

	/**
	 * @param ratio4sh the ratio4sh to set
	 */
	public void setRatio4sh(Integer ratio4sh) {
		this.ratio4sh = ratio4sh;
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

}
