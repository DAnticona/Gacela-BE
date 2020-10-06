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
import com.wollcorp.gacela.entity.id.Mtc1r999DetalleId;

@Entity
@Table(name = "mtc1r999_detalle")
public class Mtc1r999Detalle implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Mtc1r999DetalleId mtc1r999DetalleId;

	@MapsId("idMtc1r999")
	@ManyToOne
	@JoinColumn(name = "id_mtc1r999", referencedColumnName = "id_mtc1r999")
	@JsonBackReference
	private Mtc1r999 mtc1r999;

	@Column(name = "depot")
	private String depot;

	@Column(name = "nave")
	private String nave;

	@Column(name = "viaje")
	private String viaje;

	@Column(name = "vsl_voy_s")
	private String vslVoyS;

	@Column(name = "booking_nro")
	private String bookingNo;

	@Column(name = "qty")
	private Integer qty;

	@Column(name = "pick")
	private Integer pick;

	@Column(name = "mode")
	private String mode;

	@Column(name = "tpe")
	private String tpe;

	@Column(name = "cut_off")
	private LocalDate cutOff;

	/**
	 * @return the mtc1r999DetalleId
	 */
	public Mtc1r999DetalleId getMtc1r999DetalleId() {
		return mtc1r999DetalleId;
	}

	/**
	 * @param mtc1r999DetalleId the mtc1r999DetalleId to set
	 */
	public void setMtc1r999DetalleId(Mtc1r999DetalleId mtc1r999DetalleId) {
		this.mtc1r999DetalleId = mtc1r999DetalleId;
	}

	/**
	 * @return the mtc1r999
	 */
	public Mtc1r999 getMtc1r999() {
		return mtc1r999;
	}

	/**
	 * @param mtc1r999 the mtc1r999 to set
	 */
	public void setMtc1r999(Mtc1r999 mtc1r999) {
		this.mtc1r999 = mtc1r999;
	}

	/**
	 * @return the depot
	 */
	public String getDepot() {
		return depot;
	}

	/**
	 * @param depot the depot to set
	 */
	public void setDepot(String depot) {
		this.depot = depot;
	}

	/**
	 * @return the nave
	 */
	public String getNave() {
		return nave;
	}

	/**
	 * @param nave the nave to set
	 */
	public void setNave(String nave) {
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
	 * @return the vslVoyS
	 */
	public String getVslVoyS() {
		return vslVoyS;
	}

	/**
	 * @param vslVoyS the vslVoyS to set
	 */
	public void setVslVoyS(String vslVoyS) {
		this.vslVoyS = vslVoyS;
	}

	/**
	 * @return the bookingNo
	 */
	public String getBookingNo() {
		return bookingNo;
	}

	/**
	 * @param bookingNo the bookingNo to set
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}

	/**
	 * @return the qty
	 */
	public Integer getQty() {
		return qty;
	}

	/**
	 * @param qty the qty to set
	 */
	public void setQty(Integer qty) {
		this.qty = qty;
	}

	/**
	 * @return the pick
	 */
	public Integer getPick() {
		return pick;
	}

	/**
	 * @param pick the pick to set
	 */
	public void setPick(Integer pick) {
		this.pick = pick;
	}

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @return the tpe
	 */
	public String getTpe() {
		return tpe;
	}

	/**
	 * @param tpe the tpe to set
	 */
	public void setTpe(String tpe) {
		this.tpe = tpe;
	}

	/**
	 * @return the cutOff
	 */
	public LocalDate getCutOff() {
		return cutOff;
	}

	/**
	 * @param cutOff the cutOff to set
	 */
	public void setCutOff(LocalDate cutOff) {
		this.cutOff = cutOff;
	}

	@Override
	public String toString() {
		return "Mtc1r999Detalle [mtc1r999DetalleId=" + mtc1r999DetalleId + ", mtc1r999=" + mtc1r999 + ", depot=" + depot
				+ ", nave=" + nave + ", viaje=" + viaje + ", vslVoyS=" + vslVoyS + ", bookingNo=" + bookingNo + ", qty="
				+ qty + ", pick=" + pick + ", mode=" + mode + ", tpe=" + tpe + ", cutOff=" + cutOff + "]";
	}
}
