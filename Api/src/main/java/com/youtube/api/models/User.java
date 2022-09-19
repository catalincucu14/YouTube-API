package com.youtube.api.models;

import com.youtube.api.utils.Regex;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @Pattern(regexp = Regex.Mail, message = "MAIL Invalid")
    @NotBlank(message = "MAIL required")
    @Column(name = "mail")
    private String mail;

    @Pattern(regexp = Regex.Username, message = "USERNAME Invalid")
    @NotBlank(message = "USERNAME required")
    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "user")
    private List<Video> videos;

    public User() {
    }

    public User(Integer userId, String mail, String username, List<Video> videos) {
        this.userId = userId;
        this.mail = mail;
        this.username = username;
        this.videos = videos;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
