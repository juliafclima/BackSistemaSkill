package br.com.julia.projeto.dto;

import org.springframework.beans.BeanUtils;

import br.com.julia.projeto.entity.SkillEntity;

public class SkillDTO {
	
	private Long id;
	private String nome;
	private String level;
	private String descricao;
	private String url;
	
	public SkillDTO(SkillEntity skill) {
		BeanUtils.copyProperties(skill, this);
	}
	
	public SkillDTO() {
		
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
	
	
}
