package com.wollcorp.gacela.service.forecast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wollcorp.gacela.entity.Forecast;
import com.wollcorp.gacela.entity.ForecastDetalle;
import com.wollcorp.gacela.entity.Puerto;
import com.wollcorp.gacela.service.PuertoService;
import com.wollcorp.gacela.service.TipoContenedorService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReporteWSA4Partner {

	@Autowired
	PuertoService puertoService;

	@Autowired
	TipoContenedorService tipoContenedorService;

	final String templateWSA1 = "C:\\opt\\gacelaConfig\\filesTemplates\\forecastWSA4Partner.xlsx";

	/**
	 * Genera el reporte WSA4 Partner, coge el template del mismo.
	 * 
	 * @param forecast Forecast a procesar.
	 * @return Libro de excel.
	 */
	public XSSFWorkbook generarReporte(Forecast forecast) {
		try {
			FileInputStream fis = new FileInputStream(new File(this.templateWSA1));

			XSSFWorkbook wb = new XSSFWorkbook(fis);

			XSSFSheet xSheet1 = wb.getSheetAt(0);

			// Escribiendo título - Nombre de la nave
			xSheet1.getRow(3).getCell(4).setCellValue(forecast.getNave().getNombre());

			List<Puerto> puertos = puertoService.listar();

			for (int r = 8; r < 19; r++) {
				String puerto = xSheet1.getRow(r).getCell(1).getStringCellValue();

				if (puertos.stream().filter(f -> f.getAlias1() != null && f.getAlias1().equals(puerto))
						.map(x -> x.getCoSol()).collect(Collectors.toList()).size() > 0) {

					String coSolPuerto = puertos.stream()
							.filter(f -> f.getAlias1() != null && f.getAlias1().equals(puerto)).map(x -> x.getCoSol())
							.collect(Collectors.toList()).get(0);

					List<ForecastDetalle> detalle = forecast.getDetalle().stream()
							.filter(f -> f.getPod().equals(coSolPuerto)).collect(Collectors.toList());
					long cantidad;
					// 20SD FULL
					cantidad = detalle.stream()
							.filter(f -> f.getSize().equals(20) && f.getType().equals("SD") && f.getCnd().equals("F"))
							.count();
					if (cantidad > 0) {
						xSheet1.getRow(r).getCell(2).setCellValue(cantidad);
					}

					// 20SD EMPTY
					cantidad = detalle.stream()
							.filter(f -> f.getSize().equals(20) && f.getType().equals("SD") && f.getCnd().equals("E"))
							.count();
					if (cantidad > 0) {
						xSheet1.getRow(r).getCell(11).setCellValue(cantidad);
					}

					// 40SD FULL
					cantidad = detalle.stream()
							.filter(f -> f.getSize().equals(40) && f.getType().equals("SD") && f.getCnd().equals("F"))
							.count();
					if (cantidad > 0) {
						xSheet1.getRow(r).getCell(3).setCellValue(cantidad);
					}

					// 40SD EMPTY
					cantidad = detalle.stream()
							.filter(f -> f.getSize().equals(40) && f.getType().equals("SD") && f.getCnd().equals("E"))
							.count();
					if (cantidad > 0) {
						xSheet1.getRow(r).getCell(12).setCellValue(cantidad);
					}

					// 40SH FULL
					cantidad = detalle.stream()
							.filter(f -> f.getSize().equals(40) && f.getType().equals("SH") && f.getCnd().equals("F"))
							.count();
					if (cantidad > 0) {
						xSheet1.getRow(r).getCell(4).setCellValue(cantidad);
					}

					// 40SH EMPTY
					cantidad = detalle.stream()
							.filter(f -> f.getSize().equals(40) && f.getType().equals("SH") && f.getCnd().equals("E"))
							.count();
					if (cantidad > 0) {
						xSheet1.getRow(r).getCell(13).setCellValue(cantidad);
					}

					// 40RH FULL
					cantidad = detalle.stream()
							.filter(f -> f.getSize().equals(40) && f.getType().equals("RH") && f.getCnd().equals("F"))
							.count();
					if (cantidad > 0) {
						xSheet1.getRow(r).getCell(6).setCellValue(cantidad);
					}

					// 40RH EMPTY
					cantidad = detalle.stream()
							.filter(f -> f.getSize().equals(40) && f.getType().equals("RH") && f.getCnd().equals("E"))
							.count();
					if (cantidad > 0) {
						xSheet1.getRow(r).getCell(15).setCellValue(cantidad);
					}
				}
			}

			int rowDG = 26;
			int colDG = 1;
			List<String> resumenes = null;

			resumenes = this.generarResumenDG(forecast.getDetalle());
			xSheet1 = this.escribirResumenes(xSheet1, resumenes, rowDG, colDG);

			xSheet1.getWorkbook().getCreationHelper().createFormulaEvaluator().evaluateAll();
			return wb;

		} catch (IOException e) {
			log.error("Error on generate excel file");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error on generate excel file");
		}
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

				String pod = puertoService.listar().stream().filter(f -> f.getCoSol().equals(listaDG.get(0).getPod()))
						.map(x -> x.getCoIso()).findFirst().orElse(null);

				String type = tipoContenedorService.listar().stream()
						.filter(f -> f.getCoSol().equals(listaDG.get(0).getType())).map(x -> x.getCoIso()).findFirst()
						.orElse(null);

				String resumen = listaDG.size() + "X" + listaDG.get(0).getSize() + type + " // POD: " + pod + " // IMO "
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
