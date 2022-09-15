package core.relation;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

/**
 * @author 태경 2022-08-09
 */
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @BatchSize(size = 5)
    @Default
    private Set<Child> children = new HashSet<>();
}
