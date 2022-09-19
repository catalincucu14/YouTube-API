package com.youtube.api.controllers;

import com.youtube.api.models.User;
import com.youtube.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/users/")
    public ResponseEntity<List<User>> readAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
}
