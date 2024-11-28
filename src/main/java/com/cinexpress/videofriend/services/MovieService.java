package com.cinexpress.videofriend.services;

import java.util.List;

import com.cinexpress.videofriend.models.Movie;

public interface MovieService {
    void addMovie(Movie movie);
    void updateMovie(Movie move);
    void updateAvailability(Movie movie);
    Movie getMovieById(Long id);
    List<Movie> getAllMovies();
    List<Movie> searchMovies(String genre,String director,String title,Integer year, String language, String actors);
    void deleteMovie(Long id);
}
