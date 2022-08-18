package core.query;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 태경 2022-08-09
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m left join fetch m.teams where m.id = :id")
    Optional<Member> findMemberWithTeamsOutterJoin(@Param("id") Long id);

    @Query("select m from Member m join fetch m.teams where m.id = :id")
    Optional<Member> findMemberWithTeamsInnerJoin(@Param("id") Long id);
}
