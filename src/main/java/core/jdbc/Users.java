package core.jdbc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * packageName    : core.jdbc
 * fileName       : User
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
public class Users {

    private Long id;

    private String name;
}
