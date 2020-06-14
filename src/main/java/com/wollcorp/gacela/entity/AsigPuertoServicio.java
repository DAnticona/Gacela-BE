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
@Table(name = "asig_puerto_servicio")
public class AsigPuertoServicio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_asig")
	private Integer idAsig;

	@ManyToOne
	@JoinColumn(name = "id_puerto", referencedColumnName = "id_puerto")
	private Puerto puerto;

	@ManyToOne
	@JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
	private Servicio servicio;

	@Column(name = "us_crea")
	private String usCrea;

	@Column(name = "us_modi")
	private String usModi;

	@Column(name = "fe_crea")
	private LocalDateTime feCrea;

	@Column(name = "fe_modi")
	private LocalDateTime feModi;

	/**
	 * @return the idAsig
	 */
	public Integer getIdAsig() {
		return idAsig;
	}

	/**
	 * @param idAsig the idAsig to set
	 */
	public void setIdAsig(Integer idAsig) {
		this.idAsig = idAsig;
	}

	/**
	 * @return the puerto
	 */
	public Puerto getPuerto() {
		return puerto;
	}

	/**
	 * @param puerto the puerto to set
	 */
	public void setPuerto(Puerto puerto) {
		this.puerto = puerto;
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
		return "AsigPuertoServicio [idAsig=" + idAsig + ", puerto=" + puerto + ", servicio=" + servicio + ", usCrea="
				+ usCrea + ", usModi=" + usModi + ", feCrea=" + feCrea + ", feModi=" + feModi + "]";
	}

}
