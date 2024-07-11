package br.com.julia.projeto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.julia.projeto.entity.SkillEntity;

public interface SkillRepository extends JpaRepository<SkillEntity, Long> {
	Page<SkillEntity> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
    Page<SkillEntity> findAll(Pageable pageable);
}
