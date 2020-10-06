package com.wollcorp.gacela.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "mtc1r999")
@EntityListeners(AuditingEntityListener.class)
public class Mtc1r999 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mtc1r999")
	private Long idMtc1r999;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "fe_carga")
	private LocalDate feCarga;

	@Column(name = "fg_acti")
	private String fgActi;

	@Column(name = "fe_vcto")
	private LocalDate feVcto;

	@Column(name = "us_crea")
	@CreatedBy
	private String usCrea;

	@Column(name = "us_modi")
	@LastModifiedBy
	private String usModi;

	@Column(name = "fe_crea")
	@CreatedDate
	private LocalDateTime feCrea;

	@Column(name = "fe_modi")
	@LastModifiedDate
	private LocalDateTime feModi;

	@OneToMany(mappedBy = "mtc1r999")
	@JsonManagedReference
	private List<Mtc1r999Detalle> detalle;

	public Mtc1r999() {
	}

	public Mtc1r999(Long idMtc1r999) {
		this.idMtc1r999 = idMtc1r999;
	}

	public Mtc1r999(String fgActi) {
		this.fgActi = fgActi;
	}

	public Mtc1r999(String nombre, LocalDate feCarga, LocalDate feVcto) {
		this.nombre = nombre;
		this.feCarga = feCarga;
		this.feVcto = feVcto;
	}

	/**
	 * @return the idMtc1r999
	 */
	public Long getIdMtc1r999() {
		return idMtc1r999;
	}

	/**
	 * @param idMtc1r999 the idMtc1r999 to set
	 */
	public void setIdMtc1r999(Long idMtc1r999) {
		this.idMtc1r999 = idMtc1r999;
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
	 * @return the feCarga
	 */
	public LocalDate getFeCarga() {
		return feCarga;
	}

	/**
	 * @param feCarga the feCarga to set
	 */
	public void setFeCarga(LocalDate feCarga) {
		this.feCarga = feCarga;
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
	 * @return the feVcto
	 */
	public LocalDate getFeVcto() {
		return feVcto;
	}

	/**
	 * @param feVcto the feVcto to set
	 */
	public void setFeVcto(LocalDate feVcto) {
		this.feVcto = feVcto;
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

	/**
	 * @return the detalle
	 */
	public List<Mtc1r999Detalle> getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<Mtc1r999Detalle> detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Mtc1r999 [idMtc1r999=" + idMtc1r999 + ", nombre=" + nombre + ", feCarga=" + feCarga + ", fgActi="
				+ fgActi + ", feVcto=" + feVcto + ", usCrea=" + usCrea + ", usModi=" + usModi + ", feCrea=" + feCrea
				+ ", feModi=" + feModi + "]";
	}

}
