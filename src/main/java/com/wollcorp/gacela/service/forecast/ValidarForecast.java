package com.wollcorp.gacela.service.forecast;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wollcorp.gacela.dto.ForecastDto;
import com.wollcorp.gacela.dto.errores.Error;
import com.wollcorp.gacela.entity.Forecast;
import com.wollcorp.gacela.entity.ForecastDetalle;
import com.wollcorp.gacela.entity.Linea;
import com.wollcorp.gacela.entity.Puerto;
import com.wollcorp.gacela.entity.TipoContenedor;
import com.wollcorp.gacela.service.LineaService;
import com.wollcorp.gacela.service.PuertoService;
import com.wollcorp.gacela.service.TipoContenedorService;
import com.wollcorp.gacela.util.GestionarArchivos;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ValidarForecast {

	@Autowired
	LineaService lineaService;
	@Autowired
	PuertoService puertoService;
	@Autowired
	TipoContenedorService tipoContenedorService;
	@Autowired
	GestionarArchivos gestionarArchivos;

	/**
	 * Extrae los títulos del excel, los copia a una lista, verifica si falta alguna
	 * columna o está duplicada, devuelve la lista de errores encontrados.
	 * 
	 * @param sheet Hoja de excel a validar.
	 * @return Lista de errores encontrados.
	 */
	public ForecastDto validarColumnas(XSSFWorkbook wb) {

		XSSFSheet sheet = wb.getSheetAt(0);

		ForecastDto forecastDto = new ForecastDto();
		List<Error> errores = new ArrayList<>();

		List<String> titulos = new ArrayList<>();

		try {

			XSSFRow xRow = sheet.getRow(0);

			for (int i = 0; i < xRow.getLastCellNum(); i++) {
				String cell = xRow.getCell(i).getStringCellValue().toUpperCase();
				titulos.add(cell);
			}

			if (titulos.stream().filter(t -> "LINEA".equals(t)).collect(Collectors.toList()).size() > 1) {
				Error error = new Error("Existen múltiples columnas LINEA", "C");
				errores.add(error);
			} else if (titulos.stream().filter(t -> "LINEA".equals(t)).collect(Collectors.toList()).size() == 0) {
				Error error = new Error("Columna LINEA NO existe", "C");
				errores.add(error);
			}
			if (titulos.stream().filter(t -> "POD".equals(t)).collect(Collectors.toList()).size() > 1) {
				Error error = new Error("Existen múltiples columnas POD", "C");
				errores.add(error);
			} else if (titulos.stream().filter(t -> "POD".equals(t)).collect(Collectors.toList()).size() == 0) {
				Error error = new Error("Columna POD NO existe", "C");
				errores.add(error);
			}
			if (titulos.stream().filter(t -> "SIZE".equals(t)).collect(Collectors.toList()).size() > 1) {
				Error error = new Error("Existen múltiples columnas SIZE", "C");
				errores.add(error);
			} else if (titulos.stream().filter(t -> "SIZE".equals(t)).collect(Collectors.toList()).size() == 0) {
				Error error = new Error("Columna SIZE NO existe", "C");
				errores.add(error);
			}
			if (titulos.stream().filter(t -> "TYPE".equals(t)).collect(Collectors.toList()).size() > 1) {
				Error error = new Error("Existen múltiples columnas TYPE", "C");
				errores.add(error);
			} else if (titulos.stream().filter(t -> "TYPE".equals(t)).collect(Collectors.toList()).size() == 0) {
				Error error = new Error("Columna TYPE NO existe", "C");
				errores.add(error);
			}
			if (titulos.stream().filter(t -> "CND".equals(t)).collect(Collectors.toList()).size() > 1) {
				Error error = new Error("Existen múltiples columnas CND", "C");
				errores.add(error);
			} else if (titulos.stream().filter(t -> "CND".equals(t)).collect(Collectors.toList()).size() == 0) {
				Error error = new Error("Columna CND NO existe", "C");
				errores.add(error);
			}
			if (titulos.stream().filter(t -> "VGM(KG)".equals(t)).collect(Collectors.toList()).size() > 1) {
				Error error = new Error("Existen múltiples columnas VGM(KG)", "C");
				errores.add(error);
			} else if (titulos.stream().filter(t -> "VGM(KG)".equals(t)).collect(Collectors.toList()).size() == 0) {
				Error error = new Error("Columna VGM(KG) NO existe", "C");
				errores.add(error);
			}
			if (titulos.stream().filter(t -> "IMO".equals(t)).collect(Collectors.toList()).size() > 1) {
				Error error = new Error("Existen múltiples columnas IMO", "C");
				errores.add(error);
			} else if (titulos.stream().filter(t -> "IMO".equals(t)).collect(Collectors.toList()).size() == 0) {
				Error error = new Error("Columna IMO NO existe", "C");
				errores.add(error);
			}
			if (titulos.stream().filter(t -> "UN".equals(t)).collect(Collectors.toList()).size() > 1) {
				Error error = new Error("Existen múltiples columnas UN", "C");
				errores.add(error);
			} else if (titulos.stream().filter(t -> "UN".equals(t)).collect(Collectors.toList()).size() == 0) {
				Error error = new Error("Columna UN NO existe", "C");
				errores.add(error);
			}
			if (titulos.stream().filter(t -> "TEMPERATURE".equals(t)).collect(Collectors.toList()).size() > 1) {
				Error error = new Error("Existen múltiples columnas TEMPERATURE", "C");
				errores.add(error);
			} else if (titulos.stream().filter(t -> "TEMPERATURE".equals(t)).collect(Collectors.toList()).size() == 0) {
				Error error = new Error("Columna TEMPERATURE NO existe", "C");
				errores.add(error);
			}

			forecastDto.setErrores(errores);

			return forecastDto;

		} catch (NullPointerException e) {

			log.error("Formato inválido");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formato inválido", e);

		}
	}

	/**
	 * Extrae la data del excel y hace validaciones básicas
	 * 
	 * @param sheet Hoja de excel conteniendo la data
	 * @return Lista de forecasts
	 */
	public ForecastDto extraerData(Forecast forecast, XSSFWorkbook wb) {

		XSSFSheet sheet = wb.getSheetAt(0);

		ForecastDto forecastDto = new ForecastDto();
		List<Error> errores = new ArrayList<>();

		List<ForecastDetalle> detalles = new ArrayList<>();

		for (int r = 1; r <= sheet.getLastRowNum(); r++) {

			ForecastDetalle detalle = new ForecastDetalle();

			XSSFRow xRow = sheet.getRow(r);

			for (int c = 0; c < xRow.getLastCellNum(); c++) {

				String titulo = sheet.getRow(0).getCell(c).getStringCellValue().toUpperCase();

				detalle.setFila(r + 1);

				String valor = null;

				try {
					valor = sheet.getRow(r).getCell(c).getStringCellValue().trim().toUpperCase();
					valor = valor.length() > 0 ? valor : null;
				} catch (IllegalStateException e) {
					valor = String.valueOf(sheet.getRow(r).getCell(c).getNumericCellValue());
				} catch (NullPointerException e) {
					valor = null;
				}

				switch (titulo) {
				case "LINEA":
					detalle.setLinea(valor);
					break;
				case "POD":
					detalle.setPod(valor);
					break;
				case "SIZE":
					// Se valida aquí porque al hacer el cast a Integer
					// puede truncar valores inválidos y contarlos como válidos
					try {
						double numero = Double.parseDouble(valor);
						double resto = numero % 1;

						if (resto > 0) {
							errores.add(new Error("Fila " + (r + 1) + " Columna SIZE: Debe ser 20 ó 40", "C"));
							break;
						}
						detalle.setSize((int) (numero));
					} catch (NumberFormatException e) {
						errores.add(new Error("Fila " + (r + 1) + " Columna SIZE: Debe ser 20 ó 40", "C"));
					} catch (NullPointerException e) {
						errores.add(new Error("Fila " + (r + 1) + " Columna SIZE: Debe ser 20 ó 40", "C"));
					}
					break;
				case "TYPE":
					detalle.setType(valor);
					break;
				case "CND":
					detalle.setCnd(valor);
					break;
				case "VGM(KG)":
					// Se valida aquí porque al hacer el cast a Long
					// puede truncar valores inválidos y contarlos como válidos
					try {
						double numero = Double.parseDouble(valor);
						double resto = numero % 1;

						if (resto > 0) {
							errores.add(new Error("Fila " + (r + 1) + " Columna VGM: Debe ser entero", "C"));
							break;
						}
						detalle.setVgm((long) (numero));
					} catch (NumberFormatException e) {
						errores.add(new Error("Fila " + (r + 1) + " Columna VGM: No es un número válido", "C"));
					} catch (NullPointerException e) {
						errores.add(new Error("Fila " + (r + 1) + " Columna VGM: No es un número válido", "C"));
					}
					break;
				case "IMO":
					detalle.setImo(valor);
					break;
				case "UN":
					detalle.setUn(valor);
					break;
				case "TEMPERATURE":
					detalle.setTemperature(valor);
					break;
				case "COMMODITY":
					detalle.setCommodity(valor);
					break;
				}
			}
			detalles.add(detalle);
		}
		forecast.setDetalle(detalles);
		forecastDto.setForecast(forecast);
		forecastDto.setErrores(errores);

		return forecastDto;
	}

	public ForecastDto validarData(Forecast forecast) {

		ForecastDto forecastDto = new ForecastDto();
		List<Error> errores = new ArrayList<>();

		List<Linea> lineas = lineaService.listar();
		List<Puerto> puertos = forecast.getServicio().getPuertos();
		List<TipoContenedor> tiposContenedor = tipoContenedorService.listar();

		for (ForecastDetalle detalle : forecast.getDetalle()) {

			// LINEA
			String linea = lineas.stream()
					.filter(p -> p.getCoIso().equals(detalle.getLinea()) || p.getCoSol().equals(detalle.getLinea()))
					.map(x -> x.getCoSol()).findFirst().orElse(null);

			if (linea == null) {
				errores.add(new Error("Fila " + detalle.getFila() + " Columna LINEA: Línea desconocida", "C"));
			}

			detalle.setLinea(linea);

			// POD
			String puerto = puertos.stream()
					.filter(p -> p.getCoIso().equals(detalle.getPod()) || p.getCoSol().equals(detalle.getPod()))
					.map(x -> x.getCoSol()).findFirst().orElse(null);

			if (puerto == null) {
				errores.add(new Error("Fila " + detalle.getFila() + " Columna POD: Puerto no válido para el servicio",
						"C"));
			}

			detalle.setPod(puerto);

			// SIZE
			if (!(20 == detalle.getSize() || 40 == detalle.getSize())) {
				errores.add(new Error("Fila " + detalle.getFila() + " Columna SIZE: Debe ser 20 ó 40", "C"));
			}

			// TYPE
			String type = tiposContenedor.stream()
					.filter(tc -> tc.getCoSol().equals(detalle.getType()) || tc.getCoIso().equals(detalle.getType())
							|| tc.getCoIso2().equals(detalle.getType()))
					.map(x -> x.getCoSol()).findFirst().orElse(null);

			if (type == null) {
				errores.add(new Error("Fila " + detalle.getFila() + " Columna TYPE: Tipo desconocido", "C"));
			}

			detalle.setType(type);

			// CND
			if (!("E".equals(detalle.getCnd()) || "F".equals(detalle.getCnd()))) {
				errores.add(new Error("Fila " + detalle.getFila() + " Columna CND: Debe ser E o F", "C"));
			}

			// VGM
			if (detalle.getVgm() == null || detalle.getVgm() < 2000) {
				errores.add(new Error("Fila " + detalle.getFila() + " Columna VGM: Debe ser mínimo 2000", "C"));
			}

			// IMO
			if (detalle.getImo() != null && detalle.getImo().contains(".0")) {
				detalle.setImo(detalle.getImo().replaceAll(".0", ""));
			}

			// UN
			if (detalle.getUn() != null && detalle.getUn().contains(".0")) {
				detalle.setUn(detalle.getUn().replaceAll(".0", ""));
			}

			// Validación de combinación de IMO, UN, COMMODITY
			if ("EVG".equals(detalle.getLinea()) && detalle.getImo() != null && detalle.getUn() != null) {

				if (detalle.getImo().equals("9") && detalle.getUn().equals("2216")
						&& !("FISHMEAL".equals(detalle.getCommodity()) || "FISH MEAL".equals(detalle.getCommodity()))) {

					errores.add(new Error("Fila " + detalle.getFila() + " Revisar IMO, UN y COMMODITY", "W"));

				} else if ("9".equals(detalle.getImo()) && "3359/2216".equals(detalle.getUn())
						&& !("FISHMEAL".equals(detalle.getCommodity()) || "FISH MEAL".equals(detalle.getCommodity()))) {

					errores.add(new Error("Fila " + detalle.getFila() + " Revisar IMO, UN y COMMODITY", "W"));

				} else if (detalle.getImo().equals("9") && detalle.getUn().equals("2216/3359")
						&& !(detalle.getCommodity().equals("FISHMEAL") || detalle.getCommodity().equals("FISH MEAL"))) {

					errores.add(new Error("Fila " + detalle.getFila() + " Revisar IMO, UN y COMMODITY", "W"));

				}
			}
		}

		forecastDto.setForecast(forecast);
		forecastDto.setErrores(errores);

		return forecastDto;
	}
}
