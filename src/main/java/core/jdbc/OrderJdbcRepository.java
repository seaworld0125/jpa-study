package core.jdbc;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Order;
import java.sql.PreparedStatement;

/**
 * packageName    : core.jdbc
 * fileName       : OrderRepository
 * author         : Kim
 * date           : 2022-09-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-14        Kim       최초 생성
 */
@Repository
@AllArgsConstructor
public class OrderJdbcRepository implements OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Long insert(Orders orders) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        String SQL = "INSERT INTO orders (user_id, msg) VALUES (?, ?)";

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL, new String[] {"id"});
            ps.setLong(1, orders.getUserId());
            ps.setString(2, orders.getMsg());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }
}
