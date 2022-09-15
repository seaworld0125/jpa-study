package core.query;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : core.query
 * fileName       : MemberJdbcRepositoryTest
 * author         : Kim
 * date           : 2022-09-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-13        Kim       최초 생성
 */
@SpringBootTest
@ActiveProfiles("db")
class MemberJdbcRepositoryTest {

    @Autowired
    MemberJdbcRepository memberJdbcRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    void test() {
        List<Member> memberList = new ArrayList<>();

//
//        for(int i = 0; i < 5000; i++) {
//
//            memberList.add(Member.builder().name(i + "").build());
//        }
//
//        memberJdbcRepository.saveAll(2000, memberList);
    }

    @Test
    void saveAll() {
        var opt = memberRepository.findMemberByName("member_name-9191");
        assertThat(opt).isPresent();
    }
}