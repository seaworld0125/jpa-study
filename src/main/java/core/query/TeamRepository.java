package core.query;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author 태경 2022-08-09
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
