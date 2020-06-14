package com.wollcorp.gacela.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wollcorp.gacela.dao.UsuarioDao;
import com.wollcorp.gacela.entity.Usuario;

@Service("userDetailsService")
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioDao.findByUsuario(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		
		roles.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
		
		return new User(usuario.getUsuario(), usuario.getPasswd(), roles);
	}
	
	public List<Usuario> listar() {
		return usuarioDao.findAll();
	}
	
	public void guardar(Usuario usuario) {
		usuarioDao.save(usuario);
	}
	
	public void eliminar(Usuario usuario) {
		usuarioDao.delete(usuario);
	}
	
	public Usuario encontrarPorUsername(Usuario usuario) {
		Usuario u = usuarioDao.findByUsuario(usuario.getUsuario());
		u.setPasswd("=)");
		return u;
	}
}
