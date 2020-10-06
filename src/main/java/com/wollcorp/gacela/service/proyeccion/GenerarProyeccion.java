package com.wollcorp.gacela.service.proyeccion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.entity.Calendario;
import com.wollcorp.gacela.entity.Mtc1r999;
import com.wollcorp.gacela.entity.Mtc1r999Detalle;
import com.wollcorp.gacela.entity.Nave;
import com.wollcorp.gacela.entity.Proyeccion;
import com.wollcorp.gacela.entity.ProyeccionDetalle;
import com.wollcorp.gacela.entity.ProyeccionRpo;
import com.wollcorp.gacela.entity.RatioDevolucion;
import com.wollcorp.gacela.entity.RpoPlan;
import com.wollcorp.gacela.service.CalendarioService;
import com.wollcorp.gacela.service.NaveService;
import com.wollcorp.gacela.service.RatioDevolucionService;
import com.wollcorp.gacela.service.RpoPlanService;

@Service
public class GenerarProyeccion {

	@Autowired
	NaveService naveService;
	@Autowired
	CalendarioService calendarioService;
	@Autowired
	RatioDevolucionService ratioDevolucionService;
	@Autowired
	RpoPlanService rpoPlanService;

	public Proyeccion generarProyeccion(Proyeccion proyeccion, Mtc1r999 mtc1r999) {

		proyeccion.setIdMtc1r999(mtc1r999.getIdMtc1r999());
		proyeccion.setFeProyeccion(LocalDate.now());
		
		Calendario fecha = new Calendario(proyeccion.getFeProyeccion());
		fecha = calendarioService.encontrarPorFecha(fecha);
		proyeccion.setNuSemana(fecha.getNuSemAno());

		List<ProyeccionDetalle> proyeccionDetalles = this.generarDetalle(mtc1r999.getDetalle());

		proyeccion.setDetalle(proyeccionDetalles);

		// STOCK
		proyeccion.setStock2sd(0);
		proyeccion.setStock4sd(0);
		proyeccion.setStock4sh(0);

		// TOTALES QTY X FE Y NO FE
		proyeccion.setTo2sdFe(
				proyeccionDetalles.stream().map(x -> x.getCa2sdFe()).collect(Collectors.summingInt(Integer::intValue)));

		proyeccion.setTo2sdNoFe(proyeccionDetalles.stream().map(x -> x.getCa2sdNoFe())
				.collect(Collectors.summingInt(Integer::intValue)));

		proyeccion.setTo4sdFe(
				proyeccionDetalles.stream().map(x -> x.getCa4sdFe()).collect(Collectors.summingInt(Integer::intValue)));

		proyeccion.setTo4sdNoFe(proyeccionDetalles.stream().map(x -> x.getCa4sdNoFe())
				.collect(Collectors.summingInt(Integer::intValue)));

		proyeccion.setTo4shFe(
				proyeccionDetalles.stream().map(x -> x.getCa4shFe()).collect(Collectors.summingInt(Integer::intValue)));

		proyeccion.setTo4shNoFe(proyeccionDetalles.stream().map(x -> x.getCa4shNoFe())
				.collect(Collectors.summingInt(Integer::intValue)));

		// TOTALES PICK X FE Y NO FE
		proyeccion.setTo2sdFePick(proyeccionDetalles.stream().map(x -> x.getCa2sdFePick())
				.collect(Collectors.summingInt(Integer::intValue)));

		proyeccion.setTo2sdNoFePick(proyeccionDetalles.stream().map(x -> x.getCa2sdNoFePick())
				.collect(Collectors.summingInt(Integer::intValue)));

		proyeccion.setTo4sdFePick(proyeccionDetalles.stream().map(x -> x.getCa4sdFePick())
				.collect(Collectors.summingInt(Integer::intValue)));

		proyeccion.setTo4sdNoFePick(proyeccionDetalles.stream().map(x -> x.getCa4sdNoFePick())
				.collect(Collectors.summingInt(Integer::intValue)));

		proyeccion.setTo4shFePick(proyeccionDetalles.stream().map(x -> x.getCa4shFePick())
				.collect(Collectors.summingInt(Integer::intValue)));

		proyeccion.setTo4shNoFePick(proyeccionDetalles.stream().map(x -> x.getCa4shNoFePick())
				.collect(Collectors.summingInt(Integer::intValue)));

		// TOTAL BOOK
		proyeccion.setTo2sdBook(proyeccionDetalles.stream().map(x -> x.getCa2sdFe() + x.getCa2sdNoFe())
				.collect(Collectors.summingInt(Integer::intValue)));

		proyeccion.setTo4sdBook(proyeccionDetalles.stream().map(x -> x.getCa4sdFe() + x.getCa4sdNoFe())
				.collect(Collectors.summingInt(Integer::intValue)));

		proyeccion.setTo4shBook(proyeccionDetalles.stream().map(x -> x.getCa4shFe() + x.getCa4shNoFe())
				.collect(Collectors.summingInt(Integer::intValue)));

		// TOTAL PICK
		proyeccion.setTo2sdPick(proyeccionDetalles.stream().map(x -> x.getCa2sdFePick() + x.getCa2sdNoFePick())
				.collect(Collectors.summingInt(Integer::intValue)));

		proyeccion.setTo4sdPick(proyeccionDetalles.stream().map(x -> x.getCa4sdFePick() + x.getCa4sdNoFePick())
				.collect(Collectors.summingInt(Integer::intValue)));

		proyeccion.setTo4shPick(proyeccionDetalles.stream().map(x -> x.getCa4shFePick() + x.getCa4shNoFePick())
				.collect(Collectors.summingInt(Integer::intValue)));

		// Solo para proyeccion de equipos
		if (proyeccion.getFgTipo().equals("E")) {

			proyeccion = this.registrarRatioDevolucion(proyeccion);
			proyeccion = this.calcularEmptyReturn(proyeccion);
			proyeccion = this.registrarRpo(proyeccion);
			proyeccion = this.calcularAvailable(proyeccion);

		}

		return proyeccion;
	}

	private List<ProyeccionDetalle> generarDetalle(List<Mtc1r999Detalle> mtc1r999Detalle) {

		List<ProyeccionDetalle> proyeccionDetalles = new ArrayList<>();

		List<Nave> naves = naveService.listar();

		List<String> claves = mtc1r999Detalle.stream().map(x -> x.getNave() + x.getViaje() + x.getCutOff()).distinct()
				.collect(Collectors.toList());

		for (String clave : claves) {

			ProyeccionDetalle proyeccionDetalle = new ProyeccionDetalle();

			List<Mtc1r999Detalle> mtc1r999Detalles = mtc1r999Detalle.stream()
					.filter(f -> (f.getNave() + f.getViaje() + f.getCutOff()).equals(clave))
					.collect(Collectors.toList());

			Nave nave = naves.stream().filter(f -> f.getCodigo().equals(mtc1r999Detalles.get(0).getNave())).findFirst()
					.orElse(null);

			if (nave != null) {
				proyeccionDetalle.setNave(nave);
				proyeccionDetalle.setViaje(mtc1r999Detalles.get(0).getViaje());
				proyeccionDetalle.setEta(mtc1r999Detalles.get(0).getCutOff().plusDays(2));

				// OBTNER SI ES FE O NON FE
				if (nave.getServicio().getFgFarEast().equals("S")) {
					proyeccionDetalle.setCa2sdFe(this.obtenerQty(mtc1r999Detalles, "2SD"));
					proyeccionDetalle.setCa2sdFePick(this.obtenerPick(mtc1r999Detalles, "2SD"));
					proyeccionDetalle.setCa4sdFe(this.obtenerQty(mtc1r999Detalles, "4SD"));
					proyeccionDetalle.setCa4sdFePick(this.obtenerPick(mtc1r999Detalles, "4SD"));
					proyeccionDetalle.setCa4shFe(this.obtenerQty(mtc1r999Detalles, "4SH"));
					proyeccionDetalle.setCa4shFePick(this.obtenerPick(mtc1r999Detalles, "4SH"));
					proyeccionDetalle.setCa2sdNoFe(0);
					proyeccionDetalle.setCa2sdNoFePick(0);
					proyeccionDetalle.setCa4sdNoFe(0);
					proyeccionDetalle.setCa4sdNoFePick(0);
					proyeccionDetalle.setCa4shNoFe(0);
					proyeccionDetalle.setCa4shNoFePick(0);
				} else {
					proyeccionDetalle.setCa2sdFe(0);
					proyeccionDetalle.setCa2sdFePick(0);
					proyeccionDetalle.setCa4sdFe(0);
					proyeccionDetalle.setCa4sdFePick(0);
					proyeccionDetalle.setCa4shFe(0);
					proyeccionDetalle.setCa4shFePick(0);
					proyeccionDetalle.setCa2sdNoFe(this.obtenerQty(mtc1r999Detalles, "2SD"));
					proyeccionDetalle.setCa2sdNoFePick(this.obtenerPick(mtc1r999Detalles, "2SD"));
					proyeccionDetalle.setCa4sdNoFe(this.obtenerQty(mtc1r999Detalles, "4SD"));
					proyeccionDetalle.setCa4sdNoFePick(this.obtenerPick(mtc1r999Detalles, "4SD"));
					proyeccionDetalle.setCa4shNoFe(this.obtenerQty(mtc1r999Detalles, "4SH"));
					proyeccionDetalle.setCa4shNoFePick(this.obtenerPick(mtc1r999Detalles, "4SH"));
				}

				proyeccionDetalles.add(proyeccionDetalle);
			}

		}

		return proyeccionDetalles;
	}

	private Integer obtenerQty(List<Mtc1r999Detalle> detalles, String tpe) {
		return detalles.stream().filter(f -> f.getTpe().equals(tpe)).map(x -> x.getQty())
				.collect(Collectors.summingInt(Integer::intValue));
	}

	private Integer obtenerPick(List<Mtc1r999Detalle> detalles, String tpe) {
		return detalles.stream().filter(f -> f.getTpe().equals(tpe)).map(x -> x.getPick())
				.collect(Collectors.summingInt(Integer::intValue));
	}

	private Proyeccion registrarRatioDevolucion(Proyeccion proyeccion) {

		RatioDevolucion ratioDevolucion = ratioDevolucionService.listar().stream().findFirst().orElse(null);
		proyeccion.setRatio2sd(ratioDevolucion.getRatio2sd());
		proyeccion.setRatio4sd(ratioDevolucion.getRatio4sd());
		proyeccion.setRatio4sh(ratioDevolucion.getRatio4sh());

		return proyeccion;
	}

	private Proyeccion calcularEmptyReturn(Proyeccion proyeccion) {

		// 6 Días a la semana (sin domingo) por 4 semanas (mes) = 24
		proyeccion.setNuDiasHabiles(24);

		// Obtiene el mayor ETA de la lista de detalles
		ProyeccionDetalle detalleLastEta = proyeccion.getDetalle().stream()
				.max(Comparator.comparing(ProyeccionDetalle::getEta)).orElse(null);

		// La fecha para el Empty Return es el mayor ETA menos 7 días
		proyeccion.setFeEmptyReturn(detalleLastEta.getEta().minusDays(7));

		// Obtiene fechas de inicio y fin para el cálculo de # de días hábiles
		LocalDate fechaFin = detalleLastEta.getEta();
		LocalDate fechaIni = LocalDate.now().minusDays(7);

		// Obtiene fechas
		List<Calendario> calendario = calendarioService.listarPorFechas(fechaIni, fechaFin);

		Integer nuDiasRetorno = (int) calendario.stream().filter(f -> f.getFecha().compareTo(LocalDate.now()) > 0
				&& f.getFecha().compareTo(fechaFin) <= 0 && f.getFgFeriado().equals("N")).count();

		proyeccion.setNuDiasRetorno(nuDiasRetorno);

		Integer EmptyRet2sd = Math
				.round((proyeccion.getRatio2sd() / proyeccion.getNuDiasHabiles()) * proyeccion.getNuDiasRetorno());
		Integer EmptyRet4sd = Math
				.round((proyeccion.getRatio4sd() / proyeccion.getNuDiasHabiles()) * proyeccion.getNuDiasRetorno());
		Integer EmptyRet4sh = Math
				.round((proyeccion.getRatio4sh() / proyeccion.getNuDiasHabiles()) * proyeccion.getNuDiasRetorno());

		proyeccion.setEmptyRet2sd(EmptyRet2sd);
		proyeccion.setEmptyRet4sd(EmptyRet4sd);
		proyeccion.setEmptyRet4sh(EmptyRet4sh);

		return proyeccion;
	}

	private Proyeccion registrarRpo(Proyeccion proyeccion) {

		List<ProyeccionRpo> proyeccionRpos = new ArrayList<>();
		List<RpoPlan> rpos = rpoPlanService.listar();

		for (RpoPlan rpo : rpos) {

			ProyeccionRpo proyeccionRpo = new ProyeccionRpo();

			proyeccionRpo.setNave(rpo.getNave());
			proyeccionRpo.setViaje(rpo.getViaje());
			proyeccionRpo.setRpo2sd(rpo.getRpo2sd());
			proyeccionRpo.setRpo4sd(rpo.getRpo4sd());
			proyeccionRpo.setRpo4sh(rpo.getRpo4sh());
			proyeccionRpo.setEta(rpo.getEta());

			proyeccionRpos.add(proyeccionRpo);

		}

		proyeccion.setRpo(proyeccionRpos);

		return proyeccion;
	}

	private Proyeccion calcularAvailable(Proyeccion proyeccion) {

		Integer to2sdRpo = proyeccion.getRpo().stream().map(x -> x.getRpo2sd())
				.collect(Collectors.summingInt(Integer::intValue));
		Integer to4sdRpo = proyeccion.getRpo().stream().map(x -> x.getRpo4sd())
				.collect(Collectors.summingInt(Integer::intValue));
		Integer to4shRpo = proyeccion.getRpo().stream().map(x -> x.getRpo4sh())
				.collect(Collectors.summingInt(Integer::intValue));

		proyeccion.setAvailable2sd(
				proyeccion.getEmptyRet2sd() + proyeccion.getTo2sdBook() + proyeccion.getTo2sdPick() + to2sdRpo);
		proyeccion.setAvailable4sd(
				proyeccion.getEmptyRet4sd() + proyeccion.getTo4sdBook() + proyeccion.getTo4sdPick() + to4sdRpo);
		proyeccion.setAvailable4sh(
				proyeccion.getEmptyRet4sh() + proyeccion.getTo4shBook() + proyeccion.getTo4shPick() + to4shRpo);

		return proyeccion;
	}

}
