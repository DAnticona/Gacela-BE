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
@Table(name = "proyeccion")
@EntityListeners(AuditingEntityListener.class)
public class Proyeccion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proyeccion")
	private Long idProyeccion;

	@Column(name = "id_mtc1r999")
	private Long idMtc1r999;
	
	@Column(name="id_pro_ventas")
	private Long idProVentas;
	
	@Column(name="id_pro_unificada")
	private Long idProUnificada;

	@Column(name = "fe_proyeccion")
	private LocalDate feProyeccion;

	@Column(name = "fg_tipo")
	private String fgTipo;

	@Column(name = "fg_acti")
	private String fgActi;

	@Column(name = "ratio_2sd")
	private Integer ratio2sd;

	@Column(name = "ratio_4sd")
	private Integer ratio4sd;

	@Column(name = "ratio_4sh")
	private Integer ratio4sh;

	@Column(name = "nu_semana")
	private Integer nuSemana;

	@Column(name = "stock_2sd")
	private Integer stock2sd;

	@Column(name = "stock_4sd")
	private Integer stock4sd;

	@Column(name = "stock_4sh")
	private Integer stock4sh;

	@Column(name = "to_2sd_no_fe")
	private Integer to2sdNoFe;

	@Column(name = "to_2sd_no_fe_pick")
	private Integer to2sdNoFePick;

	@Column(name = "to_2sd_fe")
	private Integer to2sdFe;

	@Column(name = "to_2sd_fe_pick")
	private Integer to2sdFePick;

	@Column(name = "to_4sd_no_fe")
	private Integer to4sdNoFe;

	@Column(name = "to_4sd_no_fe_pick")
	private Integer to4sdNoFePick;

	@Column(name = "to_4sd_fe")
	private Integer to4sdFe;

	@Column(name = "to_4sd_fe_pick")
	private Integer to4sdFePick;

	@Column(name = "to_4sh_no_fe")
	private Integer to4shNoFe;

	@Column(name = "to_4sh_no_fe_pick")
	private Integer to4shNoFePick;

	@Column(name = "to_4sh_fe")
	private Integer to4shFe;

	@Column(name = "to_4sh_fe_pick")
	private Integer to4shFePick;

	@Column(name = "to_2sd_book")
	private Integer to2sdBook;

	@Column(name = "to_4sd_book")
	private Integer to4sdBook;

	@Column(name = "to_4sh_book")
	private Integer to4shBook;

	@Column(name = "to_2sd_pick")
	private Integer to2sdPick;

	@Column(name = "to_4sd_pick")
	private Integer to4sdPick;

	@Column(name = "to_4sh_pick")
	private Integer to4shPick;

	@Column(name = "nu_dias_habiles")
	private Integer nuDiasHabiles;

	@Column(name = "nu_dias_retorno")
	private Integer nuDiasRetorno;

	@Column(name = "fe_empty_return")
	private LocalDate feEmptyReturn;

	@Column(name = "empty_ret_2sd")
	private Integer emptyRet2sd;

	@Column(name = "empty_ret_4sd")
	private Integer emptyRet4sd;

	@Column(name = "empty_ret_4sh")
	private Integer emptyRet4sh;

	@Column(name = "available_2sd")
	private Integer available2sd;

	@Column(name = "available_4sd")
	private Integer available4sd;

	@Column(name = "available_4sh")
	private Integer available4sh;

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

	@OneToMany(mappedBy = "proyeccion")
	@JsonManagedReference
	private List<ProyeccionDetalle> detalle;

	@OneToMany(mappedBy = "proyeccion")
	@JsonManagedReference
	private List<ProyeccionRpo> rpo;

	public Proyeccion() {
	}

	public Proyeccion(Long idProyeccion) {
		this.idProyeccion = idProyeccion;
	}

	/**
	 * @return the idProyeccion
	 */
	public Long getIdProyeccion() {
		return idProyeccion;
	}

	/**
	 * @param idProyeccion the idProyeccion to set
	 */
	public void setIdProyeccion(Long idProyeccion) {
		this.idProyeccion = idProyeccion;
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
	 * @return the idProVentas
	 */
	public Long getIdProVentas() {
		return idProVentas;
	}

	/**
	 * @param idProVentas the idProVentas to set
	 */
	public void setIdProVentas(Long idProVentas) {
		this.idProVentas = idProVentas;
	}

	/**
	 * @return the idProUnificada
	 */
	public Long getIdProUnificada() {
		return idProUnificada;
	}

	/**
	 * @param idProUnificada the idProUnificada to set
	 */
	public void setIdProUnificada(Long idProUnificada) {
		this.idProUnificada = idProUnificada;
	}

	/**
	 * @return the feProyeccion
	 */
	public LocalDate getFeProyeccion() {
		return feProyeccion;
	}

	/**
	 * @param feProyeccion the feProyeccion to set
	 */
	public void setFeProyeccion(LocalDate feProyeccion) {
		this.feProyeccion = feProyeccion;
	}

	/**
	 * @return the fgTipo
	 */
	public String getFgTipo() {
		return fgTipo;
	}

	/**
	 * @param fgTipo the fgTipo to set
	 */
	public void setFgTipo(String fgTipo) {
		this.fgTipo = fgTipo;
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
	 * @return the nuSemana
	 */
	public Integer getNuSemana() {
		return nuSemana;
	}

	/**
	 * @param nuSemana the nuSemana to set
	 */
	public void setNuSemana(Integer nuSemana) {
		this.nuSemana = nuSemana;
	}

	/**
	 * @return the stock2sd
	 */
	public Integer getStock2sd() {
		return stock2sd;
	}

	/**
	 * @param stock2sd the stock2sd to set
	 */
	public void setStock2sd(Integer stock2sd) {
		this.stock2sd = stock2sd;
	}

	/**
	 * @return the stock4sd
	 */
	public Integer getStock4sd() {
		return stock4sd;
	}

	/**
	 * @param stock4sd the stock4sd to set
	 */
	public void setStock4sd(Integer stock4sd) {
		this.stock4sd = stock4sd;
	}

	/**
	 * @return the stock4sh
	 */
	public Integer getStock4sh() {
		return stock4sh;
	}

	/**
	 * @param stock4sh the stock4sh to set
	 */
	public void setStock4sh(Integer stock4sh) {
		this.stock4sh = stock4sh;
	}

	/**
	 * @return the to2sdNoFe
	 */
	public Integer getTo2sdNoFe() {
		return to2sdNoFe;
	}

	/**
	 * @param to2sdNoFe the to2sdNoFe to set
	 */
	public void setTo2sdNoFe(Integer to2sdNoFe) {
		this.to2sdNoFe = to2sdNoFe;
	}

	/**
	 * @return the to2sdNoFePick
	 */
	public Integer getTo2sdNoFePick() {
		return to2sdNoFePick;
	}

	/**
	 * @param to2sdNoFePick the to2sdNoFePick to set
	 */
	public void setTo2sdNoFePick(Integer to2sdNoFePick) {
		this.to2sdNoFePick = to2sdNoFePick;
	}

	/**
	 * @return the to2sdFe
	 */
	public Integer getTo2sdFe() {
		return to2sdFe;
	}

	/**
	 * @param to2sdFe the to2sdFe to set
	 */
	public void setTo2sdFe(Integer to2sdFe) {
		this.to2sdFe = to2sdFe;
	}

	/**
	 * @return the to2sdFePick
	 */
	public Integer getTo2sdFePick() {
		return to2sdFePick;
	}

	/**
	 * @param to2sdFePick the to2sdFePick to set
	 */
	public void setTo2sdFePick(Integer to2sdFePick) {
		this.to2sdFePick = to2sdFePick;
	}

	/**
	 * @return the to4sdNoFe
	 */
	public Integer getTo4sdNoFe() {
		return to4sdNoFe;
	}

	/**
	 * @param to4sdNoFe the to4sdNoFe to set
	 */
	public void setTo4sdNoFe(Integer to4sdNoFe) {
		this.to4sdNoFe = to4sdNoFe;
	}

	/**
	 * @return the to4sdNoFePick
	 */
	public Integer getTo4sdNoFePick() {
		return to4sdNoFePick;
	}

	/**
	 * @param to4sdNoFePick the to4sdNoFePick to set
	 */
	public void setTo4sdNoFePick(Integer to4sdNoFePick) {
		this.to4sdNoFePick = to4sdNoFePick;
	}

	/**
	 * @return the to4sdFe
	 */
	public Integer getTo4sdFe() {
		return to4sdFe;
	}

	/**
	 * @param to4sdFe the to4sdFe to set
	 */
	public void setTo4sdFe(Integer to4sdFe) {
		this.to4sdFe = to4sdFe;
	}

	/**
	 * @return the to4sdFePick
	 */
	public Integer getTo4sdFePick() {
		return to4sdFePick;
	}

	/**
	 * @param to4sdFePick the to4sdFePick to set
	 */
	public void setTo4sdFePick(Integer to4sdFePick) {
		this.to4sdFePick = to4sdFePick;
	}

	/**
	 * @return the to4shNoFe
	 */
	public Integer getTo4shNoFe() {
		return to4shNoFe;
	}

	/**
	 * @param to4shNoFe the to4shNoFe to set
	 */
	public void setTo4shNoFe(Integer to4shNoFe) {
		this.to4shNoFe = to4shNoFe;
	}

	/**
	 * @return the to4shNoFePick
	 */
	public Integer getTo4shNoFePick() {
		return to4shNoFePick;
	}

	/**
	 * @param to4shNoFePick the to4shNoFePick to set
	 */
	public void setTo4shNoFePick(Integer to4shNoFePick) {
		this.to4shNoFePick = to4shNoFePick;
	}

	/**
	 * @return the to4shFe
	 */
	public Integer getTo4shFe() {
		return to4shFe;
	}

	/**
	 * @param to4shFe the to4shFe to set
	 */
	public void setTo4shFe(Integer to4shFe) {
		this.to4shFe = to4shFe;
	}

	/**
	 * @return the to4shFePick
	 */
	public Integer getTo4shFePick() {
		return to4shFePick;
	}

	/**
	 * @param to4shFePick the to4shFePick to set
	 */
	public void setTo4shFePick(Integer to4shFePick) {
		this.to4shFePick = to4shFePick;
	}

	/**
	 * @return the to2sdBook
	 */
	public Integer getTo2sdBook() {
		return to2sdBook;
	}

	/**
	 * @param to2sdBook the to2sdBook to set
	 */
	public void setTo2sdBook(Integer to2sdBook) {
		this.to2sdBook = to2sdBook;
	}

	/**
	 * @return the to4sdBook
	 */
	public Integer getTo4sdBook() {
		return to4sdBook;
	}

	/**
	 * @param to4sdBook the to4sdBook to set
	 */
	public void setTo4sdBook(Integer to4sdBook) {
		this.to4sdBook = to4sdBook;
	}

	/**
	 * @return the to4shBook
	 */
	public Integer getTo4shBook() {
		return to4shBook;
	}

	/**
	 * @param to4shBook the to4shBook to set
	 */
	public void setTo4shBook(Integer to4shBook) {
		this.to4shBook = to4shBook;
	}

	/**
	 * @return the to2sdPick
	 */
	public Integer getTo2sdPick() {
		return to2sdPick;
	}

	/**
	 * @param to2sdPick the to2sdPick to set
	 */
	public void setTo2sdPick(Integer to2sdPick) {
		this.to2sdPick = to2sdPick;
	}

	/**
	 * @return the to4sdPick
	 */
	public Integer getTo4sdPick() {
		return to4sdPick;
	}

	/**
	 * @param to4sdPick the to4sdPick to set
	 */
	public void setTo4sdPick(Integer to4sdPick) {
		this.to4sdPick = to4sdPick;
	}

	/**
	 * @return the to4shPick
	 */
	public Integer getTo4shPick() {
		return to4shPick;
	}

	/**
	 * @param to4shPick the to4shPick to set
	 */
	public void setTo4shPick(Integer to4shPick) {
		this.to4shPick = to4shPick;
	}

	/**
	 * @return the nuDiasHabiles
	 */
	public Integer getNuDiasHabiles() {
		return nuDiasHabiles;
	}

	/**
	 * @param nuDiasHabiles the nuDiasHabiles to set
	 */
	public void setNuDiasHabiles(Integer nuDiasHabiles) {
		this.nuDiasHabiles = nuDiasHabiles;
	}

	/**
	 * @return the nuDiasRetorno
	 */
	public Integer getNuDiasRetorno() {
		return nuDiasRetorno;
	}

	/**
	 * @param nuDiasRetorno the nuDiasRetorno to set
	 */
	public void setNuDiasRetorno(Integer nuDiasRetorno) {
		this.nuDiasRetorno = nuDiasRetorno;
	}

	/**
	 * @return the feEmptyReturn
	 */
	public LocalDate getFeEmptyReturn() {
		return feEmptyReturn;
	}

	/**
	 * @param feEmptyReturn the feEmptyReturn to set
	 */
	public void setFeEmptyReturn(LocalDate feEmptyReturn) {
		this.feEmptyReturn = feEmptyReturn;
	}

	/**
	 * @return the emptyRet2sd
	 */
	public Integer getEmptyRet2sd() {
		return emptyRet2sd;
	}

	/**
	 * @param emptyRet2sd the emptyRet2sd to set
	 */
	public void setEmptyRet2sd(Integer emptyRet2sd) {
		this.emptyRet2sd = emptyRet2sd;
	}

	/**
	 * @return the emptyRet4sd
	 */
	public Integer getEmptyRet4sd() {
		return emptyRet4sd;
	}

	/**
	 * @param emptyRet4sd the emptyRet4sd to set
	 */
	public void setEmptyRet4sd(Integer emptyRet4sd) {
		this.emptyRet4sd = emptyRet4sd;
	}

	/**
	 * @return the emptyRet4sh
	 */
	public Integer getEmptyRet4sh() {
		return emptyRet4sh;
	}

	/**
	 * @param emptyRet4sh the emptyRet4sh to set
	 */
	public void setEmptyRet4sh(Integer emptyRet4sh) {
		this.emptyRet4sh = emptyRet4sh;
	}

	/**
	 * @return the available2sd
	 */
	public Integer getAvailable2sd() {
		return available2sd;
	}

	/**
	 * @param available2sd the available2sd to set
	 */
	public void setAvailable2sd(Integer available2sd) {
		this.available2sd = available2sd;
	}

	/**
	 * @return the available4sd
	 */
	public Integer getAvailable4sd() {
		return available4sd;
	}

	/**
	 * @param available4sd the available4sd to set
	 */
	public void setAvailable4sd(Integer available4sd) {
		this.available4sd = available4sd;
	}

	/**
	 * @return the available4sh
	 */
	public Integer getAvailable4sh() {
		return available4sh;
	}

	/**
	 * @param available4sh the available4sh to set
	 */
	public void setAvailable4sh(Integer available4sh) {
		this.available4sh = available4sh;
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
	public List<ProyeccionDetalle> getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<ProyeccionDetalle> detalle) {
		this.detalle = detalle;
	}

	/**
	 * @return the rpo
	 */
	public List<ProyeccionRpo> getRpo() {
		return rpo;
	}

	/**
	 * @param rpo the rpo to set
	 */
	public void setRpo(List<ProyeccionRpo> rpo) {
		this.rpo = rpo;
	}

	@Override
	public String toString() {
		return "Proyeccion [idProyeccion=" + idProyeccion + ", idMtc1r999=" + idMtc1r999 + ", idProVentas="
				+ idProVentas + ", idProUnificada=" + idProUnificada + ", feProyeccion=" + feProyeccion + ", fgTipo="
				+ fgTipo + ", fgActi=" + fgActi + ", ratio2sd=" + ratio2sd + ", ratio4sd=" + ratio4sd + ", ratio4sh="
				+ ratio4sh + ", nuSemana=" + nuSemana + ", stock2sd=" + stock2sd + ", stock4sd=" + stock4sd
				+ ", stock4sh=" + stock4sh + ", to2sdNoFe=" + to2sdNoFe + ", to2sdNoFePick=" + to2sdNoFePick
				+ ", to2sdFe=" + to2sdFe + ", to2sdFePick=" + to2sdFePick + ", to4sdNoFe=" + to4sdNoFe
				+ ", to4sdNoFePick=" + to4sdNoFePick + ", to4sdFe=" + to4sdFe + ", to4sdFePick=" + to4sdFePick
				+ ", to4shNoFe=" + to4shNoFe + ", to4shNoFePick=" + to4shNoFePick + ", to4shFe=" + to4shFe
				+ ", to4shFePick=" + to4shFePick + ", to2sdBook=" + to2sdBook + ", to4sdBook=" + to4sdBook
				+ ", to4shBook=" + to4shBook + ", to2sdPick=" + to2sdPick + ", to4sdPick=" + to4sdPick + ", to4shPick="
				+ to4shPick + ", nuDiasHabiles=" + nuDiasHabiles + ", nuDiasRetorno=" + nuDiasRetorno
				+ ", feEmptyReturn=" + feEmptyReturn + ", emptyRet2sd=" + emptyRet2sd + ", emptyRet4sd=" + emptyRet4sd
				+ ", emptyRet4sh=" + emptyRet4sh + ", available2sd=" + available2sd + ", available4sd=" + available4sd
				+ ", available4sh=" + available4sh + ", feVcto=" + feVcto + ", usCrea=" + usCrea + ", usModi=" + usModi
				+ ", feCrea=" + feCrea + ", feModi=" + feModi + "]";
	}
}
