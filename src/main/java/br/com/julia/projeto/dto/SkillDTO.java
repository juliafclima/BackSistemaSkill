package br.com.julia.projeto.dto;

import org.springframework.beans.BeanUtils;

import br.com.julia.projeto.entity.SkillEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SkillDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private String url;
	
	public SkillDTO(SkillEntity skill) {
		BeanUtils.copyProperties(skill, this);
	}
}
