package com.wollcorp.gacela.rest;

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
import org.springframework.web.server.ResponseStatusException;

import com.wollcorp.gacela.dto.ProyeccionDto;
import com.wollcorp.gacela.entity.Mtc1r999;
import com.wollcorp.gacela.entity.Nave;
import com.wollcorp.gacela.entity.Proyeccion;
import com.wollcorp.gacela.entity.ProyeccionDetalle;
import com.wollcorp.gacela.entity.id.ProyeccionDetalleId;
import com.wollcorp.gacela.service.Mtc1r999Service;
import com.wollcorp.gacela.service.NaveService;
import com.wollcorp.gacela.service.ProyeccionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/proyeccion")
@Slf4j
public class ProyeccionRest {
	
	@Value("${config.due.days}")
	private Integer days;

	@Autowired
	ProyeccionService proyeccionService;
	@Autowired
	NaveService naveService;
	@Autowired
	Mtc1r999Service mtc1r999Service;

	@GetMapping
	public ResponseEntity<?> listar() {
		List<Proyeccion> proyecciones = proyeccionService.listar();
		return ResponseEntity.ok(proyecciones);
	}

	@GetMapping("/activo")
	public ResponseEntity<?> encontrarActivo(@RequestParam("tipo") String fgTipo) {

		if (fgTipo == null || fgTipo.trim().length() == 0) {
			this.throwException(HttpStatus.BAD_REQUEST, "Parámetros incompletos");
		}

		Proyeccion proyeccion = new Proyeccion();
		proyeccion.setFgActi("A");
		proyeccion.setFgTipo(fgTipo);
		proyeccion = proyeccionService.encontrarPorEstadoYTipo(proyeccion);
		return ResponseEntity.ok(proyeccion);
	}

	@GetMapping("/generar")
	public ResponseEntity<?> generarProyeccion(@RequestParam("tipo") String fgTipo,
			@RequestParam("file") Long idMtc1r999, @RequestParam("ventas") Long idProVentas) {

		if (fgTipo == null || idMtc1r999 == null || fgTipo.trim().length() == 0) {
			this.throwException(HttpStatus.BAD_REQUEST, "Parámetros incompletos");
		}

		Mtc1r999 mtc1r999 = new Mtc1r999(idMtc1r999);
		mtc1r999 = mtc1r999Service.encontrarPorId(mtc1r999);

		Proyeccion proyeccion = new Proyeccion();
		proyeccion.setFgTipo(fgTipo.toUpperCase());

		proyeccion = proyeccionService.generarProyeccion(proyeccion, mtc1r999);

		ProyeccionDto proyeccionDto = new ProyeccionDto();

		if (idProVentas != null) {
			Proyeccion proVentas = new Proyeccion(idProVentas);
			proVentas = proyeccionService.encontrarPorId(proVentas);
			proyeccionDto.setUnificada(proVentas);
		}
		
		proyeccionDto.setProyeccion(proyeccion);
		return ResponseEntity.ok(proyeccionDto);
	}

	@PostMapping
	public ResponseEntity<?> guardarProyecion(@RequestBody ProyeccionDto proyeccionDto) {

		Proyeccion proyeccion = proyeccionDto.getProyeccion();

		List<Nave> naves = naveService.listar();

		proyeccion.setFeVcto(LocalDate.now().plusDays(days));

		proyeccionService.actualizarTodosEstados("C", "A");
		proyeccion.setFgActi("A");
		proyeccion = proyeccionService.guardar(proyeccion);

		for (int i = 0; i < proyeccion.getDetalle().size(); i++) {
			ProyeccionDetalle detalle = proyeccion.getDetalle().get(i);
			detalle.setProyeccion(proyeccion);
			detalle.setProyeccionDetalleId(new ProyeccionDetalleId(proyeccion.getIdProyeccion(), i + 1));

			Nave nave = naves.stream().filter(f -> f.getCodigo().equals(detalle.getNave().getCodigo())).findFirst()
					.orElse(null);

			if (nave == null) {
				this.throwException(HttpStatus.BAD_REQUEST, "Existen Naves Desconocidas");
			}

			detalle.setNave(nave);
			proyeccionService.insertarDetalle(detalle);
		}
		
		Proyeccion unificada = proyeccionDto.getUnificada();
		
		if(unificada != null) {
			
			unificada.setFeVcto(LocalDate.now().plusDays(days));
			unificada = proyeccionService.guardar(unificada);
			
			proyeccion.setIdProUnificada(unificada.getIdProyeccion());
			
			for (int i = 0; i < unificada.getDetalle().size(); i++) {
				ProyeccionDetalle detalle = unificada.getDetalle().get(i);
				detalle.setProyeccion(unificada);
				detalle.setProyeccionDetalleId(new ProyeccionDetalleId(unificada.getIdProyeccion(), i + 1));

				Nave nave = naves.stream().filter(f -> f.getCodigo().equals(detalle.getNave().getCodigo())).findFirst()
						.orElse(null);

				if (nave == null) {
					this.throwException(HttpStatus.BAD_REQUEST, "Existen Naves Desconocidas");
				}

				detalle.setNave(nave);
				proyeccionService.insertarDetalle(detalle);
			}
			
			proyeccionDto.setUnificada(unificada);
			
		}
		
		proyeccionDto.setProyeccion(proyeccion);

		return ResponseEntity.ok(proyeccionDto);
	}

	private void throwException(HttpStatus httpStatus, String message) {
		log.error(message);
		throw new ResponseStatusException(httpStatus, message);
	}
}
