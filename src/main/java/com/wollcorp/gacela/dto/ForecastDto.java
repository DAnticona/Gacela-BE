package com.wollcorp.gacela.dto;

import java.io.Serializable;
import java.util.List;

import com.wollcorp.gacela.dto.errores.Error;
import com.wollcorp.gacela.entity.Forecast;

public class ForecastDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Forecast forecast;

	private List<Error> errores;

	/**
	 * @return the forecast
	 */
	public Forecast getForecast() {
		return forecast;
	}

	/**
	 * @param forecast the forecast to set
	 */
	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
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

}
