package br.com.julia.projeto.entity;

import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.julia.projeto.dto.SkillDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SKILL")
@Getter
@Setter
@NoArgsConstructor
public class SkillEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String nome;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private String url;

	@OneToMany
	private List<UsuarioSkillEntity> usuarioSkillEntity;

	public SkillEntity(SkillDTO skill) {
		BeanUtils.copyProperties(skill, this);
	}
}
