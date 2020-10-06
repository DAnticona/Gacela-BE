package com.wollcorp.gacela.entity.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SubmenuId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_menu")
	private Integer idMenu;

	@Column(name = "id_submenu")
	private Integer idSubmenu;

	public SubmenuId() {

	}

	public SubmenuId(Integer idMenu, Integer idSubmenu) {
		this.idMenu = idMenu;
		this.idSubmenu = idSubmenu;
	}

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
	 * @return the idSubmenu
	 */
	public Integer getIdSubmenu() {
		return idSubmenu;
	}

	/**
	 * @param idSubmenu the idSubmenu to set
	 */
	public void setIdSubmenu(Integer idSubmenu) {
		this.idSubmenu = idSubmenu;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMenu == null) ? 0 : idMenu.hashCode());
		result = prime * result + ((idSubmenu == null) ? 0 : idSubmenu.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubmenuId other = (SubmenuId) obj;
		if (idMenu == null) {
			if (other.idMenu != null)
				return false;
		} else if (!idMenu.equals(other.idMenu))
			return false;
		if (idSubmenu == null) {
			if (other.idSubmenu != null)
				return false;
		} else if (!idSubmenu.equals(other.idSubmenu))
			return false;
		return true;
	}

}
