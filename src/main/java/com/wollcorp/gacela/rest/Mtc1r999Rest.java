package com.wollcorp.gacela.rest;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.wollcorp.gacela.dto.Mtc1r999Dto;
import com.wollcorp.gacela.entity.Mtc1r999;
import com.wollcorp.gacela.entity.Mtc1r999Detalle;
import com.wollcorp.gacela.entity.id.Mtc1r999DetalleId;
import com.wollcorp.gacela.service.Mtc1r999Service;
import com.wollcorp.gacela.util.GestionarArchivos;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/mtc1r999")
@Slf4j
public class Mtc1r999Rest {
	
	@Value("${config.due.days}")
	private Integer days;

	@Autowired
	Mtc1r999Service mtc1r999Service;
	@Autowired
	GestionarArchivos gestionarArchivos;

	/**
	 * Lista los mtc1r999 con estado cerrado o activo.
	 * 
	 * @return Lista de Mtc1r999 con estado cerrado y activo.
	 */
	@GetMapping()
	public ResponseEntity<?> listar() {
		List<Mtc1r999> files = mtc1r999Service.listar();
		return ResponseEntity.ok(files);
	}

	/**
	 * Lista el Mtc1r999 activo, debe ser existir solo 1 registro.
	 * 
	 * @return La entidad Mtc1r999 activa.
	 */
	@GetMapping("/activo")
	public ResponseEntity<?> encontrarActivo() {
		Mtc1r999 mtc1r999 = new Mtc1r999("A");
		mtc1r999 = mtc1r999Service.encontrarPorEstado(mtc1r999);
		return ResponseEntity.ok(mtc1r999);
	}

	/**
	 * Convierte el archivo MTC1R999 y devuelve un objeto con los campos necesarios
	 * 
	 * @param multipartFile Es el archivo cargado por el usuario
	 * @return Un Dto que contiene el objeto Mtc1r999 y errores encontrados
	 */
	@PostMapping("/archivo")
	public ResponseEntity<?> fileToObjet(@RequestParam("file") MultipartFile multipartFile) {

		if (multipartFile.isEmpty()) {
			this.throwException(HttpStatus.BAD_REQUEST, "Archivo no encontrado");
		}

		File file = gestionarArchivos.multipartFileToFile(multipartFile, multipartFile.getOriginalFilename());
		Mtc1r999 mtc1r999 = new Mtc1r999(file.getName(), LocalDate.now(), LocalDate.now().plusDays(days));

		Mtc1r999Dto mtc1r999Dto = mtc1r999Service.fileToMtc1r999(mtc1r999, file);

		return ResponseEntity.ok(mtc1r999Dto);
	}

	/**
	 * Valida un objeto Mtc1r999 y devuelve los errores encontrados
	 * 
	 * @param mtc1r999 El objeto enviado por el usuario, puede ser la salida del
	 *                 método fileToObjet
	 * @return Un Dto que contiene el objeto Mtc1r999 y sus errores encontrados.
	 */
	@PostMapping("/validar")
	public ResponseEntity<?> validar(@RequestBody Mtc1r999 mtc1r999) {

		if (mtc1r999 == null) {
			this.throwException(HttpStatus.BAD_REQUEST, "Objeto inválido");
		}

		Mtc1r999Dto mtc1r999Dto = mtc1r999Service.validarMtc1r999(mtc1r999);

		return ResponseEntity.ok(mtc1r999Dto);
	}

	/**
	 * Guarda el Objeto Mtc1r999 en base de datos, no debe existir ningun error en
	 * el objeto Dto
	 * 
	 * @param mtc1r999Dto Objeto Dto que contiene el Mtc1r999 y los errores
	 *                    encontrados del método validar
	 * @return Un Dto que contiene el Mtc1r999 guardado en BD
	 */
	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@RequestBody Mtc1r999Dto mtc1r999Dto) {

		if (mtc1r999Dto == null) {
			this.throwException(HttpStatus.BAD_REQUEST, "Objeto inválido");
		}

		if (mtc1r999Dto.getErrores().stream().filter(f -> f.getCriticidad().equals("C")).count() > 0
				|| mtc1r999Dto.getErroresCutOffs().size() > 0) {
			this.throwException(HttpStatus.BAD_REQUEST, "Existen errores no resueltos en el objeto");
		}

		mtc1r999Service.actualizarTodosLosEstados("C", "A");
		mtc1r999Dto.getMtc1r999().setFgActi("A");
		Mtc1r999 mtc1r999 = mtc1r999Service.guardar(mtc1r999Dto.getMtc1r999());

		for (int i = 0; i < mtc1r999.getDetalle().size(); i++) {

			Mtc1r999Detalle detalle = mtc1r999.getDetalle().get(i);
			detalle.setMtc1r999(mtc1r999);
			detalle.setMtc1r999DetalleId(new Mtc1r999DetalleId(mtc1r999.getIdMtc1r999(), i + 1));
			mtc1r999Service.insertarDetalle(detalle);

		}

		return ResponseEntity.ok(mtc1r999Dto);
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
