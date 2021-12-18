package cinemamock.service;

import cinemamock.model.entities.Movie;

import java.util.List;
import java.util.Optional;


public interface MovieService {

    List<Movie> getMovies();

    Optional<Movie> getMovie(Movie movie);

    void save(Movie movie);


    Optional<Movie> findById(Long id);

    Boolean delete(Long id);

}