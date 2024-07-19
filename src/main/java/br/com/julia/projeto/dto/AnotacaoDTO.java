package br.com.julia.projeto.dto;

import java.util.Date;

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
	private Long usuarioId;

	public AnotacaoDTO(AnotacaoEntity anotacao) {
		this.id = anotacao.getId();
        this.descricao = anotacao.getDescricao();
        this.dataCriacao = anotacao.getDataCriacao();
        this.usuarioId = anotacao.getUsuario().getId();
	}
}
