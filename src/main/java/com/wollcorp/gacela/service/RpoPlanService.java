package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.RpoPlanDao;
import com.wollcorp.gacela.entity.RpoPlan;

@Service
public class RpoPlanService {
	@Autowired
	RpoPlanDao rpoPlanDao;

	public List<RpoPlan> listar() {
		return rpoPlanDao.findAll();
	}

	public RpoPlan guardar(RpoPlan rpo) {
		return rpoPlanDao.save(rpo);
	}

	public void eliminar(RpoPlan rpo) {
		rpoPlanDao.delete(rpo);
	}

	public RpoPlan encontrarPorId(RpoPlan rpo) {
		return rpoPlanDao.findById(rpo.getIdRpo()).orElse(null);
	}
}
