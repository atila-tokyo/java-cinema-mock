package cinemamock;

import cinemamock.model.entities.Room;
import cinemamock.model.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@EntityScan
@RestController
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(RoomRepository roomRepository) {
		return args -> {
			Room noir = new Room(
					"Noir",
					80
			);
			roomRepository.save(noir);

			Room classics = new Room(
					"Classics",
					50
			);
			roomRepository.save(classics);

			Room thriller = new Room(
					"Thriller",
					100
			);
			roomRepository.save(thriller);
			Room threeD = new Room(
					"3D",
					120
			);
			roomRepository.save(threeD);
		};

	}
}

