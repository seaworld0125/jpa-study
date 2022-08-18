package core.relation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 태경 2022-08-09
 */
@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {


}
