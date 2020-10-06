package com.wollcorp.gacela.rest;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.wollcorp.gacela.dto.ForecastDto;
import com.wollcorp.gacela.entity.Forecast;
import com.wollcorp.gacela.service.ForecastService;
import com.wollcorp.gacela.util.GestionarArchivos;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/forecast")
@Slf4j
public class ForecastRest {

	@Autowired
	ForecastService forecastService;

	@Autowired
	GestionarArchivos gestionarArchivos;

	/**
	 * Servicio que convierte un excel de tipo forecast a una entidad java con
	 * validaciones muy básicas
	 * 
	 * @param multipartFile Es el archivo excel enviado por el usuario.
	 * @param idServicioStr Id del servicio seleccionado por el usuario.
	 * @param idNaveStr     Id de la nave seleccionada por el usuario.
	 * @param fgProp        Flag que indica si el reporte sera Local o Partner.
	 * @return Un DTO que contiene el objeto forecast y los errores encontrados al
	 *         extraer la data
	 */
	@PostMapping("/archivo")
	public ResponseEntity<?> fileToObject(@RequestParam("file") MultipartFile multipartFile,
			@RequestParam("idServicio") String idServicioStr, @RequestParam("idNave") String idNaveStr,
			@RequestParam("fgProp") String fgProp) {

		if (multipartFile.isEmpty()) {
			this.throwException(HttpStatus.BAD_REQUEST, "Parámetros incompletos");
		}

		Integer idNave = null;
		Integer idServicio = null;
		fgProp = fgProp.trim().toUpperCase();

		// Verifica que sea un Integer válido
		try {
			idNave = Integer.parseInt(idNaveStr.trim());
			idServicio = Integer.parseInt(idServicioStr.trim());
		} catch (NumberFormatException e) {
			this.throwException(HttpStatus.BAD_REQUEST, "Nave o Servicio no válido");
		}

		Forecast forecast = new Forecast();

		forecast = forecastService.crearForecast(forecast, idNave, idServicio, fgProp);
		File file = gestionarArchivos.multipartFileToFile(multipartFile, String.valueOf(System.currentTimeMillis()));
		ForecastDto forecastDto = forecastService.extraerDataFile(forecast, file);

		return ResponseEntity.ok(forecastDto);
	}

	/**
	 * Servicio que valida un objeto forecast enviado por el Frontend, este objeto
	 * puede ser la respuesta obtenida del servicio fileToObjet o armado por el
	 * mismo usuario. El servicio busca valida si los datos son válidos y de ser
	 * necesario los reemplaza por el código SOL.
	 * 
	 * @param forecast Objeto forecast que será validado.
	 * @return Un DTO que contiene el objeto forecast validado (con códigos SOL) y
	 *         una lista de errores
	 */
	@PostMapping("/validar")
	public ResponseEntity<?> validarForecast(@RequestBody Forecast forecast) {

		if (forecast == null || forecast.getNave() == null || forecast.getServicio() == null) {
			this.throwException(HttpStatus.BAD_REQUEST, "Forecast inválido");
		}

		if (forecast.getNave().getIdNave() == null || forecast.getServicio().getIdServicio() == null
				|| forecast.getFgProp() == null) {
			this.throwException(HttpStatus.BAD_REQUEST, "Nave o Servicio inválido");
		}

		forecast = forecastService.crearForecast(forecast, forecast.getNave().getIdNave(),
				forecast.getServicio().getIdServicio(), forecast.getFgProp());

		ForecastDto forecastDto = forecastService.validarForecastDetalle(forecast);

		return ResponseEntity.ok(forecastDto);
	}

	/**
	 * Servicio que transforma el objeto Forecast en el reporte final en excel. El
	 * DTO no debe tener errores críticos.
	 * 
	 * @param forecastDto DTO que contiene el objeto forecast a utilizar y los
	 *                    errores encontrados en la validación.
	 * @return Reporte en archivo excel.
	 */
	@GetMapping("/descarga")
	public ResponseEntity<?> obtenerReporte(@RequestBody ForecastDto forecastDto) {
		
		if(forecastDto == null || forecastDto.getForecast() == null || forecastDto.getErrores() == null) {
			this.throwException(HttpStatus.BAD_REQUEST, "Objeto inválido");
		}

		if (forecastDto.getErrores().stream().filter(f -> f.getCriticidad().equals("C")).count() > 0) {
			this.throwException(HttpStatus.BAD_REQUEST, "El objeto contiene errores críticos");
		}

		ByteArrayOutputStream stream = forecastService.generarExcel(forecastDto.getForecast());

		String filename = forecastService.obtenerFilename(forecastDto.getForecast());

		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "force-download"));
		header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

		return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()), header, HttpStatus.OK);
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
