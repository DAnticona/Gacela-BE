package com.wollcorp.gacela.service.forecast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wollcorp.gacela.entity.Forecast;
import com.wollcorp.gacela.entity.ForecastDetalle;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReporteWSA1Local {

	final String templateWSA1 = "C:\\opt\\gacelaConfig\\filesTemplates\\forecastWSA1.xlsx";

	/**
	 * Procesa el forecast obteniendo el reporte WSA1Local en excel
	 * 
	 * @param forecast Forecast a procesar, obtenido del usuario
	 * @return Libro de excel a enviar al usuario.
	 */
	public XSSFWorkbook generarReporte(Forecast forecast) {

		try {

			FileInputStream fis = new FileInputStream(new File(this.templateWSA1));

			XSSFWorkbook wb = new XSSFWorkbook(fis);

			XSSFSheet sheet1 = wb.getSheetAt(0);
			XSSFSheet sheet2 = wb.getSheetAt(1);

			sheet1.getRow(1).getCell(0).setCellValue("BOOKING FOR WSA1 - Servicio EVL WSA1");
			sheet1.getRow(2).getCell(0).setCellValue("VESSEL: " + forecast.getNave().getNombre());

			sheet1 = this.generarReporteHoja1(forecast, sheet1);

			sheet1 = this.generarResumenHoja1(forecast, sheet1);

			sheet2 = this.generarResumenHoja2(forecast, sheet2);

			sheet1.getWorkbook().getCreationHelper().createFormulaEvaluator().evaluateAll();
			sheet2.getWorkbook().getCreationHelper().createFormulaEvaluator().evaluateAll();

			return wb;

		} catch (IOException e) {
			log.error("Error on generate excel file");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error on generate excel file");
		}
	}

	/**
	 * Inicio de la generación del reporte WSA1Local en la hoja1, llama al método
	 * llenarDatosXPuerto por cada línea.
	 * 
	 * @param forecast Extraído de la data de excel (input).
	 * @param sheet    Hoja de excel actual.
	 * @return Hoja de excel procesada.
	 */
	private XSSFSheet generarReporteHoja1(Forecast forecast, XSSFSheet sheet) {

		int rowIni = 0;
		int rowFin = 0;

		List<ForecastDetalle> detalleXLinea = null;

		// CCO
		rowIni = 9;
		rowFin = 19;
		detalleXLinea = forecast.getDetalle().stream().filter(f -> f.getLinea().equals("CCO"))
				.collect(Collectors.toList());
		this.llenarDatosXPuerto(detalleXLinea, sheet, rowIni, rowFin);

		// WHL
		rowIni = 20;
		rowFin = 30;
		detalleXLinea = forecast.getDetalle().stream().filter(f -> f.getLinea().equals("WHL"))
				.collect(Collectors.toList());
		this.llenarDatosXPuerto(detalleXLinea, sheet, rowIni, rowFin);

		// PIL
		rowIni = 31;
		rowFin = 41;
		detalleXLinea = forecast.getDetalle().stream().filter(f -> f.getLinea().equals("PIL"))
				.collect(Collectors.toList());
		this.llenarDatosXPuerto(detalleXLinea, sheet, rowIni, rowFin);

		// YML
		rowIni = 42;
		rowFin = 52;
		detalleXLinea = forecast.getDetalle().stream().filter(f -> f.getLinea().equals("YML"))
				.collect(Collectors.toList());
		this.llenarDatosXPuerto(detalleXLinea, sheet, rowIni, rowFin);

		// APL
		rowIni = 53;
		rowFin = 63;
		detalleXLinea = forecast.getDetalle().stream().filter(f -> f.getLinea().equals("APL"))
				.collect(Collectors.toList());
		this.llenarDatosXPuerto(detalleXLinea, sheet, rowIni, rowFin);

		// EVG
		rowIni = 64;
		rowFin = 74;
		detalleXLinea = forecast.getDetalle().stream().filter(f -> f.getLinea().equals("EVG"))
				.collect(Collectors.toList());
		this.llenarDatosXPuerto(detalleXLinea, sheet, rowIni, rowFin);

		return sheet;
	}

	/**
	 * Filtra datos por puerto y llama al método llenarDatosXTipo, por cada puerto y
	 * tipo que existe.
	 * 
	 * @param detalleXLinea Forecast filtrado por línea
	 * @param sheet         Hoja de excel actual.
	 * @param rowIni        Fila inicial de la línea actual.
	 * @param rowFin        Fila final de la línea actual
	 * @return Hoja de excel procesada.
	 */
	private XSSFSheet llenarDatosXPuerto(List<ForecastDetalle> detalleXLinea, XSSFSheet sheet, int rowIni, int rowFin) {

		int colPuerto = 1;

		List<ForecastDetalle> detalleXLineaXPuerto = null;

		for (int r = rowIni; r <= rowFin; r++) {
			String puerto = sheet.getRow(r).getCell(colPuerto).getStringCellValue().trim();

			detalleXLineaXPuerto = detalleXLinea.stream().filter(f -> f.getPod().equals(puerto))
					.collect(Collectors.toList());

			// 20SD FULL
			sheet = this.llenarDatosXTipo(detalleXLineaXPuerto, sheet, puerto, 20, "SD", "F", r, 2, rowFin);

			// 20SD EMPTY
			sheet = this.llenarDatosXTipo(detalleXLineaXPuerto, sheet, puerto, 20, "SD", "E", r, 3, rowFin);

			// 20FR FULL
			sheet = this.llenarDatosXTipo(detalleXLineaXPuerto, sheet, puerto, 20, "FR", "F", r, 4, rowFin);

			// 20FR EMPTY
			sheet = this.llenarDatosXTipo(detalleXLineaXPuerto, sheet, puerto, 20, "FR", "E", r, 5, rowFin);

			// 20OT FULL
			sheet = this.llenarDatosXTipo(detalleXLineaXPuerto, sheet, puerto, 20, "OT", "F", r, 6, rowFin);

			// 20OT EMPTY
			sheet = this.llenarDatosXTipo(detalleXLineaXPuerto, sheet, puerto, 20, "OT", "E", r, 7, rowFin);

			// 40SD FULL
			sheet = this.llenarDatosXTipo(detalleXLineaXPuerto, sheet, puerto, 40, "SD", "F", r, 8, rowFin);

			// 40SD EMPTY
			sheet = this.llenarDatosXTipo(detalleXLineaXPuerto, sheet, puerto, 40, "SD", "E", r, 9, rowFin);

			// 40OT FULL
			sheet = this.llenarDatosXTipo(detalleXLineaXPuerto, sheet, puerto, 40, "OT", "F", r, 10, rowFin);

			// 40OT EMPTY
			sheet = this.llenarDatosXTipo(detalleXLineaXPuerto, sheet, puerto, 40, "OT", "E", r, 11, rowFin);

			// 40FR FULL
			sheet = this.llenarDatosXTipo(detalleXLineaXPuerto, sheet, puerto, 40, "FR", "F", r, 12, rowFin);

			// 40FR EMPTY
			sheet = this.llenarDatosXTipo(detalleXLineaXPuerto, sheet, puerto, 40, "FR", "E", r, 13, rowFin);

			// 40SH FULL
			sheet = this.llenarDatosXTipo(detalleXLineaXPuerto, sheet, puerto, 40, "SH", "F", r, 14, rowFin);

			// 40SH EMPTY
			sheet = this.llenarDatosXTipo(detalleXLineaXPuerto, sheet, puerto, 40, "SH", "E", r, 15, rowFin);

			// 40RH FULL
			sheet = this.llenarDatosXTipo(detalleXLineaXPuerto, sheet, puerto, 40, "RH", "F", r, 16, rowFin);

			// 40RH EMPTY
			sheet = this.llenarDatosXTipo(detalleXLineaXPuerto, sheet, puerto, 40, "RH", "E", r, 17, rowFin);

		}
		return sheet;
	}

	/**
	 * Escribe en la hoja de excel actual los valores correspondientes al reporte.
	 * 
	 * @param detalleXLineaXPuerto Forecast filtrado por línea, puerto y tipo.
	 * @param sheet                Hoja de excel actual.
	 * @param puerto               Puerto actual.
	 * @param size                 Tamaño del contenedor actual.
	 * @param type                 Tipo de contenedor actual.
	 * @param cnd                  Estado del contenedor actual.
	 * @param row                  Fila de la hoja de excel actual.
	 * @param col                  Columna de la hoja de excel actual.
	 * @param rowFin               Fila final de la línea actual.
	 * @return Hoja de excel procesada.
	 */
	private XSSFSheet llenarDatosXTipo(List<ForecastDetalle> detalleXLineaXPuerto, XSSFSheet sheet, String puerto,
			int size, String type, String cnd, int row, int col, int rowFin) {

		int cantidad = detalleXLineaXPuerto.stream()
				.filter(f -> f.getSize() == size && f.getType().equals(type) && f.getCnd().equals(cnd))
				.collect(Collectors.toList()).size();

		double peso = detalleXLineaXPuerto.stream()
				.filter(f -> f.getSize() == size && f.getType().equals(type) && f.getCnd().equals(cnd))
				.map(x -> x.getVgm()).collect(Collectors.summingLong(Long::longValue)) / 1000.0;

		double pesoXPuerto = sheet.getRow(row).getCell(19).getNumericCellValue();
		double pesoXTipo = sheet.getRow(rowFin).getCell(col).getNumericCellValue();

		pesoXPuerto = pesoXPuerto + peso;

		pesoXTipo = pesoXTipo + peso;

		if (cantidad > 0) {
			sheet.getRow(row).getCell(col).setCellValue(cantidad);
		}

		if (pesoXPuerto > 0) {
			sheet.getRow(row).getCell(19).setCellValue(pesoXPuerto);
		}

		if (pesoXTipo > 0) {
			sheet.getRow(rowFin).getCell(col).setCellValue(pesoXTipo);
		}

		return sheet;
	}

	/**
	 * Genera resumen de la hoja 1
	 * 
	 * @param forecast Obtenido del excel ingresado por el usuario.
	 * @param sheet    Hoja de excel actual
	 * @return Hoja de excel procesada
	 */
	private XSSFSheet generarResumenHoja1(Forecast forecast, XSSFSheet sheet) {

		int rowRH = 92;
		int rowDG = 92;
		int colRH = 15;
		int colDG = 20;
		List<String> resumenes = null;

		resumenes = this.generarResumenRH(forecast.getDetalle());
		sheet = this.escribirResumenes(sheet, resumenes, rowRH, colRH);

		resumenes = this.generarResumenDG(forecast.getDetalle());
		sheet = this.escribirResumenes(sheet, resumenes, rowDG, colDG);

		return sheet;
	}

	/**
	 * Genera resumen de la hoja 2
	 * 
	 * @param forecast Obtenido del excel ingresado por el usuario.
	 * @param sheet    Hoja de excel actual.
	 * @return Hoja de excel procesada.
	 */
	private XSSFSheet generarResumenHoja2(Forecast forecast, XSSFSheet sheet) {

		List<ForecastDetalle> detalle = null;
		List<String> resumenes = null;

		// CCO
		detalle = forecast.getDetalle().stream().filter(f -> f.getLinea().equals("CCO")).collect(Collectors.toList());
		resumenes = this.generarResumenRH(detalle);
		sheet = this.escribirResumenes(sheet, resumenes, 1, 0);

		resumenes = this.generarResumenDG(detalle);
		sheet = this.escribirResumenes(sheet, resumenes, 12, 0);

		// WHL
		detalle = forecast.getDetalle().stream().filter(f -> f.getLinea().equals("WHL")).collect(Collectors.toList());
		resumenes = this.generarResumenRH(detalle);
		sheet = this.escribirResumenes(sheet, resumenes, 1, 1);

		resumenes = this.generarResumenDG(detalle);
		sheet = this.escribirResumenes(sheet, resumenes, 12, 1);

		// PIL
		detalle = forecast.getDetalle().stream().filter(f -> f.getLinea().equals("PIL")).collect(Collectors.toList());
		resumenes = this.generarResumenRH(detalle);
		sheet = this.escribirResumenes(sheet, resumenes, 1, 2);

		resumenes = this.generarResumenDG(detalle);
		sheet = this.escribirResumenes(sheet, resumenes, 12, 2);

		// YML
		detalle = forecast.getDetalle().stream().filter(f -> f.getLinea().equals("YML")).collect(Collectors.toList());
		resumenes = this.generarResumenRH(detalle);
		sheet = this.escribirResumenes(sheet, resumenes, 1, 3);

		resumenes = this.generarResumenDG(detalle);
		sheet = this.escribirResumenes(sheet, resumenes, 12, 3);

		// APL
		detalle = forecast.getDetalle().stream().filter(f -> f.getLinea().equals("APL")).collect(Collectors.toList());
		resumenes = this.generarResumenRH(detalle);
		sheet = this.escribirResumenes(sheet, resumenes, 1, 4);

		resumenes = this.generarResumenDG(detalle);
		sheet = this.escribirResumenes(sheet, resumenes, 12, 4);

		// EVG
		detalle = forecast.getDetalle().stream().filter(f -> f.getLinea().equals("EVG")).collect(Collectors.toList());
		resumenes = this.generarResumenRH(detalle);
		sheet = this.escribirResumenes(sheet, resumenes, 1, 5);

		resumenes = this.generarResumenDG(detalle);
		sheet = this.escribirResumenes(sheet, resumenes, 12, 5);

		return sheet;
	}

	/**
	 * Obtiene los resumenes de tipo RH.
	 * 
	 * @param detalle Del forecast a actual.
	 * @return Lista de resúmenes RH
	 */
	private List<String> generarResumenRH(List<ForecastDetalle> detalle) {

		List<String> resumenes = new ArrayList<>();

		List<String> puertos = detalle.stream().map(x -> x.getPod()).distinct().collect(Collectors.toList());

		for (String puerto : puertos) {

			List<ForecastDetalle> listaRHFull = detalle.stream()
					.filter(f -> f.getPod().equals(puerto) && f.getType().equals("RH") && f.getCnd().equals("F"))
					.collect(Collectors.toList());

			List<ForecastDetalle> listaRHEmpty = detalle.stream()
					.filter(f -> f.getPod().equals(puerto) && f.getType().equals("RH") && f.getCnd().equals("E"))
					.collect(Collectors.toList());

			if (listaRHFull.size() > 0 || listaRHEmpty.size() > 0) {

				if (listaRHFull.size() > 0) {
					double pesoFull = listaRHFull.stream().map(x -> x.getVgm())
							.collect(Collectors.summingLong(Long::longValue)) / 1000.0;

					String resumen = listaRHFull.size() + " X 40RH-F /PECAL-" + puerto + " / WGT " + pesoFull;

					resumenes.add(resumen);
				}

				if (listaRHEmpty.size() > 0) {
					double pesoEmpty = listaRHEmpty.stream().map(x -> x.getVgm())
							.collect(Collectors.summingLong(Long::longValue)) / 1000.0;

					String resumen = listaRHEmpty.size() + " X 40RH-E /PECAL-" + puerto + " / WGT " + pesoEmpty;

					resumenes.add(resumen);
				}
			}
		}

		return resumenes;
	}

	/**
	 * Genera el resumen de tipo DG.
	 * 
	 * @param detalle Del forecast actual.
	 * @return Lista de resúmenes de tipo DG
	 */
	private List<String> generarResumenDG(List<ForecastDetalle> detalle) {

		List<String> resumenes = new ArrayList<>();

		List<String> DGKeys = detalle.stream().filter(f -> f.getImo() != null && f.getUn() != null)
				.map(x -> x.getPod() + x.getImo() + x.getUn()).distinct().collect(Collectors.toList());

		for (String key : DGKeys) {
			List<ForecastDetalle> listaDG = detalle.stream()
					.filter(f -> (f.getPod() + f.getImo() + f.getUn()).equals(key)).collect(Collectors.toList());

			if (listaDG.size() > 0) {

				String resumen = listaDG.size() + " X " + listaDG.get(0).getSize() + listaDG.get(0).getType() + "-"
						+ listaDG.get(0).getCnd() + " /PECAL-" + listaDG.get(0).getPod() + " / IMO "
						+ listaDG.get(0).getImo() + " UN " + listaDG.get(0).getUn();

				resumenes.add(resumen);
			}
		}

		return resumenes;
	}

	/**
	 * Escribe resumenes en la hoja de excel actual.
	 * 
	 * @param sheet     Hoja de excel actual.
	 * @param resumenes Lista de resúmenes a escribir.
	 * @param rowIni    Fila inicial donde escribir.
	 * @param col       Columna donde escribir
	 * @return Hoja de excel procesada.
	 */
	private XSSFSheet escribirResumenes(XSSFSheet sheet, List<String> resumenes, int rowIni, int col) {

		for (String resumen : resumenes) {
			sheet.getRow(rowIni + 1).getCell(col).setCellValue(resumen);
			rowIni++;
		}
		return sheet;
	}
}
