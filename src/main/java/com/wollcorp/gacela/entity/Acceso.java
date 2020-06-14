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
@Table(name = "acceso")
public class Acceso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_acceso")
	private Integer idAcceso;

	@ManyToOne
	@JoinColumn(name = "id_menu", referencedColumnName = "id_menu")
	private Menu menu;

	@ManyToOne
	@JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
	private Rol rol;

	@Column(name = "fg_acceso")
	private String fgAcceso;

	@Column(name = "us_crea")
	private String usCrea;

	@Column(name = "us_modi")
	private String usModi;

	@Column(name = "fe_crea")
	private LocalDateTime feCrea;

	@Column(name = "fe_modi")
	private LocalDateTime feModi;

	/**
	 * @return the idAcceso
	 */
	public Integer getIdAcceso() {
		return idAcceso;
	}

	/**
	 * @param idAcceso the idAcceso to set
	 */
	public void setIdAcceso(Integer idAcceso) {
		this.idAcceso = idAcceso;
	}

	/**
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	/**
	 * @return the rol
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	/**
	 * @return the fgAcceso
	 */
	public String getFgAcceso() {
		return fgAcceso;
	}

	/**
	 * @param fgAcceso the fgAcceso to set
	 */
	public void setFgAcceso(String fgAcceso) {
		this.fgAcceso = fgAcceso;
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
		return "Acceso [idAcceso=" + idAcceso + ", menu=" + menu + ", rol=" + rol + ", fgAcceso=" + fgAcceso
				+ ", usCrea=" + usCrea + ", usModi=" + usModi + ", feCrea=" + feCrea + ", feModi=" + feModi + "]";
	}

}
