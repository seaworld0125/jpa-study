package core;

import core.relation.Child;
import core.relation.ChildRepository;
import core.relation.Parent;
import core.relation.ParentRepository;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * @author 태경 2022-08-09
 */
@DataJpaTest
class RelationTest {

    /*
    * 여러가지 JPA 관계를 참조할 때 어떤 현상이 일어나는지 확인
    * */

    @Autowired
    ParentRepository parentRepository;

    @Autowired
    ChildRepository childRepository;

    @Autowired
    EntityManager em;

    final int CHILD_COUNT = 200;

    @BeforeEach
    void before() {
        Parent parent1 = parentRepository.save(
                Parent.builder()
                        .name("testParent1")
                        .build()
        );

        for(int i = 0; i < CHILD_COUNT; i++)
            childRepository.save(
                    Child.builder()
                            .name("testChild")
                            .parent(parent1)
                            .build()
            );

        Parent parent2 = parentRepository.save(
                Parent.builder()
                        .name("testParent2")
                        .build()
        );

        for(int i = 0; i < CHILD_COUNT; i++)
            childRepository.save(
                    Child.builder()
                            .name("testChild")
                            .parent(parent2)
                            .build()
            );

        em.flush();
        em.clear();

        System.out.println("******************************* Test Start *******************************");
    }

    @AfterEach
    void clean() {
        System.out.println("******************************* Test finish *******************************");
        childRepository.deleteAll();
        parentRepository.deleteAll();
    }

    void printParentInfo(List<Child> children) {
        for (var c : children) {
            System.out.println(c.getParent());
        }
    }

    <T> void print(T data) {
        System.out.println("[" + data + "]");
    }

    @Test
    void test3() {
        List<Parent> parents1 = parentRepository.findAllUsingJoinFetch();

        for(var p : parents1) {
            System.out.println(p.getChildren().size());
        }

        List<Parent> parents2 = parentRepository.findAllUsingLeftJoinFetch();
    }
}