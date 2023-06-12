package com.project.backend.security.service;

import com.project.backend.security.payload.LoginDto;
import com.project.backend.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
