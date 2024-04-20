package br.com.julia.projeto.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcessDTO {

	 private Long userId;
	    private String token;

	    public AcessDTO(Long userId, String token) {
	        this.userId = userId;
	        this.token = token;
	    }
}
