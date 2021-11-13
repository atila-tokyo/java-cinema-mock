package cinemamock.service;

import cinemamock.model.entities.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    public MovieService() {
    }

    public List<Movie> getMovie() {

        private final MovieRepository movieRepository;

        List<Movie> movies = new ArrayList<>();
        movies.add(
                new Movie(
                        "Forest Gump",
                        "Run Forst",
                        333,
                        "Movie poster"
                )
        );
        return movies;
    }
}