package cinemamock.controller;

import cinemamock.model.entities.Movie;
import cinemamock.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/movie")
public class MovieController {

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = new MovieService();
    }

    private final MovieService movieService;
    @GetMapping
    List<Movie> getMovie() {
        return movieService.getMovie();
    }
}