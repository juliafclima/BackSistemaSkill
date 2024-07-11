package br.com.julia.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.julia.projeto.entity.SkillEntity;

public interface SkillRepository extends JpaRepository<SkillEntity, Long> {

}
