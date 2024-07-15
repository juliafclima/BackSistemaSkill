package br.com.julia.projeto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<UsuarioSkillDTO> ListarTodos() {
		List<UsuarioSkillEntity> usuariosSkills = usuarioSkillRepository.findAll();
		return usuariosSkills.stream().map(UsuarioSkillDTO::new).toList();
	}

	public List<UsuarioSkillDTO> listarTodosOrdenadoPorNome(String ordem) {
		Sort sort = ordem.equalsIgnoreCase("asc") ? Sort.by(Sort.Direction.ASC, "skill.nome")
				: Sort.by(Sort.Direction.DESC, "skill.nome");
		List<UsuarioSkillEntity> usuariosSkills = usuarioSkillRepository.findAll(sort);
		return usuariosSkills.stream().map(UsuarioSkillDTO::new).toList();
	}
	
	public List<UsuarioSkillDTO> filtrarPorNomeSkill(String nomeSkill) {
        List<UsuarioSkillEntity> usuarioSkills = usuarioSkillRepository.findBySkillNomeIgnoreCaseContaining(nomeSkill);
        return usuarioSkills.stream()
                .map(UsuarioSkillDTO::new) 
                .collect(Collectors.toList());
    }


	public void inserir(UsuarioSkillDTO usuarioSkill) {
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
