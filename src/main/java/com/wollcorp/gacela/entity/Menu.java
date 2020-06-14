package com.wollcorp.gacela.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "menu")
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_menu")
	private Integer idMenu;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "orden")
	private Integer orden;

	@Column(name = "icono")
	private String icono;

	@Column(name = "us_crea")
	private String usCrea;

	@Column(name = "us_modi")
	private String usModi;

	@Column(name = "fe_crea")
	private LocalDateTime feCrea;

	@Column(name = "fe_modi")
	private LocalDateTime feModi;

	@OneToMany(mappedBy = "menu")
	@JsonManagedReference
	private List<Submenu> submenus;

	/**
	 * @return the idMenu
	 */
	public Integer getIdMenu() {
		return idMenu;
	}

	/**
	 * @param idMenu the idMenu to set
	 */
	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
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
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * @param orden the orden to set
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	/**
	 * @return the icono
	 */
	public String getIcono() {
		return icono;
	}

	/**
	 * @param icono the icono to set
	 */
	public void setIcono(String icono) {
		this.icono = icono;
	}

	/**
	 * @return the submenus
	 */
	public List<Submenu> getSubmenus() {
		return submenus;
	}

	/**
	 * @param submenus the submenus to set
	 */
	public void setSubmenus(List<Submenu> submenus) {
		this.submenus = submenus;
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
		return "Menu [idMenu=" + idMenu + ", nombre=" + nombre + ", orden=" + orden + ", icono=" + icono + ", usCrea="
				+ usCrea + ", usModi=" + usModi + ", feCrea=" + feCrea + ", feModi=" + feModi + "]";
	}

}
