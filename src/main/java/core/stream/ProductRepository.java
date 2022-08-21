package core.stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p")
    Stream<Product> findAllUsingStream();
}
