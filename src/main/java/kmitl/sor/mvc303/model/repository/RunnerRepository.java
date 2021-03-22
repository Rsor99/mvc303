package kmitl.sor.mvc303.model.repository;

import kmitl.sor.mvc303.model.entity.Runner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RunnerRepository extends JpaRepository<Runner ,Long> {
    @Query(value = "select * from runner order by distance desc limit 10",nativeQuery = true)
    List<Runner> findTop10();
}
