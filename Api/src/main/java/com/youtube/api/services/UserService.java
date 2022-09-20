package com.youtube.api.services;

import com.youtube.api.models.User;
import com.youtube.api.repositories.UserRepository;
import com.youtube.api.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Response<List<User>> getAll() {
        List<User> users = userRepository.findAll();

        return new Response<>(true, users);
    }

    public Response<User> create(User user) {
        userRepository.save(user);

        return new Response<>(true, user);
    }
}
