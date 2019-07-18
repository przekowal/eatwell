package pl.eatwell.services.springDataJpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.eatwell.commands.RecipeCommand;
import pl.eatwell.converters.RecipeCommandToRecipe;
import pl.eatwell.converters.RecipeToRecipeCommand;
import pl.eatwell.model.Recipe;
import pl.eatwell.repositories.RecipeRepository;
import pl.eatwell.services.RecipeService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
@Slf4j
public class RecipeJpaService implements RecipeService {

    private final RecipeRepository recipeRepository;
    //TODO check
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeJpaService(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> findAll() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long aLong) {
        //TODO refactor to not use null
        return recipeRepository.findById(aLong).orElse(null);
    }

    @Override
    public Recipe save(Recipe recipe) {
        // || recipe.getUser() == null
        if(recipe.getIngredients() == null){
            throw new RuntimeException("Ingredien and Owner is required");
        }

        return recipeRepository.save(recipe);
    }

    @Override
    public void delete(Recipe object) {
        recipeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        recipeRepository.deleteById(aLong);
    }

    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);
        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.info("Saved recipe: " + savedRecipe.getId());

        return recipeToRecipeCommand.convert(savedRecipe);
    }
}
