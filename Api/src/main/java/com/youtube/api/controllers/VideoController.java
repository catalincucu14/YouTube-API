package com.youtube.api.controllers;

import com.youtube.api.models.Video;
import com.youtube.api.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("/api/videos/")
    public ResponseEntity<List<Video>> readAll() {
        return new ResponseEntity<>(videoService.getAll(), HttpStatus.OK);
    }
}
