package br.com.julia.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.julia.projeto.dto.AnotacaoDTO;
import br.com.julia.projeto.entity.AnotacaoEntity;
import br.com.julia.projeto.service.AnotacaoService;

@RestController
@RequestMapping("/anotacao")
//@CrossOrigin(origins = "http://localhost:8081")
public class AnotacaoController {

	@Autowired
	private AnotacaoService anotacaoService;

	@PostMapping("/{idUsuario}/adicionar")
    public ResponseEntity<AnotacaoEntity> adicionarAnotacao(@PathVariable Long idUsuario, @RequestBody AnotacaoDTO anotacaoDTO) {
        AnotacaoEntity novaAnotacao = anotacaoService.adicionarAnotacao(idUsuario, anotacaoDTO);
        return new ResponseEntity<>(novaAnotacao, HttpStatus.CREATED);
    }

    @GetMapping("/{idUsuario}/listar/{idUsuarioConsulta}")
    public ResponseEntity<List<AnotacaoDTO>> listarAnotacoesPorUsuario(
            @PathVariable Long idUsuario, @PathVariable Long idUsuarioConsulta) {
        List<AnotacaoDTO> anotacoes = anotacaoService.listarAnotacoesPorUsuario(idUsuario, idUsuarioConsulta);
        return ResponseEntity.ok(anotacoes);
    }

    @DeleteMapping("/{idUsuario}/apagar/{idAnotacao}")
    public ResponseEntity<Void> apagarAnotacao(
            @PathVariable Long idUsuario, @PathVariable Long idAnotacao) {
        anotacaoService.apagarAnotacao(idUsuario, idAnotacao);
        return ResponseEntity.noContent().build();
    }
}
