package com.wollcorp.gacela.util;

import java.awt.Color;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder.BorderSide;
import org.springframework.stereotype.Component;

@Component
public class EstilosExcel {

	public XSSFCellStyle crearBordes(XSSFCellStyle style, Color color, BorderStyle tipo) {
		XSSFColor xColor = new XSSFColor(color, null);
		style.setBorderTop(tipo);
		style.setBorderColor(BorderSide.TOP, xColor);
		style.setBorderLeft(tipo);
		style.setBorderColor(BorderSide.LEFT, xColor);
		style.setBorderBottom(tipo);
		style.setBorderColor(BorderSide.BOTTOM, xColor);
		style.setBorderRight(tipo);
		style.setBorderColor(BorderSide.RIGHT, xColor);
		return style;
	}

	public XSSFCellStyle crearFuente(XSSFWorkbook wb, XSSFCellStyle style, Color color, double size, boolean bold) {
		XSSFColor xColor = new XSSFColor(color, null);
		XSSFFont font = wb.createFont();
		font.setBold(bold);
		font.setFontHeight(size);
		font.setColor(xColor);
		style.setFont(font);
		return style;
	}

	public XSSFCellStyle crearColorFondo(XSSFCellStyle style, Color color) {
		XSSFColor xColor = new XSSFColor(color, null);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(xColor);
		return style;
	}

	public XSSFCellStyle crearTextoAlineado(XSSFCellStyle style, HorizontalAlignment align) {
		style.setAlignment(align);
		return style;
	}
}
