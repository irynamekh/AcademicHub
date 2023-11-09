package academic.hub.repository;

import academic.hub.model.Lector;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query("FROM Lector l WHERE l.firstName LIKE %:template% OR l.lastName LIKE %:template%")
    List<Lector> findAllByTemplate(String template);
}
