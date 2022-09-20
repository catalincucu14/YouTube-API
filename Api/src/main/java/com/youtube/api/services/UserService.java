package com.youtube.api.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.youtube.api.models.User;
import com.youtube.api.models.authentication.RegisterRequest;
import com.youtube.api.repositories.UserRepository;
import com.youtube.api.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Response<List<User>> getAll() {
        // Read the users
        List<User> users = userRepository.findAll();

        // Remove the password
        users.forEach((user) -> user.setPassword(null));

        return new Response<>(true, users);
    }

    public Response<User> create(RegisterRequest registerRequest) {
        List<String> errors = new ArrayList<>();

        // Create user from the register request
        User user = new User(registerRequest);

        // Check if the mail address is not already used by another admin
        if (userRepository.existsByMail(user.getMail())) {
            errors.add("MAIL already used");
        }

        // Check if any of the above checks have triggered
        if (errors.size() > 0) {
            return new Response<>(errors);
        } else {
            // Hash the password
            user.setPassword(BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray()));

            // Create the user
            userRepository.save(user);

            // Remove the password
            user.setPassword(null);

            return new Response<>(true, user);
        }
    }
}
