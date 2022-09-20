package com.youtube.api.models.authentication;

import com.youtube.api.utils.Regex;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class LoginRequest {
    @Pattern(regexp = Regex.Mail, message = "MAIL invalid")
    @NotBlank(message = "MAIL required")
    private String mail;


    @Pattern(regexp = Regex.Password, message = "PASSWORD invalid")
    @NotBlank(message = "PASSWORD required")
    private String password;
}
