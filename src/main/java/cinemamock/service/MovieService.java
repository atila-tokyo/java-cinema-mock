package cinemamock.service;

import cinemamock.model.entities.Movie;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    public List<Movie> getMovie() {
        return ListOf( // Method seems to not exist in JAVA EE8
                new Movie(
                        "Forest Gump",
                        "Run Forst",
                        333,
                        "Movie poster"
                )
        );
    }
}