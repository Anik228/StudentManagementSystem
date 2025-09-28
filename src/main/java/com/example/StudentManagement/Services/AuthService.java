package com.example.StudentManagement.Services;


import com.example.StudentManagement.Dto.AuthRequestDto;
import com.example.StudentManagement.Dto.AuthResponseDto;
import com.example.StudentManagement.Utils.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final RoleBasedUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthService(RoleBasedUserDetailsService userDetailsService,
                       JwtUtil jwtUtil,
                       PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponseDto login(AuthRequestDto request) {
        var userDetails = userDetailsService.loadUser(request);

        if (!passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(userDetails.getUsername(), request.getRole());
        return new AuthResponseDto(token, request.getRole());
    }
}
