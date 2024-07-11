package br.com.julia.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.julia.projeto.dto.SkillDTO;
import br.com.julia.projeto.entity.SkillEntity;
import br.com.julia.projeto.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;

	public List<SkillDTO> listarTodos(String nome, Pageable pageable, String sortBy, String sortDirection) {
	    Page<SkillEntity> skills;

	    if (nome != null && !nome.isEmpty()) {
	        skills = skillRepository.findByNomeContainingIgnoreCase(nome, pageable);
	    } else {
	        skills = skillRepository.findAll(pageable);
	    }

	    return skills.map(SkillDTO::new).getContent();
	}

	public void inserir(SkillDTO skill) {
		SkillEntity skillEntity = new SkillEntity(skill);
		skillRepository.save(skillEntity);
	}

	public SkillDTO alterar(SkillDTO skill) {
		SkillEntity skillEntity = new SkillEntity(skill);
		return new SkillDTO(skillRepository.save(skillEntity));
	}

	public void excluir(Long id) {
		SkillEntity skill = skillRepository.findById(id).get();
		skillRepository.delete(skill);
	}

	public SkillDTO buscarPorId(Long id) {
		return new SkillDTO(skillRepository.findById(id).get());
	}
}
