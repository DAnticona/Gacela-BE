package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.RpoPlan;
import com.wollcorp.gacela.service.RpoPlanService;

@RestController
@RequestMapping("/rpo-plan")
public class RpoPlanRest {
	
	@Autowired
	RpoPlanService rpoPlanService;
	
	@GetMapping
	public ResponseEntity<List<RpoPlan>> listar() {
		List<RpoPlan> planes = rpoPlanService.listar();
		return ResponseEntity.ok(planes);
	}

}
