package br.com.julia.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.julia.projeto.dto.AuthenticationDTO;
import br.com.julia.projeto.dto.UsuarioDTO;
import br.com.julia.projeto.exception.ResourceNotFoundException;
import br.com.julia.projeto.exception.entity.ErrorResponse;
import br.com.julia.projeto.exception.entity.SuccessResponse;
import br.com.julia.projeto.service.AuthService;
import br.com.julia.projeto.service.UsuarioService;

@RestController
@RequestMapping("/auth")
//@CrossOrigin(origins = "http://localhost:8081")
public class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDto) {
		try {
			return authService.login(authDto);
		} catch (ResourceNotFoundException e) {
			ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
	}

	@PostMapping(value = "/novoUsuario")
	public ResponseEntity<?> inserirNovoUsuario(@RequestBody UsuarioDTO novoUsuario) {
		try {
			usuarioService.inserirNovoUsuario(novoUsuario);

			return ResponseEntity.ok()
					.body(new SuccessResponse("Usuário cadastrado com sucesso!", HttpStatus.OK.value()));

		} catch (Exception e) {
			ErrorResponse errorResponse = new ErrorResponse("Login já está em uso", HttpStatus.CONFLICT.value());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
		}
	}
}