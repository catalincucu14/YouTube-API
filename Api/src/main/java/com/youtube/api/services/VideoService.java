package com.youtube.api.services;

import com.youtube.api.models.Video;
import com.youtube.api.repositories.VideoRepository;
import com.youtube.api.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;


    public Response<List<Video>> getAll() {
        // Read the videos
        List<Video> videos = videoRepository.findAll();

        return new Response<>(true, videos);
    }

    public Response<Video> create(Video video) {
        // Create the video
        videoRepository.save(video);

        return new Response<>(true, video);
    }
}
