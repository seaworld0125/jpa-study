package core;

import core.date.DateTestClass;
import core.date.DateTestClassRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@DataJpaTest
class DateTestClassTest {

    @Autowired
    private DateTestClassRepository repository;

    @Autowired
    private EntityManager em;

    @Test
    void saveTest() {

        int day = 1;
        while(day < 32) {
            int hrs = 0;
            while(hrs < 24) {
                repository.save(
                    DateTestClass.builder()
                            .dateTime(LocalDateTime.of(2022, 8, day, hrs, 0))
                            .build()
                );
                hrs++;
            }
            day++;
        }

        em.flush();
        em.clear();

        List<DateTestClass> dList = repository.findAllByDate(LocalDateTime.of(2022, 8, 30, 2, 0));

        for(var d : dList) {
            System.out.println(d);
        }
    }
}