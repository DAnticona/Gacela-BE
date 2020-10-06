package com.wollcorp.gacela.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wollcorp.gacela.dto.ForecastDto;
import com.wollcorp.gacela.entity.Forecast;
import com.wollcorp.gacela.entity.Nave;
import com.wollcorp.gacela.entity.Servicio;
import com.wollcorp.gacela.service.forecast.ReportePWS2Partner;
import com.wollcorp.gacela.service.forecast.ReportePartner;
import com.wollcorp.gacela.service.forecast.ReporteWSA1Local;
import com.wollcorp.gacela.service.forecast.ReporteWSA2Local;
import com.wollcorp.gacela.service.forecast.ReporteWSA4Partner;
import com.wollcorp.gacela.service.forecast.ValidarForecast;
import com.wollcorp.gacela.util.GestionarArchivos;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ForecastService {

	@Autowired
	NaveService naveService;
	@Autowired
	ServicioService servicioService;
	@Autowired
	ValidarForecast validarForecastNew;
	@Autowired
	GestionarArchivos gestionarArchivos;
	@Autowired
	ReporteWSA1Local reporteWSA1Local;
	@Autowired
	ReporteWSA2Local reporteWSA2Local;
	@Autowired
	ReportePartner reportePartner;
	@Autowired
	ReporteWSA4Partner reporteWSA4Partner;
	@Autowired
	ReportePWS2Partner reportePWS2Partner;

	/**
	 * Crea un objeto forecast a partir de un IdNave, IdServicio y FgProp.
	 * 
	 * @param forecast   Objeto a procesar
	 * @param idNave     Id de la nave a buscar.
	 * @param idServicio Id del servicio a buscar
	 * @param fgProp     Flag que indica si el reporte es Local o Partner
	 * @return Objeto Forecast creado con nave y servicio.
	 */
	public Forecast crearForecast(Forecast forecast, Integer idNave, Integer idServicio, String fgProp) {

		Nave nave = naveService.encontrarPorId(new Nave(idNave));
		Servicio servicio = servicioService.encontrarPorId(new Servicio(idServicio));

		if (nave == null || servicio == null || !("S".equals(fgProp) || "N".equals(fgProp))) {
			
			this.throwException(HttpStatus.BAD_REQUEST, "Nave, Servicio o FgProp no encontrados");
			
		}

		forecast.setNave(nave);
		forecast.setServicio(servicio);
		forecast.setFgProp(fgProp);

		return forecast;
	}

	/**
	 * Extrae la data del archivo excel a un objeto Forecast
	 * 
	 * @param forecast Objeto a procesar
	 * @param file     Archivo excel que contiene la data cruda
	 * @return Un DTO que contiene el objeto Forecast y los errores encontrados
	 */
	public ForecastDto extraerDataFile(Forecast forecast, File file) {

		ForecastDto forecastDto = new ForecastDto();

		XSSFWorkbook wb = gestionarArchivos.fileToWorkbook(file);

		forecastDto = validarForecastNew.validarColumnas(wb);

		if (forecastDto.getErrores().size() == 0) {
			
			forecastDto = validarForecastNew.extraerData(forecast, wb);
			
		}

		try {
			
			wb.close();
			
		} catch (IOException e) {
			
			this.throwException(HttpStatus.INTERNAL_SERVER_ERROR, "Error cerrando workbook");
			
		}

		return forecastDto;

	}

	/**
	 * Valida un objeto Forecast
	 * 
	 * @param forecast Objeto a procesar
	 * @return Un DTO que contiene el Forecast y los errores encontrados
	 */
	public ForecastDto validarForecastDetalle(Forecast forecast) {

		return validarForecastNew.validarData(forecast);
	}

	/**
	 * Genera el reporte final desde un objeto Forecast.
	 * 
	 * @param forecast Objeto a procesar
	 * @return Un objeto ByteArrayOutputStream listo para enviar al Frontend.
	 */
	public ByteArrayOutputStream generarExcel(Forecast forecast) {

		XSSFWorkbook wb = null;

		if ("S".equals(forecast.getFgProp()) && "WSA1".equals(forecast.getServicio().getNombre())) {

			wb = reporteWSA1Local.generarReporte(forecast);

		} else if ("S".equals(forecast.getFgProp()) && "WSA2".equals(forecast.getServicio().getNombre())) {

			wb = reporteWSA2Local.generarReporte(forecast);

		} else if ("N".equals(forecast.getFgProp()) && "WSA4".equals(forecast.getServicio().getNombre())) {

			wb = reporteWSA4Partner.generarReporte(forecast);

		} else if ("N".equals(forecast.getFgProp()) && "PWS2".equals(forecast.getServicio().getNombre())) {

			wb = reportePWS2Partner.generarReporte(forecast);

		} else if ("N".equals(forecast.getFgProp())) {

			wb = reportePartner.generarReporte(forecast);

		} else {
			
			this.throwException(HttpStatus.BAD_REQUEST, "Reporte no configurado");
			
		}

		ByteArrayOutputStream stream = new ByteArrayOutputStream();

		try {
			
			wb.write(stream);
			wb.close();
			
		} catch (IOException e) {
			
			this.throwException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al escribir o cerrar el workbook");
			
		}

		return stream;
	}

	/**
	 * Genera el nombre del archivo del reporte final a enviar al Frontend
	 * 
	 * @param forecast Objeto usado para el reporte.
	 * @return Un String con el nombre del archivo
	 */
	public String obtenerFilename(Forecast forecast) {

		String tipo = "";

		if ("N".equals(forecast.getFgProp())) {
			tipo = "Partner";
		}

		String filename = "Forecast" + forecast.getServicio().getNombre() + tipo + "_" + System.currentTimeMillis()
				+ ".xlsx";

		return filename;
	}

	/**
	 * Método privado que lanza una exepción y la registra en el log ERROR en caso
	 * de encontrar un error
	 * 
	 * @param httpStatus Tipo de exception a lanzar.
	 * @param message    Mensaje a mostrar al Frontend.
	 */
	private void throwException(HttpStatus httpStatus, String message) {
		log.error(message);
		throw new ResponseStatusException(httpStatus, message);
	}
}
