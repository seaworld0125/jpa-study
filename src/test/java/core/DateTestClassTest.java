package core;

import core.date.DateTestClass;
import core.date.DateTestClassRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        var dList = repository.findAllByDate(LocalDateTime.of(2022, 8, 30, 2, 0));

        dList.forEach(System.out::println);
    }

    @Test
    void saveTest2() {

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

        var dList = repository.findAllOrderByDesc();

        dList.limit(10).forEach(System.out::println);
    }

    @Test
    void timeTest() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime time = LocalDateTime.of(now.getYear(), now.getMonth(), 1, 0, 0);
        LocalDateTime yesterday = time.minusDays(1);
        System.out.println(yesterday);
    }

    @Test
    void timeTest2() {
        String dateString = "2022-08-22T12:33";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime date = LocalDateTime.parse(dateString, formatter);
        System.out.println(date);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")));
    }
}