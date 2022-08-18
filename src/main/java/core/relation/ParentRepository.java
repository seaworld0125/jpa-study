package core.relation;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author 태경 2022-08-09
 */
@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

    @Query("select distinct p from Parent p join fetch p.children")
    List<Parent> findAllUsingJoinFetch();

    @Query("select distinct p from Parent p left join fetch p.children")
    List<Parent> findAllUsingLeftJoinFetch();
}
