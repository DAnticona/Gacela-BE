package com.wollcorp.gacela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.MenuDao;
import com.wollcorp.gacela.entity.Menu;

@Service
public class MenuService {

	@Autowired
	MenuDao menuDao;

	public List<Menu> listar() {
		return menuDao.findAll();
	}

	public void guardar(Menu menu) {
		menuDao.save(menu);
	}

	public void eliminar(Menu menu) {
		menuDao.delete(menu);
	}

	public Menu encontrarPorId(Menu menu) {
		return menuDao.findById(menu.getIdMenu()).orElse(null);
	}

}
