package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Dto.AuthRequestDto;
import com.example.StudentManagement.Dto.AuthResponseDto;
import com.example.StudentManagement.Services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
