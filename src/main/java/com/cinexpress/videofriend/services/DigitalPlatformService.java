package com.cinexpress.videofriend.services;

import java.util.List;

import com.cinexpress.videofriend.models.Movie;

public interface DigitalPlatformService {
    List<Movie> searchMovies(String genre, String director, String title, Integer year , String language , String actors);
    Movie streamingMovie();
    //managementDownload()
    //liveChat()
}
