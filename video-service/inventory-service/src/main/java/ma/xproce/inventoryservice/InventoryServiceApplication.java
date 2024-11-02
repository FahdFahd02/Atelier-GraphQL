package ma.xproce.inventoryservice;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        return args -> {
            List<Creator> creators = List.of(
                    Creator.builder().name("Fahd").email("fahd@example.com").build(),
                    Creator.builder().name("Mohamed").email("mohamed@example.com").build()
            );
            creatorRepository.saveAll(creators);

            List<Video> videos = List.of(
                    Video.builder().name("Video 1").url("http://video.com/1").description("La premiere video")
                            .datePublication(LocalDate.now()).creator(creators.get(0)).build(),
                    Video.builder().name("Video 2").url("http://video.com/2").description("La deuxieme video")
                            .datePublication(LocalDate.now()).creator(creators.get(1)).build()
            );
            videoRepository.saveAll(videos);
        };
    }

}


