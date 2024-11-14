package com.app.loginlogout.controller;

import com.app.loginlogout.model.User;
import com.app.loginlogout.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        if (authService.login(user)) {
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        if (authService.logout()) {
            return ResponseEntity.ok("Logout exitoso");
        } else {
            return ResponseEntity.status(401).body("No hay un usuario autenticado");
        }
    }
}
