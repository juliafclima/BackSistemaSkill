package br.com.julia.projeto.entity;

import org.springframework.beans.BeanUtils;

import br.com.julia.projeto.dto.UsuarioSkillDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tab_usuario_skill")
@Getter
@Setter
@NoArgsConstructor
public class UsuarioSkillEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, name = "level_usuario_skill")
	private String level;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private UsuarioEntity usuario;

	@ManyToOne
	@JoinColumn(name = "id_skill")
	private SkillEntity skill;

	public UsuarioSkillEntity(UsuarioSkillDTO usuarioSkill) {
		BeanUtils.copyProperties(usuarioSkill, this);

		if (usuarioSkill != null && usuarioSkill.getUsuario() != null) {
			this.usuario = new UsuarioEntity(usuarioSkill.getUsuario());
		}

		if (usuarioSkill != null && usuarioSkill.getUsuario() != null) {
			this.skill = new SkillEntity(usuarioSkill.getSkill());
		}
	}
}
