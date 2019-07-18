package pl.eatwell.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.eatwell.commands.RecipeCommand;
import pl.eatwell.model.Recipe;

import java.time.Duration;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final IngredientToIngredientCommand ingredientConverter;
    private final RecipeTypeToRecipeTypeCommand recipeTypeConverter;
    private final DirectionsToDirectionsCommand directionsConverter;
    private final UserToUserCommand userConverter;

    public RecipeToRecipeCommand(IngredientToIngredientCommand ingredientConverter,
                                 RecipeTypeToRecipeTypeCommand recipeTypeConverter,
                                 DirectionsToDirectionsCommand directionsConverter,
                                 UserToUserCommand userConverter) {
        this.ingredientConverter = ingredientConverter;
        this.recipeTypeConverter = recipeTypeConverter;
        this.directionsConverter = directionsConverter;
        this.userConverter = userConverter;
    }
    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if(source == null){
            return null;
        }
        RecipeCommand recipeCommand= new RecipeCommand();
        recipeCommand.setId(source.getId());
        recipeCommand.setName(source.getName());
        if(source.getIngredients() != null && source.getIngredients().size() > 0){
            source.getIngredients()
                    .forEach(ingredient -> recipeCommand.getIngredients()
                            .add(ingredientConverter.convert(ingredient)));
        }
        recipeCommand.setPreparationTime((int)source.getPreparationTime().toMinutes());
        recipeCommand.setCookingTime((int)source.getPreparationTime().toMinutes());
        recipeCommand.setSourceUrl(source.getSourceUrl());
        if(source != null && source.getRecipeTypes() != null && source.getRecipeTypes().size() > 0){
            source.getRecipeTypes()
                    .forEach(recipeType -> recipeCommand.getRecipeTypes()
                    .add(recipeTypeConverter.convert(recipeType)));
        }
        recipeCommand.setDifficulty(source.getDifficulty());
        recipeCommand.setDirections((directionsConverter.convert(source.getDirections())));
        /*if(source.getUser() != null){
            recipeCommand.setUser(userConverter.convert(source.getUser()));
        }*/

        return recipeCommand;
    }
}
