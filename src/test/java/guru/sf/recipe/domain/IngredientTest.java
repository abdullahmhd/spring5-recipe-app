package guru.sf.recipe.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientTest {

    private Ingredient ingredient;

    private final Long idVal = 3L;
    private final String descVal = "Test Ingregient";
    private final BigDecimal amtVal = new BigDecimal(3.3);
    private final UnitOfMeasure uom = new UnitOfMeasure();
    private final Recipe recipe = new Recipe();

    @BeforeEach
    private void setup() {
        this.ingredient = new Ingredient();
        this.ingredient.setId(this.idVal);
        this.ingredient.setDescription(this.descVal);
        this.ingredient.setAmount(this.amtVal);
        this.ingredient.setUom(this.uom);
        this.ingredient.setRecipe(this.recipe);
    }

    @Test
    void getId() {
        assertEquals(this.idVal, this.ingredient.getId());
    }

    @Test
    void getDescription() {
//        assertEquals("Wrong desc", this.ingredient.getDescription());
        assertEquals(this.descVal, this.ingredient.getDescription());
    }

    @Test
    void getAmount() {
        assertEquals(this.amtVal, this.ingredient.getAmount());
    }

    @Test
    void getUom() throws Exception {
//        throw new RuntimeException("Sonething went wrong!");
    }

    @Test
    void getRecipe() {
        assertEquals(this.recipe, this.ingredient.getRecipe());
    }
}