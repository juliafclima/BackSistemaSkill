package br.com.julia.projeto.entity;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.julia.projeto.dto.SkillDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SKILL")
public class SkillEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@Column(nullable = false)
	private String level;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private String url;

	public SkillEntity(SkillDTO skill) {
		BeanUtils.copyProperties(skill, this);
	}
	
	public SkillEntity() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkillEntity other = (SkillEntity) obj;
		return Objects.equals(id, other.id);
	}
}
