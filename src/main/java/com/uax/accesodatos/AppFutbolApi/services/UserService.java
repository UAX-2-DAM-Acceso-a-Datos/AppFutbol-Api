package com.uax.accesodatos.AppFutbolApi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import com.uax.accesodatos.AppFutbolApi.dto.usuario.UsuarioDTO;
import com.uax.accesodatos.AppFutbolApi.repositories.UserRepository;


<<<<<<< HEAD


=======
>>>>>>> feature/cambiosLogin
@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDetails user=null;

		try {

			//Recupera el usuario de BD (username,password,roles)
			final UsuarioDTO usuarioBD = userRepository.findByUsername(username);
			if(usuarioBD != null) {
			//Formamos el objeto UserDetails para Spring
			user = User.withUsername(username)
					.password(usuarioBD.getPassword())
					.roles(usuarioBD.getRoles())
					.build();
			}
		} catch (EmptyResultDataAccessException e) {
			return null;
		
		}

		return user;
	}

	public boolean registerUserDB(UsuarioDTO usuario) {

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(usuario.getRoles()));

		String encodededPassword = bCryptPasswordEncoder.encode(usuario.getPassword());

		User user = new User(usuario.getUserName(), encodededPassword, authorities);

		jdbcUserDetailsManager.createUser(user);

		return true;
	}

}