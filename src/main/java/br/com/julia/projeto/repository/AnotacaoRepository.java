package br.com.julia.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julia.projeto.dto.AnotacaoProjection;
import br.com.julia.projeto.entity.AnotacaoEntity;

@Repository
public interface AnotacaoRepository extends JpaRepository<AnotacaoEntity, Long> {
    List<AnotacaoProjection> findByUsuarioId(Long usuarioId);
}