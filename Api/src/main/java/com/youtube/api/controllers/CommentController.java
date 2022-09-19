package com.youtube.api.controllers;

import com.youtube.api.models.Comment;
import com.youtube.api.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/api/comments/")
    public ResponseEntity<List<Comment>> ReadAll() {
        return new ResponseEntity<>(commentService.getAll(), HttpStatus.OK);
    }
}
