package com.youtube.api.controllers;

import com.youtube.api.models.User;
import com.youtube.api.models.authentication.RegisterRequest;
import com.youtube.api.services.UserService;
import com.youtube.api.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/users/")
    public ResponseEntity<Response<List<User>>> readAll() {
        List<String> errors = new ArrayList<>();

        try {
            // Read the users
            Response<List<User>> responseVideos = userService.getAll();

            return new ResponseEntity<>(responseVideos, HttpStatus.OK);
        } catch (Exception e) {
            errors.add(e.getMessage());

            return new ResponseEntity<>(new Response<>(errors), HttpStatus.BAD_REQUEST);
        }
    }
}
