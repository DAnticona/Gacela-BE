package com.wollcorp.gacela.service.mtc1r999;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wollcorp.gacela.dto.Mtc1r999Dto;
import com.wollcorp.gacela.dto.errores.Error;
import com.wollcorp.gacela.dto.errores.ErrorCutOffs;
import com.wollcorp.gacela.entity.Mtc1r999;
import com.wollcorp.gacela.entity.Mtc1r999Detalle;
import com.wollcorp.gacela.entity.Nave;
import com.wollcorp.gacela.service.NaveService;
import com.wollcorp.gacela.util.GestionarArchivos;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileToMtc1r999 {

	@Autowired
	NaveService naveService;
	@Autowired
	GestionarArchivos gestionarArchivos;

	/**
	 * Extrae la data y la copiaa la entidad Mtc1r999 y su detalle, también valida
	 * que la nave exista en la base de datos.
	 * 
	 * @param mtc1r999 Entidad en donde estarán los datos del archivo.
	 * @param lineas   Son los registros obtenidos del archivo en crudo.
	 * @return Mtcr1999Dto que contiene la entidad Mtc1r999, su detalle y los
	 *         errores encontrados en la extracción.
	 */
	public Mtc1r999Dto extraerData(Mtc1r999 mtc1r999, File file) {

		Mtc1r999Dto mtc1r999Dto = new Mtc1r999Dto();
		List<Error> errores = new ArrayList<>();
		List<Mtc1r999Detalle> detalles = new ArrayList<>();

		List<String> lineas = null;

		try {

			lineas = Files.readAllLines(Paths.get(file.getPath()));

		} catch (IOException e) {

			log.error("File read error");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "File read error");

		}

		lineas = this.eliminarLineasSinValor(lineas);
		gestionarArchivos.eliminarArchivo(file.getName());

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

		int fila = 0;

		for (String linea : lineas) {

			++fila;

			Mtc1r999Detalle detalle = new Mtc1r999Detalle();

			detalle.setDepot(this.leerCampoStr(linea, 0, 6));
			if (detalle.getDepot() != null && detalle.getDepot().equals("PECALD")) {
				continue;
			}

			String vslVoys = this.leerCampoStr(linea, 7, 24);
			detalle.setVslVoyS(vslVoys);

			if (vslVoys != null) {
				detalle.setNave(vslVoys.split("/")[0].trim().toUpperCase());
				detalle.setViaje(vslVoys.split("/")[1].trim().toUpperCase());
			}

			detalle.setBookingNo(this.leerCampoStr(linea, 25, 41));
			if (detalle.getBookingNo() == null || !detalle.getBookingNo().substring(0, 2).equals("75")) {
				continue;
			}

			// Para QTY la validación la hace aqui ya que puede saltar
			// una exception por cast String to Integer
			try {

				double numero = Double.parseDouble(this.leerCampoStr(linea, 47, 50));
				double resto = numero % 1;

				if (resto > 0) {
					errores.add(new Error("Fila " + fila + " Columna QTY: Debe ser entero", "C"));
					detalle.setQty(null);
				} else {
					detalle.setQty((int) numero);
				}

			} catch (NumberFormatException | NullPointerException e) {

				errores.add(new Error("Fila " + fila + " Columna QTY: No es un número válido", "C"));

			}

			// Para PICK la validación la hace aqui ya que puede saltar
			// una exception por cast String to Integer
			// String valor = this.leerCampoStr(linea, 47, 50);
			try {

				double numero = Double.parseDouble(this.leerCampoStr(linea, 51, 55));
				double resto = numero % 1;

				if (resto > 0) {
					errores.add(new Error("Fila " + fila + " Columna PICK: Debe ser entero", "C"));
					detalle.setPick(null);
				} else {
					detalle.setPick((int) numero);
				}

			} catch (NumberFormatException | NullPointerException e) {

				errores.add(new Error("Fila " + fila + " Columna PICK: No es un número válido", "C"));

			}

			detalle.setMode(this.leerCampoStr(linea, 64, 68));
			if (detalle.getMode() != null && detalle.getMode().equals("C")) {
				continue;
			}

			detalle.setTpe(this.leerCampoStr(linea, 73, 76));

			try {

				detalle.setCutOff(LocalDate.parse(this.leerCampoStr(linea, 110, 118), dateFormatter));

			} catch (DateTimeParseException | NullPointerException e) {

				errores.add(new Error("Fila " + fila + " Colunma CUT OFF Debe tener el formato: yyyyMMdd", "C"));
			}
			detalles.add(detalle);
		}

		mtc1r999.setDetalle(detalles);
		mtc1r999Dto.setMtc1r999(mtc1r999);
		mtc1r999Dto.setErrores(errores);

		return mtc1r999Dto;
	}

	public Mtc1r999Dto validarMtc1r999(Mtc1r999 mtc1r999) {

		Mtc1r999Dto mtc1r999Dto = new Mtc1r999Dto();
		List<Mtc1r999Detalle> detalles = new ArrayList<>();
		List<Error> errores = new ArrayList<>();

		List<Nave> naves = naveService.listar();

		for (Mtc1r999Detalle detalle : mtc1r999.getDetalle()) {

			// NAVE
			if (detalle.getNave() == null) {
				errores.add(new Error("Columna VSL_VOY_S no contiene una NAVE válida", "C"));
			} else if (naves.stream().filter(f -> f.getCodigo().equals(detalle.getNave())).count() == 0) {
				errores.add(new Error("La nave " + detalle.getNave() + " no está registrada", "W"));
			}

			// VIAJE
			if (detalle.getViaje() == null) {
				errores.add(new Error("Columna VSL_VOY_S no contiene un VIAJE válido", "C"));
			}

			// QTY
			if (detalle.getQty() == null) {
				errores.add(new Error("Columna QTY vacía", "C"));
			}

			// PICK
			if (detalle.getPick() == null) {
				errores.add(new Error("Columna PICK vacía", "C"));
			}

			// TPE
			if (detalle.getTpe() == null) {
				errores.add(new Error("Columna TPE vacía", "C"));
			}

			// CUT OFF
			if (detalle.getCutOff() == null) {
				errores.add(new Error("Columna CUT OFF vacía", "C"));
			}
			detalles.add(detalle);
		}

		mtc1r999.setDetalle(detalles);
		mtc1r999Dto.setErrores(errores);
		mtc1r999Dto.setMtc1r999(mtc1r999);

		return mtc1r999Dto;
	}

	public List<ErrorCutOffs> validarCuttOff(List<Mtc1r999Detalle> detalle) {

		List<ErrorCutOffs> errores = new ArrayList<>();

		List<String> keys = detalle.stream().map(x -> x.getNave() + x.getViaje()).distinct()
				.collect(Collectors.toList());

		for (String key : keys) {

			List<Mtc1r999Detalle> detalles = detalle.stream().filter(f -> (f.getNave() + f.getViaje()).equals(key))
					.collect(Collectors.toList());

			if (detalles.stream().map(x -> x.getCutOff()).distinct().count() > 1) {

				ErrorCutOffs error = new ErrorCutOffs(detalles.get(0).getNave(), detalles.get(0).getViaje());
				List<LocalDate> cutOffs = new ArrayList<>();

				for (LocalDate cutOff : detalles.stream().map(x -> x.getCutOff()).distinct()
						.collect(Collectors.toList())) {

					cutOffs.add(cutOff);
				}

				error.setCutOffs(cutOffs);
				errores.add(error);
			}
		}

		return errores;
	}

	/**
	 * Elimina las primeras 10 líneas del archivo que no sirven para la extracción
	 * de la data. Asimismo elimina la última línea del archivo.
	 * 
	 * @param lineas El detalle total del archivo en una lista de string
	 * @return lineas Detalle listo para procesar.
	 */
	private List<String> eliminarLineasSinValor(List<String> lineas) {
		
		// Elimina las primeras 10 lineas
		for (int i = 0; i < 10; i++) {
			// Siempre es 0 porque la línea anterios ya fue removida
			lineas.remove(0);
		}

		// Elimina la última línea
		lineas.remove(lineas.size() - 1);

		return lineas;
	}

	private String leerCampoStr(String linea, int ini, int fin) {

		try {

			return linea.substring(ini, fin).trim().length() > 0 ? linea.substring(ini, fin).trim() : null;

		} catch (NullPointerException e) {
			return null;
		}
	}
}
