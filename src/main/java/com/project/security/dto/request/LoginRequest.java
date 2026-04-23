package com.project.security.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(@NotEmpty(message = "Email é orbigatório.")String email,@NotEmpty(message = "Senha é orbigatório.") String password) {

	
	
}
