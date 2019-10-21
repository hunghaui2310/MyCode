package com.shop.spring.myshop.dto;

import com.shop.spring.myshop.constraint.FieldMatch;

import javax.validation.constraints.NotEmpty;

@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
public class PasswordResetDTO {

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    @NotEmpty
    private String token;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
