package pl.eatwell.services;

import pl.eatwell.model.Ingredient;

public interface IngredientService extends CrudService<Ingredient, Long>  {

    Ingredient findByName(String name);
}
