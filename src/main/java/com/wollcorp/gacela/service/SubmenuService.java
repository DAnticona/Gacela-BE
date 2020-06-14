package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.SubmenuDao;
import com.wollcorp.gacela.entity.Submenu;

@Service
public class SubmenuService {

	@Autowired
	SubmenuDao submenuDao;
	
	public List<Submenu> listar() {
		return submenuDao.findAll();
	}
	
	public void guardar(Submenu submenu) {
		submenuDao.save(submenu);
	}
	
	public void eliminar(Submenu submenu) {
		submenuDao.delete(submenu);
	}
	
//	public Submenu encontrarPorId(Submenu submenu) {
//		return submenuDao.findById(new SubmenuId(submenu.getMenu().getIdMenu(), submenu.getIdSubmenu())).orElse(null);
//	}
}
