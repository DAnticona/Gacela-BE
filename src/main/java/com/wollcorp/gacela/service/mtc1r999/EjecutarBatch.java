package com.wollcorp.gacela.service.mtc1r999;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

import com.wollcorp.gacela.entity.Mtc1r999Detalle;

@Service
public class EjecutarBatch {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * 
	 * @param detalle
	 */
	public void insertarDetalle(Mtc1r999Detalle detalle) {

		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_insert_mtc1r999_detalle");

		query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(8, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(9, Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(12, LocalDate.class, ParameterMode.IN);

		// Pass the parameter values
		query.setParameter(1, detalle.getMtc1r999().getIdMtc1r999());
		query.setParameter(2, detalle.getMtc1r999DetalleId().getItem());
		query.setParameter(3, detalle.getDepot());
		query.setParameter(4, detalle.getNave());
		query.setParameter(5, detalle.getViaje());
		query.setParameter(6, detalle.getVslVoyS());
		query.setParameter(7, detalle.getBookingNo());
		query.setParameter(8, detalle.getQty());
		query.setParameter(9, detalle.getPick());
		query.setParameter(10, detalle.getMode());
		query.setParameter(11, detalle.getTpe());
		query.setParameter(12, detalle.getCutOff());

		query.execute();
	}

}
