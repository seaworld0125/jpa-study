package core.jdbc;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

/**
 * packageName    : core.jdbc
 * fileName       : UserJdbcRepository
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
public class UserJdbcRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Long insert(Users users) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String SQL = "INSERT INTO users (name) VALUES (?)";

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL, new String[] {"id"});
            ps.setString(1, users.getName());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }
}
