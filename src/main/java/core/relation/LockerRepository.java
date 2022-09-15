package core.relation;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : core.relation
 * fileName       : LockerRepository
 * author         : Kim
 * date           : 2022-08-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-29        Kim       최초 생성
 */
public interface LockerRepository extends JpaRepository<Locker, Long> {
}
