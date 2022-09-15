package core;

import core.relation.Owner;
import core.relation.OwnerRepository;
import core.relation.OwnerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName    : core
 * fileName       : TransactionTest
 * author         : Kim
 * date           : 2022-08-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-30        Kim       최초 생성
 */
@SpringBootTest
public class TransactionTest {

    @Autowired
    OwnerService ownerService;

    @Test
    void test() {
        ownerService.saveTestOwner();
        ownerService.updateName(1L, "tester");
        Owner owner = ownerService.findById(1L);
        Assertions.assertThat(owner.getName()).isEqualTo("tester");
    }
}
