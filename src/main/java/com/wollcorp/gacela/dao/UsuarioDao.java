package com.wollcorp.gacela.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wollcorp.gacela.entity.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

	public Usuario findByUsuario(String username);
}
