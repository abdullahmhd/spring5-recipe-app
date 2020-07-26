package guru.sf.recipe.services;

import guru.sf.recipe.commands.RecipeCommand;
import guru.sf.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
