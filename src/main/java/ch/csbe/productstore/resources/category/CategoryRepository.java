package ch.csbe.productstore.resources.category;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findCategories();
    Category findCategoryById(Integer id);
}
