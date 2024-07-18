package br.com.julia.projeto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.julia.projeto.dto.AnotacaoDTO;
import br.com.julia.projeto.dto.AnotacaoProjection;
import br.com.julia.projeto.entity.AnotacaoEntity;
import br.com.julia.projeto.entity.UsuarioEntity;
import br.com.julia.projeto.repository.AnotacaoRepository;
import br.com.julia.projeto.repository.UsuarioRepository;

@Service
public class AnotacaoService {

	@Autowired
	private AnotacaoRepository anotacaoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public AnotacaoEntity adicionarAnotacao(Long idUsuario, AnotacaoDTO anotacaoDTO) {
		UsuarioEntity usuario = usuarioRepository.findById(idUsuario)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + idUsuario));

		AnotacaoEntity novaAnotacao = new AnotacaoEntity(anotacaoDTO);
		novaAnotacao.setUsuario(usuario);
		return anotacaoRepository.save(novaAnotacao);
	}

	@Transactional(readOnly = true)
	public List<AnotacaoDTO> listarAnotacoesPorUsuario(Long idUsuarioAutenticado, Long idUsuarioConsulta) {
		if (!idUsuarioAutenticado.equals(idUsuarioConsulta)) {
			throw new RuntimeException("Usuário não tem permissão para acessar as anotações deste usuário.");
		}

		List<AnotacaoProjection> anotacoes = anotacaoRepository.findByUsuarioId(idUsuarioConsulta);
		return anotacoes.stream().map(this::mapProjectionToDTO).collect(Collectors.toList());
	}

	@Transactional
	public void apagarAnotacao(Long idUsuarioAutenticado, Long idAnotacao) {
		AnotacaoEntity anotacao = anotacaoRepository.findById(idAnotacao)
				.orElseThrow(() -> new RuntimeException("Anotação não encontrada com ID: " + idAnotacao));

		if (!idUsuarioAutenticado.equals(anotacao.getUsuario().getId())) {
			throw new RuntimeException("Usuário não tem permissão para apagar esta anotação.");
		}

		anotacaoRepository.delete(anotacao);
	}

	private AnotacaoDTO mapProjectionToDTO(AnotacaoProjection projection) {
		AnotacaoDTO dto = new AnotacaoDTO();
		dto.setDescricao(projection.getDescricao());
		dto.setDataCriacao(projection.getDataCriacao());
		return dto;
	}
}
