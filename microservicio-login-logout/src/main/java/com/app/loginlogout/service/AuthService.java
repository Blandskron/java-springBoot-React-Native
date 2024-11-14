package com.app.loginlogout.service;

import com.app.loginlogout.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private User loggedInUser;

    public boolean login(User user) {
        // Lógica de autenticación (simplificada)
        if ("admin".equals(user.getUsername()) && "admin1234".equals(user.getPassword())) {
            loggedInUser = user;
            return true;
        }
        return false;
    }

    public boolean logout() {
        if (loggedInUser != null) {
            loggedInUser = null;
            return true;
        }
        return false;
    }

    public boolean isLoggedIn() {
        return loggedInUser != null;
    }
}
