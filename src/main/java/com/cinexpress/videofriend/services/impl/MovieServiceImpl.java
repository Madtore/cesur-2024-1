package com.cinexpress.videofriend.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.repository.MovieRepository;
import com.cinexpress.videofriend.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void updateMovie(Movie move) {
        if (move.getDirector() != null) {
            move.setDirector(move.getDirector());
        }
        if (move.getFormat() != null) {
            move.setFormat(move.getFormat());
        }
        if (move.getGenre() != null) {
            move.setGenre(move.getGenre());
        }
        if (move.getLanguage() != null) {
            move.setLanguage(move.getLanguage());
        }
        if (move.getTitle() != null) {
            move.setTitle(move.getTitle());
        }
        movieRepository.save(move);
    }

    @Override
    public void updateAvailability(Movie movie) {
        Movie mov = movieRepository.findById(movie.getId()).get();
        mov.setAvailability(movie.getAvailability());
        movieRepository.save(mov);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String genre, String director, String title, Integer year, String language, String actors) {
        List<Movie> movies = movieRepository.findAll();
        if (genre != null) {
            movies = movies.stream().filter(m -> m.getGenre().equals(genre)).collect(Collectors.toList());
        }
        if (director != null) {
            movies = movies.stream().filter(m -> m.getDirector().equals(director)).collect(Collectors.toList());
        }
        if (title != null) {
            movies = movies.stream().filter(m -> m.getTitle().equals(title)).collect(Collectors.toList());
        }
        if (year != null) {
            movies = movies.stream().filter(m -> m.getYear().equals(year)).collect(Collectors.toList());
        }
        if (language != null) {
            movies = movies.stream().filter(m -> m.getLanguage().equals(language)).collect(Collectors.toList());
        }
        if (actors != null) {
            movies = movies.stream().filter(m -> m.getActors().stream().anyMatch(a -> a.equals(actors))).collect(Collectors.toList());
        }
        return movies;
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public void deleteMovie(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (!movie.isPresent()) {
            throw new RuntimeException("Movie not found");
        }
        movieRepository.delete(movie.get());  
    }  
}
