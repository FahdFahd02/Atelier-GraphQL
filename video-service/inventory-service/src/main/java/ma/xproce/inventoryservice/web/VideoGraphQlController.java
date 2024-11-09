package ma.xproce.inventoryservice.web;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import ma.xproce.inventoryservice.dto.CreatorRequestDTO;
import ma.xproce.inventoryservice.dto.VideoRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQlController {

    private final CreatorRepository creatorRepository;
    private final VideoRepository videoRepository;

    @Autowired
    public VideoGraphQlController(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
    }

    @QueryMapping
    public List<Video> videoList() {
        return videoRepository.findAll();
    }

    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Creator %s not found", id)));
    }

    @MutationMapping
    public Creator saveCreator(@Argument CreatorRequestDTO creatorDTO) {
        Creator creator = new Creator();
        creator.setName(creatorDTO.getName());
        creator.setEmail(creatorDTO.getEmail());
        return creatorRepository.save(creator);
    }

    @MutationMapping
    public Video saveVideo(@Argument VideoRequestDTO videoDTO) {
        Video video = new Video();
        video.setName(videoDTO.getName());
        video.setUrl(videoDTO.getUrl());
        video.setDescription(videoDTO.getDescription());
        video.setDatePublication(videoDTO.getDatePublication());

        Creator creator = new Creator();
        creator.setName(videoDTO.getCreator().getName());
        creator.setEmail(videoDTO.getCreator().getEmail());
        video.setCreator(creatorRepository.save(creator));

        return videoRepository.save(video);
    }
}