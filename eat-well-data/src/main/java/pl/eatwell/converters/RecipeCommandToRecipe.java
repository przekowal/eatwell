package pl.eatwell.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import pl.eatwell.commands.RecipeCommand;
import pl.eatwell.model.Recipe;

import java.time.Duration;

public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final IngredientCommandToIngredient ingredientConverter;
    private final RecipeTypeCommandToRecipeType recipeTypeConverter;
    private final DirectionsCommandToDirections directionsConverter;
    private final UserCommandToUser userConverter;

    public RecipeCommandToRecipe(IngredientCommandToIngredient ingredientConverter,
                                 RecipeTypeCommandToRecipeType recipeTypeConverter,
                                 DirectionsCommandToDirections directionsConverter,
                                 UserCommandToUser userConverter) {
        this.ingredientConverter = ingredientConverter;
        this.recipeTypeConverter = recipeTypeConverter;
        this.directionsConverter = directionsConverter;
        this.userConverter = userConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if(source == null){
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setName(source.getName());
        if(source.getIngredients() != null && source.getIngredients().size() > 0){
            source.getIngredients()
                    .forEach(ingredientCommand -> recipe.getIngredients()
                            .add(ingredientConverter.convert(ingredientCommand)));
        }
        recipe.setPreparationTime(Duration.ofMinutes(source.getPreparationTime()));
        recipe.setCookingTime(Duration.ofMinutes(source.getCookingTime()));
        recipe.setSourceUrl(source.getSourceUrl());
        recipe.setImageUrl(source.getSourceUrl());
        if(source.getRecipeTypes() != null && source.getRecipeTypes().size() > 0){
            source.getRecipeTypes()
                    .forEach(recipeTypeCommand -> recipe.getRecipeTypes()
                    .add(recipeTypeConverter.convert(recipeTypeCommand)));
        }
        recipe.setDifficulty(source.getDifficulty());
        recipe.setDirections(directionsConverter.convert(source.getDirections()));
        recipe.setUser(userConverter.convert(source.getUser()));
        return recipe;
    }
}
