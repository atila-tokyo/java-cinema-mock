package cinemamock.model.repository;

import cinemamock.model.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findMovieByTitle(String title);

    /* line above is the equivalent to the query
       @Query("SELECT m FROM Movie m WHERE m.title = ?1");
    */
}