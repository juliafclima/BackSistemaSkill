package br.com.julia.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.julia.projeto.entity.UsuarioSkillEntity;

public interface UsuarioSkillRepository extends JpaRepository<UsuarioSkillEntity, Long> {
	
	 @Query("SELECT us FROM UsuarioSkillEntity us WHERE LOWER(us.skill.nome) LIKE LOWER(concat('%', :nomeSkill, '%'))")
	    List<UsuarioSkillEntity> findBySkillNomeIgnoreCaseContaining(@Param("nomeSkill") String nomeSkill);
}
