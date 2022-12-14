package com.youtube.api.models;

import com.youtube.api.models.authentication.RegisterRequest;
import com.youtube.api.utils.Regex;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Pattern(regexp = Regex.Name, message = "FIRST NAME invalid")
    @Size(min = 2, max = 25, message = "FIRST NAME must have between 2 and 25 characters")
    @NotBlank(message = "FIRST NAME required")
    @Column(name = "first_name")
    private String firstName;

    @Pattern(regexp = Regex.Name, message = "LAST NAME invalid")
    @Size(min = 2, max = 25, message = "LAST NAME must have between 2 and 25 characters")
    @NotBlank(message = "LAST NAME required")
    @Column(name = "last_name")
    private String lastName;

    @Pattern(regexp = Regex.Mail, message = "MAIL invalid")
    @Size(min = 10, max = 50, message = "MAIL must have between 10 and 50 characters")
    @NotBlank(message = "MAIL required")
    @Column(name = "mail")
    private String mail;

    @Pattern(regexp = Regex.Username, message = "USERNAME invalid")
    @Size(min = 5, max = 25, message = "USERNAME must have between 5 and 25 characters")
    @NotBlank(message = "USERNAME required")
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Video> videos;

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "user")
    private Set<Like> likes;

    public User() {
    }

    public User(Integer userId, String firstName, String lastName, String mail, String username, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.username = username;
        this.password = password;
    }

    public User(RegisterRequest registerRequest)
    {
        this.userId = registerRequest.getUserId();
        this.firstName = registerRequest.getFirstName();
        this.lastName = registerRequest.getLastName();
        this.mail = registerRequest.getMail();
        this.username = registerRequest.getUsername();
        this.password = registerRequest.getPassword();
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

    public Set<Video> getVideos() {
        return videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }
}
