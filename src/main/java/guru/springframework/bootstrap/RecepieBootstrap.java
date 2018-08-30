package guru.springframework.bootstrap;

import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
public class RecepieBootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecepieBootstrap(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData(){
        /* Ingredients */
        Set<Ingredient> ingredients= new HashSet<>();

        Ingredient avocado = new Ingredient();
        avocado.setAmount(new BigDecimal("0.5"));
        avocado.setDescription("KosherSalt");
        avocado.setUom(unitOfMeasureRepository.findByDescription("Teaspoon").get());
        ingredients.add(avocado);

        Recipe guacamole = new Recipe();
        guacamole.setDescription("guacamole");

        guacamole.setIngredients(ingredients);
        avocado.setRecipe(guacamole);

        recipeRepository.save(guacamole);

    }
}
