package br.com.julia.projeto.dto;

import org.springframework.beans.BeanUtils;

import br.com.julia.projeto.entity.UsuarioSkillEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioSkillDTO {

	private Long id;
	private String level;
	private UsuarioDTO usuario;
	private SkillDTO skill;
	
	public UsuarioSkillDTO(UsuarioSkillEntity usuarioSkill) {
		BeanUtils.copyProperties(usuarioSkill, this);
		
		if (usuarioSkill != null && usuarioSkill.getUsuario() != null) {
			this.usuario = new UsuarioDTO(usuarioSkill.getUsuario());
		}
		
		if (usuarioSkill != null && usuarioSkill.getUsuario() != null) {
			this.skill = new SkillDTO(usuarioSkill.getSkill());
		}
	}
}
