package core.relation;

import lombok.*;

import javax.persistence.*;

/**
 * packageName    : core.relation
 * fileName       : Member
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
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public static Owner testOwner() {
        return Owner.builder().name("owner").build();
    }
}
