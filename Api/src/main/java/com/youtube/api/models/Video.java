package com.youtube.api.models;


import com.youtube.api.utils.Regex;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id")
    private Integer videoId;

    @Pattern(regexp = Regex.Title, message = "TITLE invalid")
    @NotBlank(message = "TITLE required")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "DESCRIPTION required")
    @Column(name = "description")
    private String description;

    @NotBlank(message = "VIEWS required")
    @Column(name = "views")
    private Integer views = 0;

    @NotBlank(message = "UPLOAD DATE required")
    @Column(name = "upload_date")
    private Date uploadDate = new Date();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "video")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "video")
    private Set<Like> likes;

    public Video() {
    }

    public Video(Integer videoId, String title, String description, Integer views, Date uploadDate) {
        this.videoId = videoId;
        this.title = title;
        this.description = description;
        this.views = views;
        this.uploadDate = uploadDate;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
