package com.wollcorp.gacela.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wollcorp.gacela.entity.Mtc1r999;
import com.wollcorp.gacela.service.Mtc1r999Service;

@RestController
@RequestMapping("/mtc1r999")
public class Mtc1r999Rest {

	@Autowired
	Mtc1r999Service mtc1r999Service;
	
	@GetMapping
	public ResponseEntity<List<Mtc1r999>> listar() {
		List<Mtc1r999> files = mtc1r999Service.listar();
		return ResponseEntity.ok(files);
	}
}
