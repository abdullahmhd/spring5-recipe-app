package guru.sf.recipe.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

    private Category category;

    private final Long idVal = 4L;
    private final String descVal = "Test Category";
    private final Set<Recipe> recipes = new HashSet<>();

    @BeforeEach
    private void setup() {
        this.category = new Category();
        this.category.setId(this.idVal);
        this.category.setDescription(this.descVal);
        this.category.setRecipes(this.recipes);
    }

    @Test
    void getId() {
        assertEquals(this.idVal, category.getId());
    }

    @Test
    void getDescription() {
//        assertEquals("Wrong Desc", this.category.getDescription());
        assertEquals(this.descVal, this.category.getDescription());
    }

    @Test
    void getRecipes() {
        assertEquals(this.recipes, this.category.getRecipes());
    }
}