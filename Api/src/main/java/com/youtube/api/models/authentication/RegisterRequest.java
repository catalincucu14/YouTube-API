package com.youtube.api.models.authentication;

import com.youtube.api.utils.Regex;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class RegisterRequest {
    private Integer userId;

    @Pattern(regexp = Regex.Name, message = "FIRST NAME invalid")
    @Size(min = 2, max = 25, message = "FIRST NAME must have between 2 and 25 characters")
    @NotBlank(message = "FIRST NAME required")
    private String firstName;

    @Pattern(regexp = Regex.Name, message = "LAST NAME invalid")
    @Size(min = 2, max = 25, message = "LAST NAME must have between 2 and 25 characters")
    @NotBlank(message = "LAST NAME required")
    private String lastName;

    @Pattern(regexp = Regex.Mail, message = "MAIL invalid")
    @Size(min = 10, max = 50, message = "MAIL must have between 10 and 50 characters")
    @NotBlank(message = "MAIL required")
    private String mail;

    @Pattern(regexp = Regex.Username, message = "USERNAME invalid")
    @Size(min = 5, max = 25, message = "USERNAME must have between 5 and 25 characters")
    @NotBlank(message = "USERNAME required")
    private String username;

    @Pattern(regexp = Regex.Password, message = "PASSWORD must have at least one uppercase and lowercase")
    @Size(min = 8, max = 40, message = "PASSWORD must have between 8 and 40 characters")
    @NotBlank(message = "PASSWORD required")
    private String password;

    public RegisterRequest() {
    }

    public RegisterRequest(Integer userId, String firstName, String lastName, String mail, String username, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.username = username;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
