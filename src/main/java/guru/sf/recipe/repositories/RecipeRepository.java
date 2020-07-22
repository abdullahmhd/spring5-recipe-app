package guru.sf.recipe.repositories;

import guru.sf.recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
