package core.jdbc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * packageName    : core.jdbc
 * fileName       : Order
 * author         : Kim
 * date           : 2022-09-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-14        Kim       최초 생성
 */
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Orders {

    private Long id;

    private Long userId;

    private String msg;

    private OrderState state;
}
