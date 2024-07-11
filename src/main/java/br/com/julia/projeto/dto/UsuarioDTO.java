package br.com.julia.projeto.dto;

import org.springframework.beans.BeanUtils;

import br.com.julia.projeto.entity.UsuarioEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {

	private Long id;
	private String login;
	private String senha;

	public UsuarioDTO(UsuarioEntity usuario) {
		BeanUtils.copyProperties(usuario, this);
	}
}
