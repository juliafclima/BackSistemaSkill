package br.com.julia.projeto.entity;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import br.com.julia.projeto.dto.AnotacaoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "Tab_Anotacao")
@Getter
@Setter
@NoArgsConstructor
public class AnotacaoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, name = "descricao_anotacao")
	private String descricao;

	@Column(nullable = false, name = "data_anotacao")
	private Date dataCriacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", nullable = false)
	//@JsonIgnoreProperties("anotacoes")
	private UsuarioEntity usuario;

	public AnotacaoEntity(AnotacaoDTO anotacao) {
		BeanUtils.copyProperties(anotacao, this);
	}
}
