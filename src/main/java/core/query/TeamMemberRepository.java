package core.query;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author 태경 2022-08-13
 */
@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    Optional<TeamMember> findByTeamId(Long teamId);

    Optional<TeamMember> findByTeam(Team team);

    @Query("select t from TeamMember t where t.member.id = ?1 and t.team.id = ?2")
    Optional<TeamMember> findByMemberIdAndTeamId(Long memberId, Long teamId);
}
