package cinemamock.service;

import cinemamock.model.entities.Movie;
import cinemamock.model.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    @Autowired
    public MovieService(MovieRepository movieRepository) {

        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovie() {
        return movieRepository.findAll();
    }

    public void addNewMovie(Movie movie) {
        Optional<Movie> movieOptional = movieRepository.findMovieByTitle(movie.getTitle());
        if (movieOptional.isPresent()) {
            throw new IllegalStateException("Movie already registerd");
        }
        movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId) {
        boolean exists = movieRepository.existsById(movieId);
        if (!exists) {
            throw new IllegalStateException("Movie is not registered");
        }
        movieRepository.deleteById(movieId);
    }
}