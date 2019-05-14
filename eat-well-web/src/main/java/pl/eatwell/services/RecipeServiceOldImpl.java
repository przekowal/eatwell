package pl.eatwell.services;

import org.springframework.stereotype.Service;
import pl.eatwell.model.Recipe;

@Service
public class RecipeServiceOldImpl implements RecipeServiceOld {

    private final Recipe recipe;

    public RecipeServiceOldImpl() {
        this.recipe = new Recipe();
    }

    @Override
    public String makeRandomRecipe() {
        getRandomRecipe();
        return recipe.getName();
    }

    public void getRandomRecipe(){
        recipe.setName("Kurczak z frytkami");
        recipe.setDescription("Danie dnia");
    }


}
