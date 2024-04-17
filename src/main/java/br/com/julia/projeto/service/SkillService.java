package br.com.julia.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julia.projeto.dto.SkillDTO;
import br.com.julia.projeto.entity.SkillEntity;
import br.com.julia.projeto.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;
	
	public List<SkillDTO> ListarTodos() {
		List<SkillEntity> skills = skillRepository.findAll();
		return skills.stream().map(SkillDTO::new).toList();
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
