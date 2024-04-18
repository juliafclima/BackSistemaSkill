package br.com.julia.projeto.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcessDTO {

	private String token;

	//TODO implementar retornar o usuario e liberacoes (authorities)
	
	public AcessDTO(String token) {
		super();
		this.token = token;
	}
}
