package cinemamock.controller;

import cinemamock.model.entities.Movie;
import cinemamock.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "movie")
    public String getMovies(Model model) {
        List<Movie> movies = movieService.getMovies();
        model.addAttribute("movie", movies);
        return "movie";
    }


    @PostMapping(value = "movie/create")
    public String create(Model model) {
        return "create_movie";
    }

    @GetMapping(value = "movie/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Movie> movie = movieService.findById(id);
        model.addAttribute("movie", movie.get());
        return "edit_movie";
    }

    @GetMapping(path="movies/movie/{id}")
    public String delete(@PathVariable Long id, Model model) {
        Boolean isDelete = movieService.delete(id);
        if(isDelete) {
            model.addAttribute("message", "Movie successfully deleted");
        } else {
            model.addAttribute("message", "Movie not deleted");
        }
        List<Movie> movies = movieService.getMovies();
        model.addAttribute("movies", movies);
        return "movie";
    }

    @PostMapping(value = "movie")
    public String save(Movie movie, Model model) {
        if(movie != null) {
            movieService.save(movie);
        }
        model.addAttribute("message", "Movie successfully added");
        List<Movie> movies = movieService.getMovies();
        model.addAttribute("movies", movies);
        return "movie";
    }
}