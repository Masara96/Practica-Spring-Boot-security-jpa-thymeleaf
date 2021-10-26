package com.practica.springboot.app.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practica.springboot.app.models.dao.IUsuarioDao;
import com.practica.springboot.app.models.entity.Role;
import com.practica.springboot.app.models.entity.Usuario;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private IUsuarioDao usuarioDao;

	private Logger log = LoggerFactory.getLogger(JpaUserDetailsService.class);

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioDao.findByUsername(username);

		if (usuario == null) {
			log.error("ERROR: no exite el usuario -> " + username);
			throw new UsernameNotFoundException("Username " + username + " no xiste en el sistema");
		}

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Role role : usuario.getRoles()) {
			log.info("ROLE : " + role.getAuthority() );
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}

		if (authorities.isEmpty()) {
			log.error("ERROR: no exite el usuario -> " + username + " no tiene roles asignados");
			throw new UsernameNotFoundException("ERROR: no exite el usuario -> " + username + " no tiene roles asignados");
		}

		return new User(username, usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}

}
