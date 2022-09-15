package core;

import core.relation.Locker;
import core.relation.LockerRepository;
import core.relation.Owner;
import core.relation.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * packageName    : core
 * fileName       : OntToOneTest
 * author         : Kim
 * date           : 2022-08-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-29        Kim       최초 생성
 */
@DataJpaTest
//@ActiveProfiles("db")
public class OntToOneTest {

    @Autowired
    LockerRepository lockerRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void test() {
        var owner = ownerRepository.save(Owner.testOwner());
        lockerRepository.save(
                Locker.builder()
                        .owner(owner)
                        .name("locker")
                        .build()
        );
        em.flush();
        em.clear();

        var opt = lockerRepository.findById(1L);
        assert opt.isPresent();

        System.out.println(opt.get().getOwner().getName());
    }
}
