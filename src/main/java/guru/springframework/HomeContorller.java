package guru.springframework;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeContorller {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeService recipeService;

    @Autowired
    public HomeContorller(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeService recipeService) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeService = recipeService;
    }



    @RequestMapping({"","/","/index"})
    public String getHome(Model model){
        List<Recipe> recipes = new ArrayList<>();
        recipeService.getAllRecipes().forEach(recipes::add);
        model.addAttribute("recipes", recipes);
        return "home";
    }
}

/*
* *          Jak tak zrobię to obiekt jest typu Optional i nie mogę zczytać pól z klasty DEscription
        model.addAttribute("mex" , categoryRepository.findByDescription("Mexican"));

Optional<Category> mex = categoryRepository.findByDescription("Mexican");
    Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println("1.  Optional<Category> mex " + mex.getClass() );
                System.out.println("2.  mex.get() class is : " + mex.get().getClass());
                System.out.println("3.  Cat id is " + mex.get().getDescription());

                model.addAttribute("mexCategory", mex.get());
*
* */