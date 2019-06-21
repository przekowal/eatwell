package pl.eatwell.services.springDataJpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.eatwell.model.Recipe;
import pl.eatwell.repositories.FoodRepository;
import pl.eatwell.repositories.RecipeRepository;
import pl.eatwell.repositories.UserRepository;
import pl.eatwell.services.RecipeService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class RecipeJpaService implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeJpaService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
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

        if(recipe.getIngredients() == null || recipe.getUser() == null ){
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
}
