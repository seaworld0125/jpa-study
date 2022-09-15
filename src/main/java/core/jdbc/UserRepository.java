package core.jdbc;

/**
 * packageName    : core.jdbc
 * fileName       : UserRepository
 * author         : Kim
 * date           : 2022-09-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-14        Kim       최초 생성
 */
public interface UserRepository {

    Long insert(Users users);
}
