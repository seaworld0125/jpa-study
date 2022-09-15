package core;

import core.query.Member;
import core.query.MemberRepository;
import core.query.Team;
import core.query.TeamMember;
import core.query.TeamMemberRepository;
import core.query.TeamRepository;
import javax.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

/**
 * @author 태경 2022-08-12
 */
@DataJpaTest
public class QueryTest {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamMemberRepository teamMemberRepository;

    @Autowired
    EntityManager em;

    @Test
    void queryTest_findById테스트() {

        var t = teamRepository.save(Team.builder().build());
        var m = memberRepository.save(Member.builder().build());

        teamMemberRepository.save(TeamMember.builder()
                .team(t)
                .member(m)
                .build());

        em.flush();
        em.clear();

        System.out.println("=======================================================");
        var opt = teamMemberRepository.findByTeamId(t.getId());
        Assertions.assertThat(opt).isPresent();

        System.out.println("=======================================================");
        var opt2 = teamMemberRepository.findByTeam(t);
        Assertions.assertThat(opt2).isPresent();
    }

    @Test
    void queryTest_findById테스트2() {

        var t = teamRepository.save(Team.builder().build());
        var m = memberRepository.save(Member.builder().build());

        teamMemberRepository.save(TeamMember.builder()
                .team(t)
                .member(m)
                .build());

        em.flush();
        em.clear();

        System.out.println("=======================================================");
        var opt = teamMemberRepository.findByMemberIdAndTeamId(m.getId(), t.getId());
        Assertions.assertThat(opt).isPresent();
    }

    @Test
    void queryTest_유니크테스트() {

        var t = teamRepository.save(Team.builder().build());
        var m = memberRepository.save(Member.builder().build());

        teamMemberRepository.save(TeamMember.builder()
                .team(t)
                .member(m)
                .build());

        em.flush();
        em.clear();

        t = teamRepository.save(Team.builder().build());
        m = memberRepository.save(Member.builder().build());

        teamMemberRepository.save(TeamMember.builder()
                .team(t)
                .member(m)
                .build());

        em.flush();
        em.clear();

        teamMemberRepository.findAll().forEach(System.out::println);
    }

    @Test
    void queryTest_더티체킹테스트() {

        var t = teamRepository.save(Team.builder().name("바르셀로나").build());
        t.setName("파리셍제르망");
    }

    @Test
    void saveTest_저장테스트() {

        var t = teamRepository.save(Team.builder().build());
        var m = memberRepository.save(Member.builder().build());
    }

    @Test
    void dateTest() {
        LocalDateTime date1 = LocalDateTime.of(2022, 8, 26, 10, 0, 0);
        LocalDateTime date2 = LocalDateTime.of(2022, 8, 26, 10, 0, 1);

        System.out.println(date1.toString());
        System.out.println(date2.toString());
        assert date1.isEqual(date2): "안같음";
    }
}
