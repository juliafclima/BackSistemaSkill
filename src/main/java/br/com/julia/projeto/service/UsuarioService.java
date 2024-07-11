package br.com.julia.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.julia.projeto.dto.UsuarioDTO;
import br.com.julia.projeto.entity.UsuarioEntity;
import br.com.julia.projeto.exception.InvalidResourceException;
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
		usuarioEntity.setId(null);
		usuarioRepository.save(usuarioEntity);

		emailService.envioEmailCadastro(usuario);
	}

	public UsuarioDTO alterar(UsuarioDTO usuario) {
		if (usuario.getId() == null || usuario.getLogin().isEmpty()) {
			throw new InvalidResourceException("ID do usuário é obrigatório para a alteração.");
		}

		UsuarioEntity existingUser = usuarioRepository.findById(usuario.getId()).orElseThrow(
				() -> new ResourceNotFoundException("Usuário não encontrado para o ID: " + usuario.getId()));

		if (usuario.getLogin() == null || usuario.getLogin().isEmpty()) {
			throw new InvalidResourceException("Login do usuário é obrigatório.");
		}

		if (usuario.getLogin() != null && !usuario.getLogin().isEmpty()
				&& !usuario.getLogin().equals(existingUser.getLogin())) {
			existingUser.setLogin(usuario.getLogin());
		} else if (usuario.getLogin() != null && usuario.getLogin().isEmpty()) {
			throw new InvalidResourceException("Login do usuário não pode estar vazio.");
		} else {
			throw new InvalidResourceException("Login do usuário deve ser diferente do atual.");
		}

		if (usuario.getSenha() != null && !usuario.getSenha().isEmpty()
				&& !usuario.getSenha().equals(existingUser.getSenha())) {
			existingUser.setSenha(passwordEncoder.encode(usuario.getSenha()));
		} else if (usuario.getSenha() != null && usuario.getSenha().isEmpty()) {
			throw new InvalidResourceException("Senha do usuário não pode estar vazia.");
		} else {
			throw new InvalidResourceException("Senha do usuário deve ser diferente da atual.");
		}

		UsuarioEntity updatedUser = usuarioRepository.save(existingUser);

		return new UsuarioDTO(updatedUser);
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
