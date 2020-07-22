package guru.sf.recipe.repositories;

import guru.sf.recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
