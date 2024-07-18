package br.com.julia.projeto.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import br.com.julia.projeto.entity.AnotacaoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AnotacaoDTO {

	private Long id;
	private String descricao;
	private Date dataCriacao;
	
	public AnotacaoDTO(AnotacaoEntity anotacao) {
		BeanUtils.copyProperties(anotacao, this);
	}
}
