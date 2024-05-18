package com.og.co2data.controllers;

import com.og.co2data.model.db.LoginUser;
import com.og.co2data.repository.LoginUserRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named(value = "registerController")
@SessionScoped
public class RegisterController implements Serializable {
    private String username;
    private String password;
    private String email;
    private String country;
    private boolean registered;
    @Inject
    LoginUserRepository userRepository;

    public RegisterController() {
    }

    public String register() {
        try {
            LoginUser newUser = userRepository.save(new LoginUser(username = username, password = password, email = email, country=country));
            registered = true;
            return "login";
        } catch (RuntimeException e) {
            return "errorregister";
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

