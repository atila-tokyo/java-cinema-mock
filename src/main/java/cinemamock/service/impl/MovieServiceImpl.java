package cinemamock.service.impl;

import cinemamock.model.entities.Movie;
import cinemamock.model.repository.MovieRepository;
import cinemamock.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovie(Movie movie) {
        return movieRepository.findMovieByTitle(movie.getTitle());
    }

    public void save(Movie movie) {
        Optional<Movie> movieOptional = movieRepository.findMovieByTitle(movie.getTitle());
        if (movieOptional.isPresent()) {
            throw new IllegalStateException("Movie already registered");
        } else {
            movieRepository.save(movie);
        }
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }


    public Boolean delete(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            movieRepository.delete(movie.get());
            return true;
        }
        return false;
    }

    public void updateMovie(Long movieId, String title, String description, int duration, String image) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalStateException(
                        "Referred movie is not registered"
                ));

        if (title != null && title.length() > 0 && !Objects.equals(movie.getTitle(), title)) {
            Optional <Movie> movieOptional = movieRepository.findMovieByTitle(title);
            if (movieOptional.isPresent()) {
                throw new IllegalStateException("Title already registered");
            }
            movie.setTitle(title);
        }

        if (description != null && description.length() > 0) {
            movie.setDescription(description);
        }

        if (duration > 0) {
            movie.setDuration(duration);
        }

        if (image != null && image.length() > 0) {
            movie.setImage(image);
        }
    }
}