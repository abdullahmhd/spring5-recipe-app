package guru.sf.recipe.bootstrap;

import guru.sf.recipe.domain.*;
import guru.sf.recipe.repositories.CategoryRepository;
import guru.sf.recipe.repositories.RecipeRepository;
import guru.sf.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

//@Component
public class DataLoader implements CommandLineRunner {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;

    public DataLoader(UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository,
                      RecipeRepository recipeRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        this.savePerfectGuacamole();
        this.saveSpicyGrilledChicken();
    }

    private void saveSpicyGrilledChicken() {

        Set<Ingredient> ingredients4SpicyGrilledChicken = new HashSet<>();
        Set<Category> categories4SpicyGrilledChicken = new HashSet<>();

        Category mexican = this.categoryRepository.findByDescription("Mexican").get();
        Category fastFood = this.categoryRepository.findByDescription("Fast Food").get();

        categories4SpicyGrilledChicken.add(mexican);
        categories4SpicyGrilledChicken.add(fastFood);

        UnitOfMeasure each = this.unitOfMeasureRepository.findByDescription("Each").get();
        UnitOfMeasure tableSpoon = this.unitOfMeasureRepository.findByDescription("Tablespoon").get();
        UnitOfMeasure teaSpoon = this.unitOfMeasureRepository.findByDescription("Teaspoon").get();

        /*
        2 tablespoons ancho chili powder
        1 teaspoon dried oregano
        1 teaspoon dried cumin
        1 teaspoon sugar
        1/2 teaspoon salt
        1 clove garlic, finely chopped
        1 tablespoon finely grated orange zest
        3 tablespoons fresh-squeezed orange juice
        2 tablespoons olive oil
        4 to 6 skinless, boneless chicken thighs (1 1/4 pounds)
         */

        Ingredient chilli = new Ingredient();
        chilli.setDescription("2 tablespoons ancho chili powder");
        chilli.setAmount(new BigDecimal(2));
        chilli.setUom(tableSpoon);

        Ingredient oregano = new Ingredient();
        oregano.setDescription("1 teaspoon dried oregano");
        oregano.setAmount(new BigDecimal(1));
        oregano.setUom(teaSpoon);

        Ingredient cumin = new Ingredient();
        cumin.setDescription("1 teaspoon dried cumin");
        cumin.setAmount(new BigDecimal(1));
        cumin.setUom(teaSpoon);

        Ingredient sugar = new Ingredient();
        sugar.setDescription("1 teaspoon sugar");
        sugar.setAmount(new BigDecimal(1));
        sugar.setUom(teaSpoon);

        Ingredient salt = new Ingredient();
        salt.setDescription("1/2 teaspoon salt");
        salt.setAmount(new BigDecimal(1));
        salt.setUom(teaSpoon);

        Ingredient garlic = new Ingredient();
        garlic.setDescription("1 clove garlic, finely chopped");
        garlic.setAmount(new BigDecimal(1));
        garlic.setUom(each);

        Ingredient orangeZest = new Ingredient();
        orangeZest.setDescription("1 tablespoon finely grated orange zest");
        orangeZest.setAmount(new BigDecimal(1));
        orangeZest.setUom(tableSpoon);

        Ingredient orangeJuice = new Ingredient();
        orangeJuice.setDescription("3 tablespoons fresh-squeezed orange juice");
        orangeJuice.setAmount(new BigDecimal(3));
        orangeJuice.setUom(tableSpoon);

        Ingredient oliveOil = new Ingredient();
        oliveOil.setDescription("2 tablespoons olive oil");
        oliveOil.setAmount(new BigDecimal(2));
        oliveOil.setUom(tableSpoon);

        Ingredient chickenThighs = new Ingredient();
        chickenThighs.setDescription("4 to 6 skinless, boneless chicken thighs (1 1/4 pounds)");
        chickenThighs.setAmount(new BigDecimal(6));
        chickenThighs.setUom(each);

        ingredients4SpicyGrilledChicken.add(chilli);
        ingredients4SpicyGrilledChicken.add(oregano);
        ingredients4SpicyGrilledChicken.add(cumin);
        ingredients4SpicyGrilledChicken.add(sugar);
        ingredients4SpicyGrilledChicken.add(salt);
        ingredients4SpicyGrilledChicken.add(garlic);
        ingredients4SpicyGrilledChicken.add(orangeZest);
        ingredients4SpicyGrilledChicken.add(orangeJuice);
        ingredients4SpicyGrilledChicken.add(oliveOil);
        ingredients4SpicyGrilledChicken.add(chickenThighs);

        Notes notes = new Notes();
        notes.setRecipeNotes("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings." +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");

        Recipe spicyGrilledChickenTaco = new Recipe();
        spicyGrilledChickenTaco.setCategories(categories4SpicyGrilledChicken);
        spicyGrilledChickenTaco.setCookTime(1);
        spicyGrilledChickenTaco.setPrepTime(3);
        spicyGrilledChickenTaco.setServings(6);
        spicyGrilledChickenTaco.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        spicyGrilledChickenTaco.setSource("SimpleRecipe.com");
        spicyGrilledChickenTaco.setDirections("8 small corn tortillas\n" +
                "3 cups packed baby arugula (3 ounces)\n" +
                "2 medium ripe avocados, sliced\n" +
                "4 radishes, thinly sliced");
        spicyGrilledChickenTaco.setDescription("Spicy grilled chicken tacos");
        spicyGrilledChickenTaco.setDifficulty(Difficulty.KIND_OF_HARD);
        spicyGrilledChickenTaco.setImage(this.extractBytes("GrilledChickenTacos.jpg"));
        spicyGrilledChickenTaco.setNotes(notes);
        notes.setRecipe(spicyGrilledChickenTaco);
        spicyGrilledChickenTaco.setCategories(categories4SpicyGrilledChicken);
        spicyGrilledChickenTaco.setIngredients(ingredients4SpicyGrilledChicken);
        ingredients4SpicyGrilledChicken.forEach(ingredient -> {
            ingredient.setRecipe(spicyGrilledChickenTaco);
        });


        recipeRepository.save(spicyGrilledChickenTaco);

        System.out.println("Spicy Grilled Chicken Tacos saved successfully!");


    }

    private void savePerfectGuacamole() {
        Set<Ingredient> ingredientsForGuacamole = new HashSet<>();
        Set<Category> categoriesForGuacamole = new HashSet<>();

        Category mexican = this.categoryRepository.findByDescription("Mexican").get();
        Category fastFood = this.categoryRepository.findByDescription("Fast Food").get();

        categoriesForGuacamole.add(mexican);
        categoriesForGuacamole.add(fastFood);
        /*
            2 ripe avocados
            1/4 teaspoon of salt, more to taste
            1 tablespoon fresh lime juice or lemon juice
            2 tablespoons to 1/4 cup of minced red onion or thinly sliced green onion
            1-2 serrano chiles, stems and seeds removed, minced
            2 tablespoons cilantro (leaves and tender stems), finely chopped
            A dash of freshly grated black pepper
            1/2 ripe tomato, seeds and pulp removed, chopped
            Red radishes or jicama, to garnish
            Tortilla chips, to serve
         */

        UnitOfMeasure each = this.unitOfMeasureRepository.findByDescription("Each").get();
        UnitOfMeasure tableSpoon = this.unitOfMeasureRepository.findByDescription("Tablespoon").get();
        UnitOfMeasure dash = this.unitOfMeasureRepository.findByDescription("Dash").get();

        Ingredient avacado = new Ingredient();
        avacado.setDescription("2 ripe avacados");
        avacado.setAmount(new BigDecimal(2));
        avacado.setUom(each);

        Ingredient salt = new Ingredient();
        salt.setDescription("1/4 teaspoon of salt, more to taste");
        salt.setAmount(new BigDecimal(1 / 4));
        salt.setUom(tableSpoon);

        Ingredient limeJuice = new Ingredient();
        limeJuice.setDescription("1 tablespoon fresh lime juice or lemon juice");
        limeJuice.setAmount(new BigDecimal(1));
        limeJuice.setUom(tableSpoon);

        Ingredient onion = new Ingredient();
        onion.setDescription("2 tablespoons to 1/4 cup of minced red onion or thinly sliced green onion");
        onion.setAmount(new BigDecimal(2));
        onion.setUom(tableSpoon);

        Ingredient chiles = new Ingredient();
        chiles.setDescription("1-2 serrano chiles, stems and seeds removed, minced");
        chiles.setAmount(new BigDecimal(2));
        chiles.setUom(each);

        Ingredient cilantro = new Ingredient();
        cilantro.setDescription("2 tablespoons cilantro (leaves and tender stems), finely chopped");
        cilantro.setAmount(new BigDecimal(2));
        cilantro.setUom(tableSpoon);

        Ingredient blackPepper = new Ingredient();
        blackPepper.setDescription("A dash of freshly grated black pepper");
        blackPepper.setAmount(new BigDecimal(1));
        blackPepper.setUom(dash);

        Ingredient tomato = new Ingredient();
        tomato.setDescription("1/2 ripe tomato, seeds and pulp removed, chopped");
        tomato.setAmount(new BigDecimal(1 / 2));
        tomato.setUom(each);

        Ingredient radish = new Ingredient();
        radish.setDescription("Red radishes or jicama, to garnish");
        radish.setAmount(new BigDecimal(2));
        radish.setUom(each);

        Ingredient chips = new Ingredient();
        chips.setDescription("Tortilla chips, to serve");
        chips.setAmount(new BigDecimal(10));
        chips.setUom(each);

        ingredientsForGuacamole.add(avacado);
        ingredientsForGuacamole.add(salt);
        ingredientsForGuacamole.add(limeJuice);
        ingredientsForGuacamole.add(onion);
        ingredientsForGuacamole.add(chiles);
        ingredientsForGuacamole.add(cilantro);
        ingredientsForGuacamole.add(blackPepper);
        ingredientsForGuacamole.add(tomato);
        ingredientsForGuacamole.add(radish);
        ingredientsForGuacamole.add(chips);

        Notes notes = new Notes();
        notes.setRecipeNotes("Guacamole is best eaten right after it’s made. Like apples, avocados start to oxidize and turn brown once they’ve been cut. That said, the acid in the lime juice you add to guacamole can help slow down that process, and if you store the guacamole properly, you can easily make it a few hours ahead if you are preparing for a party.\n" +
                "\n" +
                "The trick to keeping guacamole green is to make sure air doesn’t touch it! Transfer it to a container, cover with plastic wrap, and press down on the plastic wrap to squeeze out any air pockets. Make sure any exposed surface of the guacamole is touching the plastic wrap, not air. This will keep the amount of browning to a minimum.\n" +
                "\n" +
                "You can store the guacamole in the fridge this way for up to three days.\n" +
                "\n" +
                "If you leave the guacamole exposed to air, it will start to brown and discolor. That browning isn’t very appetizing, but the guacamole is still good. You can either scrape off the brown parts and discard, or stir them into the rest of the guacamole.");


        Recipe perfectGuacamole = new Recipe();
        perfectGuacamole.setCategories(categoriesForGuacamole);
        perfectGuacamole.setCookTime(1);
        perfectGuacamole.setPrepTime(3);
        perfectGuacamole.setServings(5);
        perfectGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        perfectGuacamole.setSource("SimpleRecipe.com");
        perfectGuacamole.setDirections("Gently tap the pit with your chef’s knife so the knife gets wedged into the pit. Twist your knife slightly to dislodge the pit and lift to remove. If you use this method, first protect your hand with a thick kitchen towel before proceeding.");
        perfectGuacamole.setDescription("Perfect Guacamole");
        perfectGuacamole.setDifficulty(Difficulty.MODERATE);
        perfectGuacamole.setImage(this.extractBytes("Guacamole.jpg"));
        perfectGuacamole.setNotes(notes);
        notes.setRecipe(perfectGuacamole);
        perfectGuacamole.setCategories(categoriesForGuacamole);
        perfectGuacamole.setIngredients(ingredientsForGuacamole);
        ingredientsForGuacamole.forEach(ingredient -> {
            ingredient.setRecipe(perfectGuacamole);
        });


        recipeRepository.save(perfectGuacamole);

        System.out.println("Perfect Guacamole saved successfully!");
    }

    public Byte[] extractBytes (String ImageName)  {

//        DataBufferByte data = null;
//        Byte[] img = null;
//        try {
//            // open image
//            File imgPath = new File(ImageName);
//            BufferedImage bufferedImage = ImageIO.read(imgPath);
//
//            // get DataBufferBytes from Raster
//            WritableRaster raster = bufferedImage .getRaster();
//            data = (DataBufferByte) raster.getDataBuffer();
//        } catch (IOException ioe) {
//            System.out.println("Error while getting image: "+ImageName);
//        }
//        if(data != null && data.getData() != null) {
//            img = new Byte[data.getData().length];
//            for(int i=0; i<data.getData().length; i++)
//                img[i] = data.getData()[i];
//        }

        Byte[] img = null;
        byte[] bytesArray = null;

        try {
            Resource resource = new ClassPathResource(ImageName);
            InputStream input = resource.getInputStream();
            File file = resource.getFile();
            bytesArray = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            fis.read(bytesArray); //read file into bytes[]
            fis.close();

        } catch (IOException ioe) {
            System.out.println("Error while getting image: "+ImageName);
        }

        if(bytesArray != null && bytesArray != null) {
            img = new Byte[bytesArray.length];
            for(int i=0; i<bytesArray.length; i++)
                img[i] = bytesArray[i];
        }

        return img;
    }
}
