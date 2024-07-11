package br.com.julia.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julia.projeto.dto.UsuarioSkillDTO;
import br.com.julia.projeto.entity.UsuarioSkillEntity;
import br.com.julia.projeto.repository.UsuarioSkillRepository;

@Service
public class UsuarioSkillService {

	@Autowired
	private UsuarioSkillRepository usuarioSkillRepository;

	public List<UsuarioSkillDTO> ListarTodos() {
		List<UsuarioSkillEntity> usuariosSkills = usuarioSkillRepository.findAll();
		return usuariosSkills.stream().map(UsuarioSkillDTO::new).toList();
	}

	public void inserir(UsuarioSkillDTO usuarioSkill) {
		UsuarioSkillEntity usuarioSkillEntity = new UsuarioSkillEntity(usuarioSkill);
		usuarioSkillRepository.save(usuarioSkillEntity);
	}

	public UsuarioSkillDTO atualizarNivel(Long id, String novoNivel) {
		UsuarioSkillEntity usuarioSkill = usuarioSkillRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Habilidade de usuário não encontrada com o ID: " + id));
		usuarioSkill.setLevel(novoNivel);
		return new UsuarioSkillDTO(usuarioSkillRepository.save(usuarioSkill));
	}

	public void excluir(Long id) {
		UsuarioSkillEntity usuarioSkill = usuarioSkillRepository.findById(id).get();
		usuarioSkillRepository.delete(usuarioSkill);
	}

	public UsuarioSkillDTO buscarPorId(Long id) {
		return new UsuarioSkillDTO(usuarioSkillRepository.findById(id).get());
	}
}
