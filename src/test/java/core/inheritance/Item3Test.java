package core.inheritance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : core.inheritance
 * fileName       : Item3Test
 * author         : Kim
 * date           : 2022-09-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-01        Kim       최초 생성
 */
@DataJpaTest
class Item3Test {

    @Autowired
    EntityManager em;

    @Test
    void test() {

        Item3 item3 = new Item3();
        item3.setItem1Name("name1");
        item3.setItem3Name("name3");

        em.persist(item3);
        em.flush();
        em.clear();

        Item1 item = em.find(Item1.class, item3.getId());
        System.out.println(item);
    }
}