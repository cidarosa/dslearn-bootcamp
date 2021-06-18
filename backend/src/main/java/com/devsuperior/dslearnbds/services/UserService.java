package com.devsuperior.dslearnbds.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	// para Log
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	/*
	 * @Autowired private BCryptPasswordEncoder passwordEncoder;
	 */
	@Autowired
	private UserRepository repository;

	/*
	 * @Autowired private RoleRepository roleRepository;
	 */

	// implementando o método da UserDetailsService
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// busca o email - ver no repository - já tem o método para buscar email
		// username - é o email
		User user = repository.findByEmail(username);

		if (user == null) {
			logger.error("User not found: " + username);
			throw new UsernameNotFoundException("E-mail not found");
		}

		logger.info("User found: " + username);
		return user;
	}

}
