package core.date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface DateTestClassRepository extends JpaRepository<DateTestClass, Long> {

    @Query("select d from DateTestClass d where d.dateTime >= :date")
    List<DateTestClass> findAllByDate(@Param("date") LocalDateTime localDateTime);
}
