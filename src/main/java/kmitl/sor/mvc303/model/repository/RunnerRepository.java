package kmitl.sor.mvc303.model.repository;

import kmitl.sor.mvc303.model.entity.Runner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunnerRepository extends JpaRepository<Runner ,Long> {
}
