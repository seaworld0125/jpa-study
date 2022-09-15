package core.relation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * packageName    : core.relation
 * fileName       : CategoryRepository
 * author         : Kim
 * date           : 2022-09-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-01        Kim       최초 생성
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findCategoryByName(String name);
}
