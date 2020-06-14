package com.wollcorp.gacela.entity.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Mtc1r999DetalleId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_mtc1r999")
	private Long idMtc1r999;

	@Column(name = "item")
	private Integer item;

	public Mtc1r999DetalleId() {

	}

	public Mtc1r999DetalleId(Long idMtc1r999, Integer item) {
		this.idMtc1r999 = idMtc1r999;
		this.item = item;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMtc1r999 == null) ? 0 : idMtc1r999.hashCode());
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
		Mtc1r999DetalleId other = (Mtc1r999DetalleId) obj;
		if (idMtc1r999 == null) {
			if (other.idMtc1r999 != null)
				return false;
		} else if (!idMtc1r999.equals(other.idMtc1r999))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

}
