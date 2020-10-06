package com.wollcorp.gacela.service.forecast;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.entity.Forecast;
import com.wollcorp.gacela.entity.ForecastDetalle;
import com.wollcorp.gacela.util.EstilosExcel;

@Service
public class ReportePWS2Partner {
	
	@Autowired
	EstilosExcel estilosExcel;

	/**
	 * Genera el reporte para Partner, genera un excel desde cero (sin utilizar un
	 * template) a diferencia del Reporte Local WSA 1 ó 2.
	 * 
	 * @param forecast Forecast a procesar.
	 * @return Libro de excel procesado.
	 */
	public XSSFWorkbook generarReporte(Forecast forecast) {

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet xSheet1 = wb.createSheet("FORECAST");

		List<String> cabeceras = new ArrayList<String>();
		cabeceras.add("N");
		cabeceras.add("POD");
		cabeceras.add("TYPE");
		cabeceras.add("QTY");
		cabeceras.add("WGT");
		cabeceras.add("OOG");
		cabeceras.add("STATUS");

		xSheet1 = this.escribirTitulo(xSheet1, forecast, cabeceras);
		xSheet1 = this.escribirCabeceras(xSheet1, cabeceras);
		xSheet1 = this.escribirReporte(xSheet1, forecast.getDetalle());
		xSheet1 = this.escribirResumenes(xSheet1, forecast.getDetalle());

		xSheet1.getWorkbook().getCreationHelper().createFormulaEvaluator().evaluateAll();
		return wb;
	}

	/**
	 * Escribe el título del reporte con el estilo correspondiente.
	 * 
	 * @param xSheet    Hoja de excel a procesar.
	 * @param forecast  A procesar.
	 * @param cabeceras Subtítulos que indican el número de celdas a combinar.
	 * @return Hoja de excel procesada.
	 */
	private XSSFSheet escribirTitulo(XSSFSheet xSheet, Forecast forecast, List<String> cabeceras) {

		XSSFCellStyle xStyle = xSheet.getWorkbook().createCellStyle();
		xStyle = estilosExcel.crearBordes(xStyle, Color.BLACK, BorderStyle.MEDIUM);
		xStyle = estilosExcel.crearFuente(xSheet.getWorkbook(), xStyle, Color.WHITE, 20, true);
		xStyle = estilosExcel.crearColorFondo(xStyle, new Color(69, 178, 69)); // VERDE
		xStyle = estilosExcel.crearTextoAlineado(xStyle, HorizontalAlignment.CENTER);

		XSSFRow xRow = xSheet.createRow(0);

		for (int i = 0; i < cabeceras.size(); i++) {
			xRow.createCell(i).setCellStyle(xStyle);
		}

		xSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, cabeceras.size() - 1));
		xRow.getCell(0).setCellValue("MV. " + forecast.getNave().getCodigo());

		return xSheet;
	}

	/**
	 * Escribe las cabeceras del reporte con el estilo correspondiente.
	 * 
	 * @param xSheet    Hoja de excel actual.
	 * @param cabeceras Subtitulos a escribir en el reporte.
	 * @return Hoja de excel procesada.
	 */
	private XSSFSheet escribirCabeceras(XSSFSheet xSheet, List<String> cabeceras) {

		XSSFCellStyle xStyle = xSheet.getWorkbook().createCellStyle();
		xStyle = estilosExcel.crearBordes(xStyle, Color.BLACK, BorderStyle.MEDIUM);
		xStyle = estilosExcel.crearFuente(xSheet.getWorkbook(), xStyle, Color.WHITE, 13, true);
		xStyle = estilosExcel.crearColorFondo(xStyle, new Color(69, 178, 69)); // VERDE
		xStyle = estilosExcel.crearTextoAlineado(xStyle, HorizontalAlignment.CENTER);

		XSSFRow xRow = xSheet.createRow(1);

		for (int i = 0; i < cabeceras.size(); i++) {
			xRow.createCell(i).setCellStyle(xStyle);
			xRow.getCell(i).setCellValue(cabeceras.get(i));
		}

		return xSheet;
	}

	/**
	 * Inicia la generación del reporte.
	 * 
	 * @param xSheet  Hoja de excel actual.
	 * @param detalle Del forecast a procesar.
	 * @return Hoja de excel procesada.
	 */
	private XSSFSheet escribirReporte(XSSFSheet xSheet, List<ForecastDetalle> detalle) {
		int row = 2;
		int item = 1;
		List<ForecastDetalle> listaData = null;

		List<Integer> sizes = detalle.stream().map(x -> x.getSize()).distinct().collect(Collectors.toList());

		for (Integer size : sizes) {

			List<String> types = detalle.stream().filter(f -> f.getSize().equals(size)).map(x -> x.getType()).distinct()
					.collect(Collectors.toList());

			for (String type : types) {

				List<String> cnds = detalle.stream().filter(f -> f.getSize().equals(size) && f.getType().equals(type))
						.map(x -> x.getCnd()).distinct().collect(Collectors.toList());

				for (String cnd : cnds) {

					List<String> puertos = detalle.stream()
							.filter(f -> f.getSize().equals(size) && f.getType().equals(type) && f.getCnd().equals(cnd))
							.map(x -> x.getPod()).distinct().collect(Collectors.toList());

					for (String puerto : puertos) {

						listaData = detalle.stream()
								.filter(f -> f.getSize().equals(size) && f.getType().equals(type)
										&& f.getCnd().equals(cnd) && f.getPod().equals(puerto))
								.collect(Collectors.toList());

						if (listaData.size() > 0) {
							xSheet = this.escribirData(xSheet, row, item, puerto, listaData, size, type, cnd);
							item++;
							row++;
						}
					}
				}
			}
		}

		return xSheet;
	}

	/**
	 * Escribe la data del reporte en la hoja de excel indicada con los estilos
	 * correspondientes.
	 * 
	 * @param xSheet Hoja de excel actual
	 * @param row    Fila actual donde se escribirá la data obtenida.
	 * @param item   Nro de item en el reporte.
	 * @param puerto POD en código SOL del forecast.
	 * @param lista  Detalle de forecast filtrado escribir en el reporte.
	 * @param size   Tamaño del contenedor del forecast.
	 * @param type   Tipo del contenedor del forecast
	 * @param cnd    Estado del contenedor del forecast
	 * @return Hoja de excel procesada.
	 */
	private XSSFSheet escribirData(XSSFSheet xSheet, int row, int item, String puerto, List<ForecastDetalle> lista,
			int size, String type, String cnd) {

		XSSFCellStyle xStyle = xSheet.getWorkbook().createCellStyle();
		xStyle = estilosExcel.crearBordes(xStyle, Color.BLACK, BorderStyle.MEDIUM);
		xStyle = estilosExcel.crearFuente(xSheet.getWorkbook(), xStyle, Color.BLACK, 10, true);
		xStyle = estilosExcel.crearTextoAlineado(xStyle, HorizontalAlignment.CENTER);

		XSSFRow xRow = xSheet.createRow(row);

		// N
		xRow.createCell(0).setCellValue(item);
		xRow.getCell(0).setCellStyle(xStyle);

		// POD
		xRow.createCell(1).setCellValue(puerto);
		xRow.getCell(1).setCellStyle(xStyle);

		// TYPE
		xRow.createCell(2).setCellValue((size / 10) + type);
		xRow.getCell(2).setCellStyle(xStyle);

		// QTY
		xRow.createCell(3).setCellValue(lista.size());
		xRow.getCell(3).setCellStyle(xStyle);

		// WGT
		double peso = (lista.stream().map(x -> x.getVgm()).collect(Collectors.summingLong(Long::longValue)) / 1000.0);
		xRow.createCell(4).setCellValue(peso);
		xRow.getCell(4).setCellStyle(xStyle);

		// OOG (Vacío)
		xRow.createCell(5).setCellStyle(xStyle);

		// STATUS
		String estado = (cnd.equals("F")) ? "FULL" : "EMPTY";
		xRow.createCell(6).setCellValue(estado);
		xRow.getCell(6).setCellStyle(xStyle);

		return xSheet;
	}

	/**
	 * Inicia la generación de los resúmenes del forecast, configura los estilos
	 * tanto de la data como de los titulos RH y DG y llama a los métodos
	 * correspondientes de cada tipo de resumen.
	 * 
	 * @param xSheet  Hoja de excel actual.
	 * @param detalle Del forecast.
	 * @return hoja de excel procesada.
	 */
	private XSSFSheet escribirResumenes(XSSFSheet xSheet, List<ForecastDetalle> detalle) {

		int row = xSheet.getLastRowNum() + 2;
		List<String> resumenes = null;

		// Título resumen RH
		XSSFCellStyle xStyle = xSheet.getWorkbook().createCellStyle();
		xStyle = estilosExcel.crearBordes(xStyle, Color.BLACK, BorderStyle.MEDIUM);
		xStyle = estilosExcel.crearFuente(xSheet.getWorkbook(), xStyle, Color.RED, 10, true);
		xStyle = estilosExcel.crearTextoAlineado(xStyle, HorizontalAlignment.CENTER);
		xStyle = estilosExcel.crearColorFondo(xStyle, Color.YELLOW);

		XSSFRow xRow = xSheet.createRow(row);

		for (int i = 0; i < 6; i++) {
			xRow.createCell(i).setCellStyle(xStyle);
			xRow.getCell(i).setCellValue("4RH CARGO");
		}

		xSheet.addMergedRegion(new CellRangeAddress(row, row, 0, 5));
		row++;

		// Data Resumen RH
		xStyle = xSheet.getWorkbook().createCellStyle();
		xStyle = estilosExcel.crearBordes(xStyle, Color.BLACK, BorderStyle.MEDIUM);
		xStyle = estilosExcel.crearFuente(xSheet.getWorkbook(), xStyle, Color.BLACK, 10, true);
		xStyle = estilosExcel.crearTextoAlineado(xStyle, HorizontalAlignment.CENTER);

		resumenes = this.generarResumenRH(detalle);

		for (String resumen : resumenes) {
			xRow = xSheet.createRow(row);
			for (int i = 0; i < 6; i++) {
				xRow.createCell(i).setCellStyle(xStyle);
				xRow.getCell(i).setCellValue(resumen);
			}
			xSheet.addMergedRegion(new CellRangeAddress(row, row, 0, 5));
			row++;
		}

		// Título Resumen DG
		xStyle = xSheet.getWorkbook().createCellStyle();
		xStyle = estilosExcel.crearBordes(xStyle, Color.BLACK, BorderStyle.MEDIUM);
		xStyle = estilosExcel.crearFuente(xSheet.getWorkbook(), xStyle, Color.RED, 10, true);
		xStyle = estilosExcel.crearTextoAlineado(xStyle, HorizontalAlignment.CENTER);
		xStyle = estilosExcel.crearColorFondo(xStyle, new Color(21, 186, 243)); // CELESTE

		xRow = xSheet.createRow(row);

		for (int i = 0; i < 6; i++) {
			xRow.createCell(i).setCellStyle(xStyle);
			xRow.getCell(i).setCellValue("DG CARGO DETAIL");
		}

		xSheet.addMergedRegion(new CellRangeAddress(row, row, 0, 5));
		row++;

		// Data Resumen DG
		xStyle = xSheet.getWorkbook().createCellStyle();
		xStyle = estilosExcel.crearBordes(xStyle, Color.BLACK, BorderStyle.MEDIUM);
		xStyle = estilosExcel.crearFuente(xSheet.getWorkbook(), xStyle, Color.BLACK, 10, true);
		xStyle = estilosExcel.crearTextoAlineado(xStyle, HorizontalAlignment.CENTER);

		resumenes = this.generarResumenDG(detalle);

		for (String resumen : resumenes) {
			xRow = xSheet.createRow(row);
			for (int i = 0; i < 6; i++) {
				xRow.createCell(i).setCellStyle(xStyle);
				xRow.getCell(i).setCellValue(resumen);
			}
			xSheet.addMergedRegion(new CellRangeAddress(row, row, 0, 5));
			row++;
		}
		return xSheet;
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

			List<ForecastDetalle> lista = detalle.stream()
					.filter(f -> f.getPod().equals(puerto) && f.getType().equals("RH")).collect(Collectors.toList());

			if (lista.size() > 0) {

				if (lista.size() > 0) {
					long peso = lista.stream().map(x -> x.getVgm()).collect(Collectors.summingLong(Long::longValue))
							/ 1000;
					String resumen = lista.size() + "x4RH/POD " + puerto + "/ " + peso + " TN";

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
			List<ForecastDetalle> lista = detalle.stream()
					.filter(f -> (f.getPod() + f.getImo() + f.getUn()).equals(key)).collect(Collectors.toList());

			if (lista.size() > 0) {
				long peso = lista.stream().map(x -> x.getVgm()).collect(Collectors.summingLong(Long::longValue)) / 1000;

				String resumen = lista.size() + "x" + (lista.get(0).getSize() / 10) + lista.get(0).getType() + "/POD "
						+ lista.get(0).getPod() + "/IMO " + lista.get(0).getImo() + " UN " + lista.get(0).getUn() + " "
						+ peso + " TN";

				resumenes.add(resumen);
			}
		}

		return resumenes;
	}

}
