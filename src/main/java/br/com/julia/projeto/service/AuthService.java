package br.com.julia.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.julia.projeto.dto.AcessDTO;
import br.com.julia.projeto.dto.AuthenticationDTO;
import br.com.julia.projeto.security.jwt.JwtUtils;

@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtils jwtUtils;

	public AcessDTO login(AuthenticationDTO authDto) {
		try {
			// Cria mecanismo de credencial para o spring
			UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(
					authDto.getUsername(), authDto.getPassword());

			// Prepara mecanismo para autenticacao
			Authentication authentication = authenticationManager.authenticate(userAuth);

			// Busca usuario logado
			UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();

			// Gera o token
			String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

			// Retorne o ID do usuário e o token
			return new AcessDTO(userAuthenticate.getId(), token);

		} catch (BadCredentialsException e) {
			// TODO LOGIN OU SENHA INVALIDO
		}

		return null;
	}
}
