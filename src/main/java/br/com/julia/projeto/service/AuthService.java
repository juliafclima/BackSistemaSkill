package br.com.julia.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.julia.projeto.dto.AcessDTO;
import br.com.julia.projeto.dto.AuthenticationDTO;
import br.com.julia.projeto.exception.ResourceNotFoundException;
import br.com.julia.projeto.exception.entity.ErrorResponse;
import br.com.julia.projeto.security.jwt.JwtUtils;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;
    
    public ResponseEntity<?> login(AuthenticationDTO authDto) {
        try {
            UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(
                    authDto.getUsername(), authDto.getPassword());

            Authentication authentication = authenticationManager.authenticate(userAuth);

            UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();

            if (userAuthenticate == null) {
                throw new ResourceNotFoundException("Usuário não encontrado em nossa base de dados");
            }

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            AcessDTO accessDto = new AcessDTO(userAuthenticate.getId(), token);
            return ResponseEntity.ok(accessDto);

        } catch (BadCredentialsException e) {
            ErrorResponse errorResponse = new ErrorResponse("Login ou senha inválidos", HttpStatus.UNAUTHORIZED.value());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
}