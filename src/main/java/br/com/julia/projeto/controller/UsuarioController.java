package br.com.julia.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.julia.projeto.dto.UsuarioDTO;
import br.com.julia.projeto.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<UsuarioDTO> listarTodos() {
		return usuarioService.listarTodos();
	}

	@PostMapping
	public void inserir(@RequestBody UsuarioDTO usuario) {
		usuarioService.inserir(usuario);
	}

	@PutMapping
	public ResponseEntity<UsuarioDTO> alterar(@RequestBody UsuarioDTO usuario) {
		UsuarioDTO usuarioAlterado = usuarioService.alterar(usuario);
		return ResponseEntity.ok(usuarioAlterado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		usuarioService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
