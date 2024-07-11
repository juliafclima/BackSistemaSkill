package br.com.julia.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.julia.projeto.dto.UsuarioDTO;
import br.com.julia.projeto.entity.UsuarioEntity;
import br.com.julia.projeto.entity.enuns.TipoSituacaoUsuario;
import br.com.julia.projeto.exception.ResourceNotFoundException;
import br.com.julia.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private EmailService emailService;
	
	private static final String MENSAGEM_EXCEPTION = "Usuário não encontrado para o ID: ";

	public List<UsuarioDTO> listarTodos() {
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDTO::new).toList();
	}

	public void inserir(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuarioRepository.save(usuarioEntity);
	}

	public void inserirNovoUsuario(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuarioEntity.setSituacao(TipoSituacaoUsuario.ATIVO);
		usuarioEntity.setId(null);
		usuarioRepository.save(usuarioEntity);

		emailService.envioEmailCadastro(usuario);
	}

	public UsuarioDTO alterar(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
		return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
	}

	public void excluir(Long id) {
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MENSAGEM_EXCEPTION + id));
        usuarioRepository.delete(usuario);
    }

    public UsuarioDTO buscarPorId(Long id) {
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MENSAGEM_EXCEPTION + id));
        return new UsuarioDTO(usuario);
    }
}
