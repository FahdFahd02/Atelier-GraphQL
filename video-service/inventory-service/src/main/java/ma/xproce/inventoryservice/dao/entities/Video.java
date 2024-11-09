package ma.xproce.inventoryservice.dao.entities;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Builder
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    private String description;
    private String datePublication;

    @ManyToOne
    private Creator creator;

    public Video() {

    }

    public Video(Long id, String name, String url, String description, String datePublication, Creator creator) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
        this.datePublication = datePublication;
        this.creator = creator;
    }
}
