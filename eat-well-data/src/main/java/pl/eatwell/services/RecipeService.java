package pl.eatwell.services;

import pl.eatwell.commands.RecipeCommand;
import pl.eatwell.model.Recipe;

public interface RecipeService extends CrudService<Recipe, Long> {

    RecipeCommand saveRecipeCommand(RecipeCommand command);

}
