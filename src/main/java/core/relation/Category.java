package core.relation;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * packageName    : core.relation
 * fileName       : Box
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
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String name;

    @OneToMany(mappedBy = "parentCategory")
    List<Category> childCategories;

    @ManyToOne
    Category parentCategory;
}
