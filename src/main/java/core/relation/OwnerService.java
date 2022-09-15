package core.relation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName    : core.relation
 * fileName       : OwnerService
 * author         : Kim
 * date           : 2022-08-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-30        Kim       최초 생성
 */
public interface OwnerService {

    void saveTestOwner();

    Owner findById(long id);

    void updateName(long id, String name);
}
