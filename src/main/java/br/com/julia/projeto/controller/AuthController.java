package br.com.julia.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.julia.projeto.dto.AcessDTO;
import br.com.julia.projeto.dto.AuthenticationDTO;
import br.com.julia.projeto.dto.UsuarioDTO;
import br.com.julia.projeto.service.AuthService;
import br.com.julia.projeto.service.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDto) {
		AcessDTO accessDto = authService.login(authDto);
		if (accessDto != null) {
			return ResponseEntity.ok(accessDto);
		} else {
			return ResponseEntity.badRequest().build(); // ou qualquer tratamento de erro desejado
		}
	}

	@PostMapping(value = "/novoUsuario")
	public void inserirNovoUsuario(@RequestBody UsuarioDTO novoUsuario) {
		usuarioService.inserirNovoUsuario(novoUsuario);
	}
}
