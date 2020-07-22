package guru.sf.recipe.repositories;

import guru.sf.recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
