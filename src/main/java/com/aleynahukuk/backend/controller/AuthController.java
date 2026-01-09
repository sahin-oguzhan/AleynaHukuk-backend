package com.aleynahukuk.backend.controller;

import com.aleynahukuk.backend.dto.LoginRequest;
import com.aleynahukuk.backend.entity.Admin;
import com.aleynahukuk.backend.repository.AdminRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AdminRepository adminRepository;

    public AuthController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<Admin> adminOpt = adminRepository.findByUsername(loginRequest.username());

        if (adminOpt.isPresent() && adminOpt.get().getPassword().equals(loginRequest.password())) {
            return ResponseEntity.ok("Giriş Başarılı");
        }

        return ResponseEntity.status(401).body("Kullanıcı adı veya şifre hatalı");
    }
}
