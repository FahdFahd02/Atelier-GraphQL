package ma.xproce.inventoryservice.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.xproce.inventoryservice.dao.entities.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
