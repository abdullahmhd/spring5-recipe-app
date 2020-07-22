package guru.sf.recipe.controllers;

import guru.sf.recipe.domain.Category;
import guru.sf.recipe.domain.UnitOfMeasure;
import guru.sf.recipe.repositories.CategoryRepository;
import guru.sf.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String getIndex() {

        Optional<Category> optionalCategory = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription("Ounce");

        System.out.println("Cat id is= "+optionalCategory.get().getId());
        System.out.println("UOM id is= "+optionalUnitOfMeasure.get().getId());
        return "index";
    }
}
