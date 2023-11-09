package academic.hub.repository;

import academic.hub.model.Department;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("FROM Department d LEFT JOIN FETCH d.head WHERE d.name = :name")
    Optional<Department> findByName(String name);

    @Query("SELECT SUM(CASE WHEN l.degree = 'ASSISTANT' THEN 1 ELSE 0 END),"
            + "    SUM(CASE WHEN l.degree = 'ASSOCIATE_PROFESSOR' THEN 1 ELSE 0 END),"
            + "    SUM(CASE WHEN l.degree = 'PROFESSOR' THEN 1 ELSE 0 END)"
            + "FROM Department d LEFT JOIN d.lectors l WHERE d.name = :name")
    Optional<String> getStatistic(String name);

    @Query("SELECT AVG(l.salary) FROM Department d LEFT JOIN d.lectors l WHERE d.name = :name")
    BigDecimal getAverageLectorsSalary(String name);

    @Query("SELECT COUNT(l) FROM Department d LEFT JOIN d.lectors l WHERE d.name = :name")
    int getCountLectors(String name);
}
