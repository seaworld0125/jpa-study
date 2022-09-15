package core.date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public interface DateTestClassRepository extends JpaRepository<DateTestClass, Long> {

    @Query("select d from DateTestClass d where d.dateTime >= :date")
    Stream<DateTestClass> findAllByDate(@Param("date") LocalDateTime localDateTime);

    @Query("select d from DateTestClass d order by d.dateTime desc")
    Stream<DateTestClass> findAllOrderByDesc();
}
