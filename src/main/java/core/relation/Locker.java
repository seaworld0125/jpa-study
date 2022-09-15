package core.relation;

import lombok.*;

import javax.persistence.*;

/**
 * packageName    : core.relation
 * fileName       : Locker
 * author         : Kim
 * date           : 2022-08-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-08-29        Kim       최초 생성
 */
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Owner owner;

    private String name;


}
