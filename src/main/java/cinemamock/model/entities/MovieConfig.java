package cinemamock.model.entities;

import cinemamock.model.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieConfig {
    private Object List;

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository movieRepository) {
        return args -> {
            Movie forest =  new Movie(
                    "Forest Gump",
                    "Run Forst",
                    333,
                    "Movie poster"
            );
            movieRepository.save(forest);
        };

    }
}