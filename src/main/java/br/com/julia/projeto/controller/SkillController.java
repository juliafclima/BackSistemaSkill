package br.com.julia.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import br.com.julia.projeto.entity.SkillEntity;
import br.com.julia.projeto.service.SkillService;

@RestController
@RequestMapping(value = "/skill")
//@CrossOrigin(origins = "http://localhost:8081")
public class SkillController {

	@Autowired
	private SkillService skillService;

	@GetMapping
    public ResponseEntity<Page<SkillEntity>> listarTodos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortField,
            @RequestParam(defaultValue = "asc") String sortOrder) {

        Pageable pageable;

        if (sortField != null && !sortField.isEmpty()) {
            pageable = PageRequest.of(page, size, Sort.by(sortOrder.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
        } else {
            pageable = PageRequest.of(page, size);
        }

        Page<SkillEntity> habilidadesPaginadas = skillService.listarTodos(pageable);

        return ResponseEntity.ok(habilidadesPaginadas);
    }

	@GetMapping("/filtrar")
	public ResponseEntity<List<SkillEntity>> filtrarPorNome(@RequestParam(value = "nome") String nome) {
		List<SkillEntity> habilidadesFiltradas = skillService.filtrarPorNome(nome);
		return ResponseEntity.ok(habilidadesFiltradas);
	}

	@GetMapping("/ordenar")
	public ResponseEntity<List<SkillEntity>> ordernar(@RequestParam(value = "forma") String forma) {
		List<SkillEntity> habilidadesOrdenadas;

		if ("asc".equalsIgnoreCase(forma)) {
			habilidadesOrdenadas = skillService.listarTodosOrdenadoPorNomeAsc();
		} else if ("desc".equalsIgnoreCase(forma)) {
			habilidadesOrdenadas = skillService.listarTodosOrdenadoPorNomeDesc();
		} else {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(habilidadesOrdenadas);
	}

	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody SkillDTO skill) {
		skillService.inserir(skill);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping
	public ResponseEntity<SkillDTO> alterar(@RequestBody SkillDTO skill) {
		SkillDTO updatedSkill = skillService.alterar(skill);
		return ResponseEntity.ok(updatedSkill);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		skillService.excluir(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<SkillDTO> buscarPorId(@PathVariable("id") Long id) {
		SkillDTO skill = skillService.buscarPorId(id);
		return ResponseEntity.ok(skill);
	}
}
