package com.cinexpress.videofriend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.repository.DigitalPlatformRepository;
import com.cinexpress.videofriend.services.DigitalPlatformService;
import com.cinexpress.videofriend.services.MovieService;

@Service
public class DigitalPlatformServiceImpl implements DigitalPlatformService{

    @Autowired
    DigitalPlatformRepository digitalPlatformRepository;

    @Autowired
    MovieService movieService;

    @Override
    public List<Movie> searchMovies(String genre, String director, String title, Integer year, String language, String actors) {
       List<Movie> movies = movieService.searchMovies(genre, director, title, year, language, actors);
       return movies;
    }

    @Override
    public Movie streamingMovie() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'streamingMovie'");
    }
    
}
