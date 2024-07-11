package br.com.julia.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import br.com.julia.projeto.entity.SkillEntity;
import br.com.julia.projeto.service.SkillService;

@RestController
@RequestMapping(value = "/skill")
@CrossOrigin(origins = "http://localhost:3000")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping
    public List<SkillEntity> listarTodos() {
        return skillService.listarTodos();
    }
    
    @GetMapping("/filtrar")
    public ResponseEntity<List<SkillEntity>> filtrarPorNome(@RequestParam(value = "nome") String nome) {
        List<SkillEntity> habilidadesFiltradas = skillService.filtrarPorNome(nome);
        return ResponseEntity.ok(habilidadesFiltradas);
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
