package com.wollcorp.gacela.entity;

import java.io.Serializable;
import java.util.Date;

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
	private String vsl_voy_s;

	@Column(name = "booking_nro")
	private String bookingNro;

	@Column(name = "rvs")
	private String rvs;

	@Column(name = "qty")
	private int qty;

	@Column(name = "pick")
	private int pick;

	@Column(name = "balance")
	private int balance;

	@Column(name = "mode")
	private String mode;

	@Column(name = "mta")
	private String mta;

	@Column(name = "tpe")
	private String tpe;

	@Column(name = "rct")
	private String rct;

	@Column(name = "pol")
	private String pol;

	@Column(name = "pod")
	private String pod;

	@Column(name = "dly")
	private String dly;

	@Column(name = "release")
	private Date release;

	@Column(name = "cut_off")
	private Date cutOff;

	@Column(name = "dry_use")
	private String dryUse;

	@Column(name = "pre_cool")
	private String pre_cool;

	@Column(name = "temp")
	private String temp;

	@Column(name = "vent")
	private int vent;

	@Column(name = "commodity")
	private String commodity;

	@Column(name = "special_handling")
	private String specialHandling;

	@Column(name = "customer_ac")
	private String customerAc;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "remark")
	private String remark;

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
	 * @return the vsl_voy_s
	 */
	public String getVsl_voy_s() {
		return vsl_voy_s;
	}

	/**
	 * @param vsl_voy_s the vsl_voy_s to set
	 */
	public void setVsl_voy_s(String vsl_voy_s) {
		this.vsl_voy_s = vsl_voy_s;
	}

	/**
	 * @return the bookingNro
	 */
	public String getBookingNro() {
		return bookingNro;
	}

	/**
	 * @param bookingNro the bookingNro to set
	 */
	public void setBookingNro(String bookingNro) {
		this.bookingNro = bookingNro;
	}

	/**
	 * @return the rvs
	 */
	public String getRvs() {
		return rvs;
	}

	/**
	 * @param rvs the rvs to set
	 */
	public void setRvs(String rvs) {
		this.rvs = rvs;
	}

	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}

	/**
	 * @return the pick
	 */
	public int getPick() {
		return pick;
	}

	/**
	 * @param pick the pick to set
	 */
	public void setPick(int pick) {
		this.pick = pick;
	}

	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
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
	 * @return the mta
	 */
	public String getMta() {
		return mta;
	}

	/**
	 * @param mta the mta to set
	 */
	public void setMta(String mta) {
		this.mta = mta;
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
	 * @return the rct
	 */
	public String getRct() {
		return rct;
	}

	/**
	 * @param rct the rct to set
	 */
	public void setRct(String rct) {
		this.rct = rct;
	}

	/**
	 * @return the pol
	 */
	public String getPol() {
		return pol;
	}

	/**
	 * @param pol the pol to set
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}

	/**
	 * @return the pod
	 */
	public String getPod() {
		return pod;
	}

	/**
	 * @param pod the pod to set
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}

	/**
	 * @return the dly
	 */
	public String getDly() {
		return dly;
	}

	/**
	 * @param dly the dly to set
	 */
	public void setDly(String dly) {
		this.dly = dly;
	}

	/**
	 * @return the release
	 */
	public Date getRelease() {
		return release;
	}

	/**
	 * @param release the release to set
	 */
	public void setRelease(Date release) {
		this.release = release;
	}

	/**
	 * @return the cutOff
	 */
	public Date getCutOff() {
		return cutOff;
	}

	/**
	 * @param cutOff the cutOff to set
	 */
	public void setCutOff(Date cutOff) {
		this.cutOff = cutOff;
	}

	/**
	 * @return the dryUse
	 */
	public String getDryUse() {
		return dryUse;
	}

	/**
	 * @param dryUse the dryUse to set
	 */
	public void setDryUse(String dryUse) {
		this.dryUse = dryUse;
	}

	/**
	 * @return the pre_cool
	 */
	public String getPre_cool() {
		return pre_cool;
	}

	/**
	 * @param pre_cool the pre_cool to set
	 */
	public void setPre_cool(String pre_cool) {
		this.pre_cool = pre_cool;
	}

	/**
	 * @return the temp
	 */
	public String getTemp() {
		return temp;
	}

	/**
	 * @param temp the temp to set
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}

	/**
	 * @return the vent
	 */
	public int getVent() {
		return vent;
	}

	/**
	 * @param vent the vent to set
	 */
	public void setVent(int vent) {
		this.vent = vent;
	}

	/**
	 * @return the commodity
	 */
	public String getCommodity() {
		return commodity;
	}

	/**
	 * @param commodity the commodity to set
	 */
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	/**
	 * @return the specialHandling
	 */
	public String getSpecialHandling() {
		return specialHandling;
	}

	/**
	 * @param specialHandling the specialHandling to set
	 */
	public void setSpecialHandling(String specialHandling) {
		this.specialHandling = specialHandling;
	}

	/**
	 * @return the customerAc
	 */
	public String getCustomerAc() {
		return customerAc;
	}

	/**
	 * @param customerAc the customerAc to set
	 */
	public void setCustomerAc(String customerAc) {
		this.customerAc = customerAc;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Mtc1r999Detalle [mtc1r999DetalleId=" + mtc1r999DetalleId + ", mtc1r999=" + mtc1r999 + ", depot=" + depot
				+ ", nave=" + nave + ", viaje=" + viaje + ", vsl_voy_s=" + vsl_voy_s + ", bookingNro=" + bookingNro
				+ ", rvs=" + rvs + ", qty=" + qty + ", pick=" + pick + ", balance=" + balance + ", mode=" + mode
				+ ", mta=" + mta + ", tpe=" + tpe + ", rct=" + rct + ", pol=" + pol + ", pod=" + pod + ", dly=" + dly
				+ ", release=" + release + ", cutOff=" + cutOff + ", dryUse=" + dryUse + ", pre_cool=" + pre_cool
				+ ", temp=" + temp + ", vent=" + vent + ", commodity=" + commodity + ", specialHandling="
				+ specialHandling + ", customerAc=" + customerAc + ", customerName=" + customerName + ", remark="
				+ remark + "]";
	}

}
