package com.og.co2data.controllers;

import com.og.co2data.SessionUtils;
import com.og.co2data.model.CO2Data;
import com.og.co2data.repository.CO2DataRepository;
import com.og.co2data.repository.LoginUserRepository;
import com.og.co2data.model.db.LoginUser;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;

import java.awt.*;
import java.io.Serializable;

@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {
    private boolean authorized;
    private String username;
    private String password;
    private String country;
    private String lastCountryCO2ByYear;
    private Integer lastCountryCO2Year;
    @Inject
    LoginUserRepository userRepository;
    @Inject
    CO2DataRepository co2DataRepository;

    public LoginController() {
    }

    public String authenticate() {
        try{
            LoginUser u = userRepository.authenticate(new LoginUser(username=username, password=password));
            setAuthorized(u != null);
            if (u != null) {
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("username", username);
                session.setAttribute("authorized", authorized);
                setCountry(u.getCountry());
                getAndSetLastCountryCO2(u.getCountry());
                return "home";
            } else {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Incorrect Username and Passowrd",
                                "Please enter correct username and Password"));
                return "login";
            }
        } catch (RuntimeException e){
            return "error";
        }
    }

    private void getAndSetLastCountryCO2(String country) {
        CO2Data data = co2DataRepository.getLastCountryCO2(country);
        if(data != null) {
            setLastCountryCO2ByYear(data.getCo2());
            setLastCountryCO2Year(data.getYear());
        }

    }

    //logout event, invalidate session
    public String logout() {
        username = null;
        authorized = false;
        country = null;
        lastCountryCO2ByYear = null;
        lastCountryCO2Year = null;
        HttpSession session = SessionUtils.getSession();
        session.setAttribute("username", null);
        session.setAttribute("authorized", false);
        session.invalidate();
        return "login";
    }

    public Integer getLastCountryCO2Year() {
        return lastCountryCO2Year;
    }

    public void setLastCountryCO2Year(Integer lastCountryCO2Year) {
        this.lastCountryCO2Year = lastCountryCO2Year;
    }

    public String getLastCountryCO2ByYear() {
        return lastCountryCO2ByYear;
    }

    public void setLastCountryCO2ByYear(String lastCountryCO2ByYear) {
        this.lastCountryCO2ByYear = lastCountryCO2ByYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

