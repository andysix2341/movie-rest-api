package com.movie.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.movie.Dto.MovieRequestDto;
import com.movie.Exception.DuplicationException;
import com.movie.Exception.ResourceNotFoundException;
import com.movie.Model.Album;
import com.movie.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Album> getAllMovie() {
        return movieRepository.findAll();
    }

    public Optional<Album> getMovieById(UUID movieId) {
        return movieRepository.findById(movieId);
    }
    public Boolean hasMovieTheSameName(String movieName) {
        return getAllMovie().stream()
                .anyMatch(album -> album.getMovieName().contains(movieName));
    }

    public void addMovie(MovieRequestDto movie) {
        Boolean checkMovie = hasMovieTheSameName(movie.movieName());
        if (checkMovie) {
            throw new DuplicationException("This movie name has already been registered" + movie.movieName());
        }
        Album movieAlbum = new Album(movie.movieName(), movie.movieDirector());
        movieRepository.save(movieAlbum);
    }

    public void updateMovieById(UUID movieId, MovieRequestDto newMovie) {
        Boolean checkMovie = hasMovieTheSameName(newMovie.movieName());
        if (checkMovie) {
            throw new DuplicationException("This movie name has already been registered" + newMovie.movieName());
        }
        Album foundMovie = getMovieById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie with this id not found"));
        foundMovie.setMovieName(newMovie.movieName());
        foundMovie.setDirector(newMovie.movieDirector());
        movieRepository.save(foundMovie);
    }

    public void deletMovieById(UUID movieId) {
        Album foundMovie = getMovieById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie with this id not found"));
        movieRepository.delete(foundMovie);
    }

    public Album getMovieByName(String movieName) {
        return getAllMovie().stream()
            .filter(album -> album.getMovieName().equals(movieName))
            .findAny()
            .orElseThrow(() -> new ResourceNotFoundException("Movie with this name" + movieName + "not found" ));
    }

    public String deleteAllMovie() {
        movieRepository.deleteAll();
        return "there's no movie in album";
    }
    
}
