package ma.xproce.inventoryservice.dao.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Builder
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "creator")
    private List<Video> videos;

    public Creator() {

    }

    public Creator(Long id, String name, String email, List<Video> videos) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.videos = videos;
    }
}
