package com.guillemarti.books.controller;

import com.guillemarti.books.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    LoginService loginService;

    @GetMapping(value="/")
    public String showWelcomePage(ModelMap model) {
        model.put("name", getLoggedInUserName(model));
        return "mainWindow";
    }

    @PostMapping(value="/login")
    public String showWelcomePage(ModelMap model, @RequestParam String name, String password) {
        boolean isValidUser = loginService.validateUser(name, password);

        if(!isValidUser) {
            model.put("errorMessage", "Invalid credentials");
            return "login";
        }

        model.put("name", name);
        model.put("password", password);
        return "mainWindow";
    }

    private String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();

        return principal.toString();
    }
}
