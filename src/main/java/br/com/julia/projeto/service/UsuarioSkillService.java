package br.com.julia.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.julia.projeto.dto.UsuarioSkillDTO;
import br.com.julia.projeto.entity.UsuarioSkillEntity;
import br.com.julia.projeto.exception.ResourceNotFoundException;
import br.com.julia.projeto.repository.UsuarioSkillRepository;

@Service
public class UsuarioSkillService {

	@Autowired
	private UsuarioSkillRepository usuarioSkillRepository;

	private static final String MENSAGEM_EXCEPTION = "Habilidade de usuário não encontrada com o ID: ";

	public List<UsuarioSkillDTO> listarTodosOrdenadoPorNome(String ordem) {
	    Sort sort = ordem.equalsIgnoreCase("asc") ? Sort.by(Sort.Direction.ASC, "skill.nome")
	            : Sort.by(Sort.Direction.DESC, "skill.nome");
	    List<UsuarioSkillEntity> usuariosSkills = usuarioSkillRepository.findAll(sort);
	    return usuariosSkills.stream().map(UsuarioSkillDTO::new).toList();
	}

	public Page<UsuarioSkillDTO> listarPaginado(Pageable pageable) {
		Page<UsuarioSkillEntity> page = usuarioSkillRepository.findAllWithPagination(pageable);
		return page.map(UsuarioSkillDTO::new);
	}

	public Page<UsuarioSkillDTO> filtrarPorNomeSkillPaginado(String nomeSkill, Pageable pageable) {
		Page<UsuarioSkillEntity> page = usuarioSkillRepository
				.findBySkillNomeIgnoreCaseContainingWithPagination(nomeSkill, pageable);
		return page.map(UsuarioSkillDTO::new);
	}

	public Page<UsuarioSkillDTO> listarPaginadoOrdenadoPorNome(String ordem, Pageable pageable) {
        Page<UsuarioSkillEntity> page;
        if (ordem.equalsIgnoreCase("asc")) {
            page = usuarioSkillRepository.findAllByOrderBySkillNomeAsc(pageable);
        } else {
            page = usuarioSkillRepository.findAllByOrderBySkillNomeDesc(pageable);
        }
        return page.map(UsuarioSkillDTO::new);
    }

	public void inserir(UsuarioSkillDTO usuarioSkill) {
		if (usuarioSkillRepository.existsByUsuarioIdAndSkillId(usuarioSkill.getUsuario().getId(), usuarioSkill.getSkill().getId())) {
            throw new RuntimeException("Este usuário já possui esta skill.");
        }
		
		UsuarioSkillEntity usuarioSkillEntity = new UsuarioSkillEntity(usuarioSkill);
		usuarioSkillRepository.save(usuarioSkillEntity);
	}

	public UsuarioSkillDTO atualizarNivel(Long id, String novoNivel) {
		UsuarioSkillEntity usuarioSkill = usuarioSkillRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MENSAGEM_EXCEPTION + id));
		usuarioSkill.setLevel(novoNivel);
		return new UsuarioSkillDTO(usuarioSkillRepository.save(usuarioSkill));
	}

	public void excluir(Long id) {
		UsuarioSkillEntity usuarioSkill = usuarioSkillRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MENSAGEM_EXCEPTION + id));
		usuarioSkillRepository.delete(usuarioSkill);
	}

	public UsuarioSkillDTO buscarPorId(Long id) {
		UsuarioSkillEntity usuarioSkill = usuarioSkillRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MENSAGEM_EXCEPTION + id));
		return new UsuarioSkillDTO(usuarioSkill);
	}
}
