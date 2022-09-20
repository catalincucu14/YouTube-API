package com.youtube.api.controllers;

import com.youtube.api.models.Video;
import com.youtube.api.services.VideoService;
import com.youtube.api.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("/api/videos/")
    public ResponseEntity<Response<List<Video>>> readAll() {
        List<String> errors = new ArrayList<>();

        try {
            // Read the videos
            Response<List<Video>> responseVideos = videoService.getAll();

            return new ResponseEntity<>(responseVideos, HttpStatus.OK);
        } catch (Exception e) {
            errors.add(e.getMessage());

            return new ResponseEntity<>(new Response<>(errors), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/api/videos/")
    public ResponseEntity<Response<Video>> create(@Valid @RequestBody Video video) {
        List<String> errors = new ArrayList<>();

        try {
            // Create the video
            Response<Video> responseVideos = videoService.create(video);

            return new ResponseEntity<>(responseVideos, HttpStatus.OK);
        } catch (Exception e) {
            errors.add(e.getMessage());

            return new ResponseEntity<>(new Response<>(errors), HttpStatus.BAD_REQUEST);
        }
    }
}
