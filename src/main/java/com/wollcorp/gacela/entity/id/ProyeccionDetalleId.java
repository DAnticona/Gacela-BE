package com.wollcorp.gacela.entity.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProyeccionDetalleId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_proyeccion")
	private Long idProyeccion;

	@Column(name = "item")
	private Integer item;

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
	 * @return the item
	 */
	public Integer getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Integer item) {
		this.item = item;
	}

	public ProyeccionDetalleId() {

	}

	public ProyeccionDetalleId(Long idProyeccion, Integer item) {
		this.idProyeccion = idProyeccion;
		this.item = item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProyeccion == null) ? 0 : idProyeccion.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
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
		ProyeccionDetalleId other = (ProyeccionDetalleId) obj;
		if (idProyeccion == null) {
			if (other.idProyeccion != null)
				return false;
		} else if (!idProyeccion.equals(other.idProyeccion))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

}
