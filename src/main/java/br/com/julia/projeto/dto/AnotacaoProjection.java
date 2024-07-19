package br.com.julia.projeto.dto;

import java.util.Date;

public interface AnotacaoProjection {
	Long getId();
    String getDescricao();
    Date getDataCriacao();
    Long getUsuarioId();
}
