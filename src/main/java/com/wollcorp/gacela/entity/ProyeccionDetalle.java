package com.wollcorp.gacela.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wollcorp.gacela.entity.id.ProyeccionDetalleId;

@Entity
@Table(name = "proyeccion_detalle")
@EntityListeners(AuditingEntityListener.class)
public class ProyeccionDetalle implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProyeccionDetalleId proyeccionDetalleId;

	@MapsId("idProyeccion")
	@ManyToOne
	@JoinColumn(name = "id_proyeccion", referencedColumnName = "id_proyeccion")
	@JsonBackReference
	private Proyeccion proyeccion;

	@ManyToOne
	@JoinColumn(name = "id_nave", referencedColumnName = "id_nave")
	private Nave nave;

	@Column(name = "viaje")
	private String viaje;

	@Column(name = "ca_2sd_no_fe")
	private Integer ca2sdNoFe;

	@Column(name = "ca_2sd_no_fe_pick")
	private Integer ca2sdNoFePick;

	@Column(name = "ca_2sd_fe")
	private Integer ca2sdFe;

	@Column(name = "ca_2sd_fe_pick")
	private Integer ca2sdFePick;

	@Column(name = "ca_4sd_no_fe")
	private Integer ca4sdNoFe;

	@Column(name = "ca_4sd_no_fe_pick")
	private Integer ca4sdNoFePick;

	@Column(name = "ca_4sd_fe")
	private Integer ca4sdFe;

	@Column(name = "ca_4sd_fe_pick")
	private Integer ca4sdFePick;

	@Column(name = "ca_4sh_no_fe")
	private Integer ca4shNoFe;

	@Column(name = "ca_4sh_no_fe_pick")
	private Integer ca4shNoFePick;

	@Column(name = "ca_4sh_fe")
	private Integer ca4shFe;

	@Column(name = "ca_4sh_fe_pick")
	private Integer ca4shFePick;

	@Column(name = "eta")
	private LocalDate eta;
	
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

	/**
	 * @return the proyeccionDetalleId
	 */
	public ProyeccionDetalleId getProyeccionDetalleId() {
		return proyeccionDetalleId;
	}

	/**
	 * @param proyeccionDetalleId the proyeccionDetalleId to set
	 */
	public void setProyeccionDetalleId(ProyeccionDetalleId proyeccionDetalleId) {
		this.proyeccionDetalleId = proyeccionDetalleId;
	}

	/**
	 * @return the proyeccion
	 */
	public Proyeccion getProyeccion() {
		return proyeccion;
	}

	/**
	 * @param proyeccion the proyeccion to set
	 */
	public void setProyeccion(Proyeccion proyeccion) {
		this.proyeccion = proyeccion;
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
	 * @return the ca2sdNoFe
	 */
	public Integer getCa2sdNoFe() {
		return ca2sdNoFe;
	}

	/**
	 * @param ca2sdNoFe the ca2sdNoFe to set
	 */
	public void setCa2sdNoFe(Integer ca2sdNoFe) {
		this.ca2sdNoFe = ca2sdNoFe;
	}

	/**
	 * @return the ca2sdNoFePick
	 */
	public Integer getCa2sdNoFePick() {
		return ca2sdNoFePick;
	}

	/**
	 * @param ca2sdNoFePick the ca2sdNoFePick to set
	 */
	public void setCa2sdNoFePick(Integer ca2sdNoFePick) {
		this.ca2sdNoFePick = ca2sdNoFePick;
	}

	/**
	 * @return the ca2sdFe
	 */
	public Integer getCa2sdFe() {
		return ca2sdFe;
	}

	/**
	 * @param ca2sdFe the ca2sdFe to set
	 */
	public void setCa2sdFe(Integer ca2sdFe) {
		this.ca2sdFe = ca2sdFe;
	}

	/**
	 * @return the ca2sdFePick
	 */
	public Integer getCa2sdFePick() {
		return ca2sdFePick;
	}

	/**
	 * @param ca2sdFePick the ca2sdFePick to set
	 */
	public void setCa2sdFePick(Integer ca2sdFePick) {
		this.ca2sdFePick = ca2sdFePick;
	}

	/**
	 * @return the ca4sdNoFe
	 */
	public Integer getCa4sdNoFe() {
		return ca4sdNoFe;
	}

	/**
	 * @param ca4sdNoFe the ca4sdNoFe to set
	 */
	public void setCa4sdNoFe(Integer ca4sdNoFe) {
		this.ca4sdNoFe = ca4sdNoFe;
	}

	/**
	 * @return the ca4sdNoFePick
	 */
	public Integer getCa4sdNoFePick() {
		return ca4sdNoFePick;
	}

	/**
	 * @param ca4sdNoFePick the ca4sdNoFePick to set
	 */
	public void setCa4sdNoFePick(Integer ca4sdNoFePick) {
		this.ca4sdNoFePick = ca4sdNoFePick;
	}

	/**
	 * @return the ca4sdFe
	 */
	public Integer getCa4sdFe() {
		return ca4sdFe;
	}

	/**
	 * @param ca4sdFe the ca4sdFe to set
	 */
	public void setCa4sdFe(Integer ca4sdFe) {
		this.ca4sdFe = ca4sdFe;
	}

	/**
	 * @return the ca4sdFePick
	 */
	public Integer getCa4sdFePick() {
		return ca4sdFePick;
	}

	/**
	 * @param ca4sdFePick the ca4sdFePick to set
	 */
	public void setCa4sdFePick(Integer ca4sdFePick) {
		this.ca4sdFePick = ca4sdFePick;
	}

	/**
	 * @return the ca4shNoFe
	 */
	public Integer getCa4shNoFe() {
		return ca4shNoFe;
	}

	/**
	 * @param ca4shNoFe the ca4shNoFe to set
	 */
	public void setCa4shNoFe(Integer ca4shNoFe) {
		this.ca4shNoFe = ca4shNoFe;
	}

	/**
	 * @return the ca4shNoFePick
	 */
	public Integer getCa4shNoFePick() {
		return ca4shNoFePick;
	}

	/**
	 * @param ca4shNoFePick the ca4shNoFePick to set
	 */
	public void setCa4shNoFePick(Integer ca4shNoFePick) {
		this.ca4shNoFePick = ca4shNoFePick;
	}

	/**
	 * @return the ca4shFe
	 */
	public Integer getCa4shFe() {
		return ca4shFe;
	}

	/**
	 * @param ca4shFe the ca4shFe to set
	 */
	public void setCa4shFe(Integer ca4shFe) {
		this.ca4shFe = ca4shFe;
	}

	/**
	 * @return the ca4shFePick
	 */
	public Integer getCa4shFePick() {
		return ca4shFePick;
	}

	/**
	 * @param ca4shFePick the ca4shFePick to set
	 */
	public void setCa4shFePick(Integer ca4shFePick) {
		this.ca4shFePick = ca4shFePick;
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
		return "ProyeccionDetalle [proyeccionDetalleId=" + proyeccionDetalleId + ", proyeccion=" + proyeccion
				+ ", nave=" + nave + ", viaje=" + viaje + ", ca2sdNoFe=" + ca2sdNoFe + ", ca2sdNoFePick="
				+ ca2sdNoFePick + ", ca2sdFe=" + ca2sdFe + ", ca2sdFePick=" + ca2sdFePick + ", ca4sdNoFe=" + ca4sdNoFe
				+ ", ca4sdNoFePick=" + ca4sdNoFePick + ", ca4sdFe=" + ca4sdFe + ", ca4sdFePick=" + ca4sdFePick
				+ ", ca4shNoFe=" + ca4shNoFe + ", ca4shNoFePick=" + ca4shNoFePick + ", ca4shFe=" + ca4shFe
				+ ", ca4shFePick=" + ca4shFePick + ", eta=" + eta + ", usCrea=" + usCrea + ", usModi=" + usModi
				+ ", feCrea=" + feCrea + ", feModi=" + feModi + "]";
	}
}
