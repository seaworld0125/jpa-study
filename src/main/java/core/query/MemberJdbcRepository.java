package core.query;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName    : core.query
 * fileName       : MemberJDBCRepository
 * author         : Kim
 * date           : 2022-09-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-13        Kim       최초 생성
 */
@Repository
@RequiredArgsConstructor
public class MemberJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public void saveAll(int batchSize, List<Member> members) {

        jdbcTemplate.batchUpdate("insert into member (name) values (?)",
            members,
            batchSize,
            (ps, argument) -> {
                ps.setString(1, argument.getName());
            }
        );
    }
}
