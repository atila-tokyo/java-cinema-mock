package cinemamock.controller;

import cinemamock.model.entities.Movie;
import cinemamock.model.repository.MovieRepository;
import cinemamock.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/movie")
public class MovieController {

    private final MovieService movieService = null;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = new MovieService;
    }

    @GetMapping
    List<Movie> getMovie() {
        return movieService.getMovie();
    }

    @PostMapping
    public void registerNewMovie(@RequestBody Movie movie) {
        movieService.addNewMovie(movie);
    }
}