package com.youtube.api.controllers;

import com.youtube.api.models.User;
import com.youtube.api.models.authentication.RegisterRequest;
import com.youtube.api.services.UserService;
import com.youtube.api.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/authentication/register/")
    public ResponseEntity<Response<String>> create(@RequestBody @Valid RegisterRequest registerRequest, Errors modelValidationErrors) {
        List<String> errors = new ArrayList<>();

        if (!modelValidationErrors.hasErrors()) {
            try {
                // Create the user
                Response<User> responseRegistration = userService.create(registerRequest);

                // Check if the creation went through
                if (!responseRegistration.success) {
                    return new ResponseEntity<>(new Response<>(responseRegistration.errors), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(new Response<>("jwt"), HttpStatus.OK);
                }
            } catch (Exception e) {
                errors.add(e.getMessage());

                return new ResponseEntity<>(new Response<>(errors), HttpStatus.BAD_REQUEST);
            }
        } else {
            errors = modelValidationErrors
                    .getAllErrors()
                    .stream()
                    .map((error) -> error.getDefaultMessage())
                    .collect(Collectors.toList());

            return new ResponseEntity<>(new Response<>(errors), HttpStatus.BAD_REQUEST);
        }
    }
}
