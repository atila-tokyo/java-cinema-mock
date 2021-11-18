package cinemamock.model.entities;

import cinemamock.model.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoomConfig {
    private Object List;

    @Bean
    CommandLineRunner commandLineRunner(RoomRepository roomRepository) {
        return args -> {
            Room noir =  new Room(
                    "Noir",
                    80
            );
            roomRepository.save(noir);

            Room classics = new Room(
                    "Classics",
                    50
            );
            roomRepository.save(classics);
        };

    }
}