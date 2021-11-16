package cinemamock.service;

import cinemamock.model.entities.Movie;
import cinemamock.model.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // A more semantic annotation to work on dependency injection
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
            throw new IllegalStateException("Movie already registered");
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

    @Transactional
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