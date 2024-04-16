package br.com.julia.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.julia.projeto.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
