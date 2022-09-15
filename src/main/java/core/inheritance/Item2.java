package core.inheritance;

import lombok.*;

import javax.persistence.*;

/**
 * packageName    : core.inheritance
 * fileName       : Item
 * author         : Kim
 * date           : 2022-09-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-01        Kim       최초 생성
 */
@Entity
@Getter
@Setter
public class Item2 extends Item1 {

    @Id
    @GeneratedValue
    private Long id;

    String item2Name;
}
