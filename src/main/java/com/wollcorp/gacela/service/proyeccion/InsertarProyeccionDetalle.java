package com.wollcorp.gacela.service.proyeccion;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

import com.wollcorp.gacela.entity.ProyeccionDetalle;

@Service
public class InsertarProyeccionDetalle {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insertarDetalle(ProyeccionDetalle detalle) {

		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_insert_proyeccion_detalle");

		query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(6, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(7, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(8, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(9, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(10, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(11, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(12, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(13, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(14, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(15, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(16, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(17, LocalDate.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(18, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(19, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(20, LocalDateTime.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(21, LocalDateTime.class, ParameterMode.IN);

		// Pass the parameter values
		query.setParameter(1, detalle.getProyeccion().getIdProyeccion());
		query.setParameter(2, detalle.getProyeccionDetalleId().getItem());
		query.setParameter(3, detalle.getNave().getIdNave());
		query.setParameter(4, detalle.getViaje());
		query.setParameter(5, detalle.getCa2sdNoFe());
		query.setParameter(6, detalle.getCa2sdNoFePick());
		query.setParameter(7, detalle.getCa2sdFe());
		query.setParameter(8, detalle.getCa2sdFePick());
		query.setParameter(9, detalle.getCa4sdNoFe());
		query.setParameter(10, detalle.getCa4sdNoFePick());
		query.setParameter(11, detalle.getCa4sdFe());
		query.setParameter(12, detalle.getCa4sdFePick());
		query.setParameter(13, detalle.getCa4shNoFe());
		query.setParameter(14, detalle.getCa4shNoFePick());
		query.setParameter(15, detalle.getCa4shFe());
		query.setParameter(16, detalle.getCa4shFePick());
		query.setParameter(17, detalle.getEta());
		query.setParameter(18, detalle.getUsCrea());
		query.setParameter(19, detalle.getUsModi());
		query.setParameter(20, detalle.getFeCrea());
		query.setParameter(21, detalle.getFeModi());

		query.execute();
	}

}
