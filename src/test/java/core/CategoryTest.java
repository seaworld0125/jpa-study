package core;

import core.relation.Category;
import core.relation.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * packageName    : core
 * fileName       : CategoryTest
 * author         : Kim
 * date           : 2022-09-01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-09-01        Kim       최초 생성
 */
@SpringBootTest
@ActiveProfiles("db")
@Slf4j
public class CategoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void test() {

        Category parentCategory = categoryRepository.save(
                Category.builder()
                        .name("치킨")
                        .build()
        );

        categoryRepository.save(
                Category.builder()
                        .name("네네치킨")
                        .parentCategory(parentCategory)
                        .build()
        );
        categoryRepository.save(
                Category.builder()
                        .name("BBQ")
                        .parentCategory(parentCategory)
                        .build()
        );
        categoryRepository.save(
                Category.builder()
                        .name("굽네치킨")
                        .parentCategory(parentCategory)
                        .build()
        );
    }

    @Test
    @Transactional
    void test2() {
        Category category = categoryRepository.findCategoryByName("치킨").orElseThrow();
        List<Category> childCategories = category.getChildCategories();

        System.out.println("치킨 카테고리의 하위 카테고리 목록");
        for(var c : childCategories) {
            System.out.printf(">> %s\n", c.getName());
        }
    }
}
