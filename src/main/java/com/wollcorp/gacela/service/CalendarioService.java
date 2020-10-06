package com.wollcorp.gacela.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.CalendarioDao;
import com.wollcorp.gacela.entity.Calendario;

@Service
public class CalendarioService {

	@Autowired
	CalendarioDao calendarioDao;

	public List<Calendario> listar() {
		return calendarioDao.findAll();
	}
	
	public List<Calendario> listarPorFechas(LocalDate fechaIni, LocalDate fechaFin) {
		return calendarioDao.findByDates(fechaIni, fechaFin);
	}

	public void guardar(Calendario calendario) {
		calendarioDao.save(calendario);
	}

	public void eliminar(Calendario calendario) {
		calendarioDao.delete(calendario);
	}

	public Calendario encontrarPorId(Calendario calendario) {
		return calendarioDao.findById(calendario.getIdCalendario()).orElse(null);
	}
	
	public Calendario encontrarPorFecha(Calendario calendario) {
		return calendarioDao.findByDate(calendario.getFecha());
	}

}
