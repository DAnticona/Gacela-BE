package com.wollcorp.gacela.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wollcorp.gacela.entity.id.ProyeccionRpoId;

@Entity
@Table(name = "proyeccion_rpo")
public class ProyeccionRpo implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProyeccionRpoId proyeccionRpoId;

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

	@Column(name = "rpo_2sd")
	private Integer rpo_2sd;

	@Column(name = "rpo_4sd")
	private Integer rpo_4sd;

	@Column(name = "rpo_4sh")
	private Integer rpo_4sh;

	@Column(name = "eta")
	private LocalDate eta;

	/**
	 * @return the proyeccionRpoId
	 */
	public ProyeccionRpoId getProyeccionRpoId() {
		return proyeccionRpoId;
	}

	/**
	 * @param proyeccionRpoId the proyeccionRpoId to set
	 */
	public void setProyeccionRpoId(ProyeccionRpoId proyeccionRpoId) {
		this.proyeccionRpoId = proyeccionRpoId;
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
	 * @return the rpo_2sd
	 */
	public Integer getRpo_2sd() {
		return rpo_2sd;
	}

	/**
	 * @param rpo_2sd the rpo_2sd to set
	 */
	public void setRpo_2sd(Integer rpo_2sd) {
		this.rpo_2sd = rpo_2sd;
	}

	/**
	 * @return the rpo_4sd
	 */
	public Integer getRpo_4sd() {
		return rpo_4sd;
	}

	/**
	 * @param rpo_4sd the rpo_4sd to set
	 */
	public void setRpo_4sd(Integer rpo_4sd) {
		this.rpo_4sd = rpo_4sd;
	}

	/**
	 * @return the rpo_4sh
	 */
	public Integer getRpo_4sh() {
		return rpo_4sh;
	}

	/**
	 * @param rpo_4sh the rpo_4sh to set
	 */
	public void setRpo_4sh(Integer rpo_4sh) {
		this.rpo_4sh = rpo_4sh;
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

	@Override
	public String toString() {
		return "ProyeccionRpo [proyeccionRpoId=" + proyeccionRpoId + ", proyeccion=" + proyeccion + ", nave=" + nave
				+ ", viaje=" + viaje + ", rpo_2sd=" + rpo_2sd + ", rpo_4sd=" + rpo_4sd + ", rpo_4sh=" + rpo_4sh
				+ ", eta=" + eta + "]";
	}

}
