package com.guillemarti.books.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public boolean validateUser(String userId, String password) {
        return userId.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin");
    }
}
