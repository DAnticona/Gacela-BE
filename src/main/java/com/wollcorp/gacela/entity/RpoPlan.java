package com.wollcorp.gacela.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "rpo_plan")
@EntityListeners(AuditingEntityListener.class)
public class RpoPlan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rpo")
	private Long idRpo;

	@ManyToOne
	@JoinColumn(name = "id_nave", referencedColumnName = "id_nave")
	private Nave nave;

	@Column(name = "viaje")
	private String viaje;

	@Column(name = "rpo_2sd")
	private Integer rpo2sd;

	@Column(name = "rpo_4sd")
	private Integer rpo4sd;

	@Column(name = "rpo_4sh")
	private Integer rpo4sh;

	@Column(name = "eta")
	private LocalDate eta;

	@Column(name = "fg_acti")
	private String fgActi;

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

	public RpoPlan() {
	}

	public RpoPlan(Long idRpo) {
		this.idRpo = idRpo;
	}

	/**
	 * @return the idRpo
	 */
	public Long getIdRpo() {
		return idRpo;
	}

	/**
	 * @param idRpo the idRpo to set
	 */
	public void setIdRpo(Long idRpo) {
		this.idRpo = idRpo;
	}

	/**
	 * @return the nave
	 */
	public Nave getNave() {
		return nave;
	}

	/**
	 * @param nave the nave to set
	 */
	public void setNave(Nave nave) {
		this.nave = nave;
	}

	/**
	 * @return the viaje
	 */
	public String getViaje() {
		return viaje;
	}

	/**
	 * @param viaje the viaje to set
	 */
	public void setViaje(String viaje) {
		this.viaje = viaje;
	}

	/**
	 * @return the rpo2sd
	 */
	public Integer getRpo2sd() {
		return rpo2sd;
	}

	/**
	 * @param rpo2sd the rpo2sd to set
	 */
	public void setRpo2sd(Integer rpo2sd) {
		this.rpo2sd = rpo2sd;
	}

	/**
	 * @return the rpo4sd
	 */
	public Integer getRpo4sd() {
		return rpo4sd;
	}

	/**
	 * @param rpo4sd the rpo4sd to set
	 */
	public void setRpo4sd(Integer rpo4sd) {
		this.rpo4sd = rpo4sd;
	}

	/**
	 * @return the rpo4sh
	 */
	public Integer getRpo4sh() {
		return rpo4sh;
	}

	/**
	 * @param rpo4sh the rpo4sh to set
	 */
	public void setRpo4sh(Integer rpo4sh) {
		this.rpo4sh = rpo4sh;
	}

	/**
	 * @return the eta
	 */
	public LocalDate getEta() {
		return eta;
	}

	/**
	 * @param eta the eta to set
	 */
	public void setEta(LocalDate eta) {
		this.eta = eta;
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
		return "RpoPlan [idRpo=" + idRpo + ", nave=" + nave + ", viaje=" + viaje + ", rpo2sd=" + rpo2sd + ", rpo4sd="
				+ rpo4sd + ", rpo4sh=" + rpo4sh + ", eta=" + eta + ", fgActi=" + fgActi + ", usCrea=" + usCrea
				+ ", usModi=" + usModi + ", feCrea=" + feCrea + ", feModi=" + feModi + "]";
	}

}
