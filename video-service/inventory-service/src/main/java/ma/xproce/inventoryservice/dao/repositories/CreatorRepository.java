package ma.xproce.inventoryservice.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.xproce.inventoryservice.dao.entities.Creator;

public interface CreatorRepository extends JpaRepository<Creator, Long> {
}
