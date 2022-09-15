package core.jdbc;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName    : core.jdbc
 * fileName       : UserJdbcRepositoryTest
 * author         : Kim
 * date           : 2022-09-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-14        Kim       최초 생성
 */
@SpringBootTest
@ActiveProfiles("db")
class JdbcRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Test
    void insert() {
        Users users = Users.builder()
                .name("testName")
                .build();

        var id = userRepository.insert(users);
        System.out.println(">>>>>>>>>>>>> userId : " + id);

        Orders orders = Orders.builder()
                .msg("testMsg")
                .userId(id)
                .build();

        id = orderRepository.insert(orders);
        System.out.println(">>>>>>>>>>>>> orderId : " + id);
    }
}