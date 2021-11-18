package cinemamock.controller;

import cinemamock.model.entities.Movie;
import cinemamock.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "movies")
    List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @PostMapping(value = "movies")
    public void registerNewMovie(@RequestBody Movie movie) {
        movieService.addNewMovie(movie);
    }

    @DeleteMapping(path="movies/{movieId}")
    public void deleteMovie(@PathVariable("movieId") Long movieId) {
        movieService.deleteMovie(movieId);
    }

    @PutMapping(path="movies/{movieId}")
    public void updateMovie(
            @PathVariable("movieId") Long movieId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) int duration,
            @RequestParam(required = false) String image) {
        movieService.updateMovie(movieId, title, description, duration, image);
    }

}