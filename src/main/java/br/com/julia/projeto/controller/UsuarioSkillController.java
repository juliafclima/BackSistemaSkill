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

import br.com.julia.projeto.dto.UsuarioSkillDTO;
import br.com.julia.projeto.service.UsuarioSkillService;

@RestController 
@RequestMapping(value = "/usuario-skill")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioSkillController {
	
	@Autowired
	private UsuarioSkillService usuarioSkillService;

	@GetMapping
	public List<UsuarioSkillDTO> listarTodos() {
		return usuarioSkillService.ListarTodos();
	}
	
	@PostMapping
	public void inserir(@RequestBody UsuarioSkillDTO usuarioSkill) {
		usuarioSkillService.inserir(usuarioSkill);
	}
	
	@PutMapping
	public UsuarioSkillDTO alterar(@RequestBody UsuarioSkillDTO usuarioSkill) {
		return usuarioSkillService.alterar(usuarioSkill);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		usuarioSkillService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
