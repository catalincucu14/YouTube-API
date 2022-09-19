package com.youtube.api.services;

import com.youtube.api.models.Video;
import com.youtube.api.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAll() {
        return videoRepository.findAll();
    }
}
