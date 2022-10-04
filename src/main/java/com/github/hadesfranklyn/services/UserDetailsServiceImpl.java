package com.github.hadesfranklyn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.github.hadesfranklyn.domain.Cliente;
import com.github.hadesfranklyn.repositories.ClienteRepository;
import com.github.hadesfranklyn.security.UserSS;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClienteRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente cliente = repository.findByEmail(email);

		if (cliente == null) {
			throw new UsernameNotFoundException(email);
		}

		return new UserSS(cliente.getId(), cliente.getEmail(), cliente.getSenha(), cliente.getPerfis());
	}

}
