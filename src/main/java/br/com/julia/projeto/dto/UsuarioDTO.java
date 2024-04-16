package br.com.julia.projeto.dto;

import org.springframework.beans.BeanUtils;

import br.com.julia.projeto.entity.UsuarioEntity;

public class UsuarioDTO {

	// entidades da tabela usuarioDTO
	private Long id;
	private String login;
	private String senha;
	
	// constructor
	// converte o usuario para dto
	public UsuarioDTO(UsuarioEntity usuario) {
		BeanUtils.copyProperties(usuario, this);
	}
	
	public UsuarioDTO() {
		
	}
	
	// getter and setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
