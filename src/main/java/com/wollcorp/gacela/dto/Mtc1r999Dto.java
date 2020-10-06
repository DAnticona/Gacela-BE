package com.wollcorp.gacela.dto;

import java.io.Serializable;
import java.util.List;

import com.wollcorp.gacela.dto.errores.ErrorCutOffs;
import com.wollcorp.gacela.dto.errores.Error;
import com.wollcorp.gacela.entity.Mtc1r999;

public class Mtc1r999Dto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Mtc1r999 mtc1r999;

	private List<Error> errores;

	private List<ErrorCutOffs> erroresCutOffs;

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
	 * @return the errores
	 */
	public List<Error> getErrores() {
		return errores;
	}

	/**
	 * @param errores the errores to set
	 */
	public void setErrores(List<Error> errores) {
		this.errores = errores;
	}

	/**
	 * @return the erroresCutOffs
	 */
	public List<ErrorCutOffs> getErroresCutOffs() {
		return erroresCutOffs;
	}

	/**
	 * @param erroresCutOffs the erroresCutOffs to set
	 */
	public void setErroresCutOffs(List<ErrorCutOffs> erroresCutOffs) {
		this.erroresCutOffs = erroresCutOffs;
	}

}
