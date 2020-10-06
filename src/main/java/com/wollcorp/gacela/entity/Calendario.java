package com.wollcorp.gacela.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calendario")
public class Calendario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_calendario")
	private Integer idCalendario;

	@Column(name = "dia_mes")
	private Integer diaMes;

	@Column(name = "mes")
	private Integer mes;

	@Column(name = "ano")
	private Integer ano;

	@Column(name = "fecha")
	private LocalDate fecha;

	@Column(name = "dia_sem")
	private Integer diaSem;

	@Column(name = "nu_sem_ano")
	private Integer nuSemAno;

	@Column(name = "fg_feriado")
	private String fgFeriado;

	@Column(name = "us_crea")
	private String usCrea;

	@Column(name = "us_modi")
	private String usModi;

	@Column(name = "fe_crea")
	private LocalDateTime feCrea;

	@Column(name = "fe_modi")
	private LocalDateTime feModi;

	public Calendario() {
	}

	public Calendario(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the idCalendario
	 */
	public Integer getIdCalendario() {
		return idCalendario;
	}

	/**
	 * @param idCalendario the idCalendario to set
	 */
	public void setIdCalendario(Integer idCalendario) {
		this.idCalendario = idCalendario;
	}

	/**
	 * @return the diaMes
	 */
	public Integer getDiaMes() {
		return diaMes;
	}

	/**
	 * @param diaMes the diaMes to set
	 */
	public void setDiaMes(Integer diaMes) {
		this.diaMes = diaMes;
	}

	/**
	 * @return the mes
	 */
	public Integer getMes() {
		return mes;
	}

	/**
	 * @param mes the mes to set
	 */
	public void setMes(Integer mes) {
		this.mes = mes;
	}

	/**
	 * @return the ano
	 */
	public Integer getAno() {
		return ano;
	}

	/**
	 * @param ano the ano to set
	 */
	public void setAno(Integer ano) {
		this.ano = ano;
	}

	/**
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the diaSem
	 */
	public Integer getDiaSem() {
		return diaSem;
	}

	/**
	 * @param diaSem the diaSem to set
	 */
	public void setDiaSem(Integer diaSem) {
		this.diaSem = diaSem;
	}

	/**
	 * @return the nuSemAno
	 */
	public Integer getNuSemAno() {
		return nuSemAno;
	}

	/**
	 * @param nuSemAno the nuSemAno to set
	 */
	public void setNuSemAno(Integer nuSemAno) {
		this.nuSemAno = nuSemAno;
	}

	/**
	 * @return the fgFeriado
	 */
	public String getFgFeriado() {
		return fgFeriado;
	}

	/**
	 * @param fgFeriado the fgFeriado to set
	 */
	public void setFgFeriado(String fgFeriado) {
		this.fgFeriado = fgFeriado;
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
		return "Calendario [idCalendario=" + idCalendario + ", diaMes=" + diaMes + ", mes=" + mes + ", ano=" + ano
				+ ", fecha=" + fecha + ", diaSem=" + diaSem + ", nuSemAno=" + nuSemAno + ", fgFeriado=" + fgFeriado
				+ ", usCrea=" + usCrea + ", usModi=" + usModi + ", feCrea=" + feCrea + ", feModi=" + feModi + "]";
	}

}
