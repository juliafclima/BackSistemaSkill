package br.com.julia.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.julia.projeto.dto.SkillDTO;
import br.com.julia.projeto.service.SkillService;

@RestController
@RequestMapping(value = "/skill")
@CrossOrigin(origins = "http://localhost:3000")
public class SkillController {

	@Autowired
	private SkillService skillService;

	@GetMapping
    public List<SkillDTO> listarTodos(
            @RequestParam(required = false) String nome,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return skillService.listarTodos(nome, pageable);
    }

	@PostMapping
	public void inserir(@RequestBody SkillDTO skill) {
		skillService.inserir(skill);
	}

	@PutMapping
	public SkillDTO alterar(@RequestBody SkillDTO skill) {
		return skillService.alterar(skill);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		skillService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
