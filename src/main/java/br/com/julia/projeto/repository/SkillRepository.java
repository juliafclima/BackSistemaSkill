package br.com.julia.projeto.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.julia.projeto.entity.SkillEntity;

public interface SkillRepository extends JpaRepository<SkillEntity, Long> {
	List<SkillEntity> findByNomeContainingIgnoreCase(String nome);

	List<SkillEntity> findAllByOrderByNomeAsc();

	List<SkillEntity> findAllByOrderByNomeDesc();

	Page<SkillEntity> findAll(Pageable pageable);
}
