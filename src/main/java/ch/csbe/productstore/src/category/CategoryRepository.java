package ch.csbe.productstore.src.category;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoryByName(String name);
}
