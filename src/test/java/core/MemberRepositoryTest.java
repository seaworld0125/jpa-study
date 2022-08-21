package core;

import javax.persistence.EntityManager;

import core.query.Member;
import core.query.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * @author 태경 2022-08-17
 */
@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    void findMemberWithTeams() {

        Member member = memberRepository.save(Member.builder().build());

        em.flush();
        em.clear();

        var res = memberRepository.findMemberWithTeamsOutterJoin(member.getId());
        assert res.isPresent(): "없다!";
        System.out.println("Team size: " + res.get().getTeams().size());

        em.flush();
        em.clear();

        res = memberRepository.findMemberWithTeamsInnerJoin(member.getId());
        assert res.isEmpty(): "있다!";
    }
}