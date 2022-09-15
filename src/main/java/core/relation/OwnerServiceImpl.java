package core.relation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName    : core.relation
 * fileName       : OwnerServiceImpl
 * author         : Kim
 * date           : 2022-08-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-30        Kim       최초 생성
 */
@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Override
    public void saveTestOwner() {
        ownerRepository.save(Owner.testOwner());
    }

    @Override
    public Owner findById(long id) {
        return ownerRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void updateName(long id, String name) {
        Owner owner = findById(id);
        owner.setName(name);
    }
}
