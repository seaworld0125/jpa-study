package core;

import core.relation.Child;
import core.relation.ChildRepository;
import core.relation.Parent;
import core.relation.ParentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

/**
 * packageName    : core
 * fileName       : CascadeTest
 * author         : Kim
 * date           : 2022-08-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-30        Kim       최초 생성
 */
@SpringBootTest
public class CascadeTest {

    @Autowired
    ChildRepository childRepository;

    @Autowired
    ParentRepository parentRepository;

    @Autowired
    EntityManager em;

    @Test
    void test() {

        Parent parent = parentRepository.save(
                Parent.builder().name("parent").build()
        );

//        for(int i = 0; i < 10; i++) {
//            childRepository.save(
//                    Child.builder().parent(parent).build()
//            );
//        }

        em.flush();
        em.clear();

        parentRepository.deleteById(parent.getId());

        em.flush();
        em.clear();

        System.out.println("===================================== finish");
    }

    @Test
    void test2() {

        Parent parent = parentRepository.save(
                Parent.builder().name("parent").build()
        );

        parentRepository.deleteParentById(99L);
    }
}
