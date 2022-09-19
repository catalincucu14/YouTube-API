package com.youtube.api.models;


import com.youtube.api.utils.Regex;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "video_id")
    private Integer videoId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Pattern(regexp = Regex.Title, message = "TITLE Invalid")
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

    public Video() {
    }

    public Video(Integer videoId, User user, String title, String description, Integer views, Date uploadDate) {
        this.videoId = videoId;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
